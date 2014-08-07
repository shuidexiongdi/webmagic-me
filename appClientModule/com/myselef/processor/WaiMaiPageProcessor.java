package com.myselef.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.processor.PageProcessor;

public abstract class WaiMaiPageProcessor implements PageProcessor {

	@Override
	public void process(Page page) {
		if(isDistictUrl(page)) {
			districtProcess(page);
		}
		if(isRestaurantUrl(page)) {
			restaurantProcess(page);
		}
		if(isFoodUrl(page)) {
			foodProcess(page);
		}

	}
	
	/**
	 * 是否为地区的链接
	 * @param page
	 * @return
	 */
	abstract boolean isDistictUrl(Page page);
	/**
	 * 是否为商家的链接
	 * @param page
	 * @return
	 */
	abstract boolean isRestaurantUrl(Page page);
	/**
	 * 是否为菜品的链接
	 * @param page
	 * @return
	 */
	abstract boolean isFoodUrl(Page page);
	/**
	 * 区域的信息抽取处理
	 * @param page
	 * @return
	 */
	abstract void districtProcess(Page page);
	/**
	 * 商家的信息抽取处理
	 * @param page
	 * @return
	 */
	abstract void restaurantProcess(Page page);
	/**
	 * 菜品的信息抽取处理
	 * @param page
	 * @return
	 */
	abstract void foodProcess(Page page);


}
