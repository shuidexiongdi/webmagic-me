package com.myselef.pipeline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.Executors;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myselef.model.Food;
import com.myselef.model.RestarantFoods;
import com.myselef.utils.ImageDownloadHelper;
import com.myselef.utils.ResultItems2Foods;
import com.myselef.utils.UrlUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

public class SaveFilePipelineForMeituan extends FilePersistentBase implements Pipeline{
	
 private Logger logger = LoggerFactory.getLogger(getClass());
	 
	 public SaveFilePipelineForMeituan(String path) {
		 setPath(path);
	 }

	public void process(ResultItems resultItems, Task task) {
		String path = this.path + PATH_SEPERATOR + task.getUUID() + PATH_SEPERATOR;
        try {
        	RestarantFoods restarantFoods =  ResultItems2Foods.meituanFoods(resultItems);
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(getFile(path + File.separator + restarantFoods.getRestaurant() + File.separator + DigestUtils.md5Hex(resultItems.getRequest().getUrl()) + ".txt")),"UTF-8"));
            printWriter.println("url:\t" + resultItems.getRequest().getUrl());
            if(restarantFoods != null) {
	            printWriter.println(restarantFoods.getRestaurant());
	            printWriter.println(restarantFoods.getRestaurantImage());
	            for(Food food : restarantFoods.getFoods()) {
	            	printWriter.println(food.getFoodtypes()  + ":\t" + food.getFood()  + ":\t" + food.getPrice());
	            }
	            downLoadImage(restarantFoods.getRestaurant(),restarantFoods.getRestaurantImage());
            }
            printWriter.close();
        } catch (IOException e) {
            logger.warn("write file error", e);
        }finally {
        }

	}
	
	void downLoadImage(final String restaurantName, final String... imageUrls) {
		Executors.newFixedThreadPool(80).execute(new Runnable() {
			
			@Override
			public void run() {
				for(String imageUrl : imageUrls) {
					System.out.println(imageUrl);
					if(UrlUtil.isAPictureAbsoluteUrl(imageUrl)) {
						try {
							ImageDownloadHelper.getFileSaver(path+File.separator+restaurantName, imageUrl.substring(imageUrl.lastIndexOf("/")+1), imageUrl).save();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		});
	}

}
