package com.myselef;

import us.codecraft.webmagic.Spider;

import com.myselef.pipeline.SaveFilePipelineForMeituan;
import com.myselef.processor.MeituanWaimaiPageProcessor;

public class RunSpider {

	private static void runMeiTuan() {
		Spider.create(new MeituanWaimaiPageProcessor())
				.addPipeline(new SaveFilePipelineForMeituan("E:/spider/meituan"))
				.addUrl("http://www.waimai.meituan.com/shenzhen").thread(5)
				.run();

	}

	public static void main(String[] args) {
		runMeiTuan();
	}

}
