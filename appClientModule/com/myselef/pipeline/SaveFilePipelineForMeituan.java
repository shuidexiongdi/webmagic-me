package com.myselef.pipeline;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myselef.model.Food;
import com.myselef.model.RestarantFoods;
import com.myselef.utils.ResultItems2Foods;

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
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(getFile(path + DigestUtils.md5Hex(resultItems.getRequest().getUrl()) + ".txt")),"UTF-8"));
            printWriter.println("url:\t" + resultItems.getRequest().getUrl());
            RestarantFoods restarantFoods =  ResultItems2Foods.meituanFoods(resultItems);
            if(restarantFoods != null) {
	            printWriter.println(restarantFoods.getRestaurant());
	            for(Food food : restarantFoods.getFoods()) {
	            	printWriter.println(food.getFoodtypes()  + ":\t" + food.getFood()  + ":\t" + food.getPrice());
	            }
            }
            printWriter.close();
        } catch (IOException e) {
            logger.warn("write file error", e);
        }finally {
        }

	}

}
