package com.myselef;

import us.codecraft.webmagic.Spider;

import com.myselef.config.MeituanUrlLoader;
import com.myselef.pipeline.SaveFilePipelineForMeituan;
import com.myselef.processor.MeituanWaimaiPageProcessor;

public class RunSpider {

	private static void runMeiTuan() {
		Spider.create(new MeituanWaimaiPageProcessor())
				.addPipeline(new SaveFilePipelineForMeituan("E:/spider/meituan"))
//				.addUrl("http://www.waimai.meituan.com/home/ws100yf41fuv")
				.addUrl(MeituanUrlLoader.getUrls())
				.thread(5)
				.run();

	}

	public static void main(String[] args) {
		runMeiTuan();
	}

}
