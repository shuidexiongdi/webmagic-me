package com.myselef.processor;

import java.util.List;

import com.myselef.constants.Constant;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class MeituanWaimaiPageProcessor extends WaiMaiPageProcessor implements
		PageProcessor {
	
	private final static String URL_DISTRICT = "http://www.waimai.meituan.com/shenzhen";
	private final static String URL_RESTAURANT = "http://www.waimai.meituan.com/home/\\w+";
	private final static String URL_RESTAURANT2 = "http://www.waimai.meituan.com/geo/geohash\\?.*";
	private final static String URL_FOOD = "http://www.waimai.meituan.com/restaurant/\\w+";
	
	private Site site = Site.me().setRetryTimes(3).setSleepTime(0).setUserAgent(
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	boolean isDistictUrl(Page page) {
		return page.getUrl().regex(URL_DISTRICT).match();
	}

	@Override
	boolean isRestaurantUrl(Page page) {
		return page.getUrl().regex(URL_RESTAURANT).match() || page.getUrl().regex(URL_RESTAURANT2).match();
	}

	@Override
	boolean isFoodUrl(Page page) {
		return page.getUrl().regex(URL_FOOD).match();
	}

	void districtProcess(Page page) {
		//地区
		List<String> districtUrls = page.getHtml().css("ul.district-list").links().regex(".*/geo/geohash\\?.*").all();
		page.addTargetRequests(districtUrls);
//		page.putField("district", page.getHtml().xpath("//ul[@class='district-list']/li/a/text()").all().toString());
	}
	
	void restaurantProcess(Page page) {
//		//商家
		List<String> restaurantUrls = page.getHtml().css("a.rest-atag").links().regex(".*/restaurant/.*").all();
		page.addTargetRequests(restaurantUrls);		
//		page.putField("restaurant", page.getHtml().xpath("//div[@class='ori-foodtype-nav']/ul/li/a/title").all());
	}
	
	void foodProcess(Page page) {
		//菜品
		page.putField(Constant.RESTAURANT, page.getHtml().xpath("//div[@class='na']/a/span/text()").all());
		page.putField(Constant.FOODTYPES, page.getHtml().xpath("//div[@class='ori-foodtype-nav']/ul/li/a/@title").all());
//		page.putField("foodtype", page.getHtml().xpath("//div[@class='food-nav']//div[@class='category']/h3/span/text()").all());
		page.putField(Constant.FOOD, page.getHtml().xpath("//div[@class='fl description']//div[@class='na nodesc']/@title").all());
		page.putField(Constant.PRICE, page.getHtml().xpath("//div[@class='fr unit-price']/text()").all());
		
//		Foods foods = new Foods();
//		foods.setRestaurant(page.getHtml().xpath("//div[@class='na']/a/span/text()").all().toString());
//		foods.setFoodtypes(page.getHtml().xpath("//div[@class='ori-foodtype-nav']/ul/li/a/@title").all().toString());
//		foods.setFood(page.getHtml().xpath("//div[@class='fl description']//div[@class='na nodesc']/@title").all().toString());
//		foods.setPrice(page.getHtml().xpath("//div[@class='fr unit-price']/text()").all().toString());
//		page.putField("foods", foods);
	
	}

}
