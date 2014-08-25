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
	 * if this page is district URL ,return true,else return false;
	 * @param page
	 * @return
	 */
	abstract boolean isDistictUrl(Page page);
	/**
	 * if this page is restaurant URL ,return true,else return false;
	 * @param page
	 * @return
	 */
	abstract boolean isRestaurantUrl(Page page);
	/**
	 * if this page is food URL ,return true,else return false;
	 * @param page
	 * @return
	 */
	abstract boolean isFoodUrl(Page page);
	/**
	 * if this page is district URL, then run this method;
	 * @param page
	 * @return
	 */
	abstract void districtProcess(Page page);
	/**
	 * if this page is restaurant URL, then run this method;
	 * @param page
	 * @return
	 */
	abstract void restaurantProcess(Page page);
	/**
	 * if this page is food URL, then run this method;
	 * @param page
	 * @return
	 */
	abstract void foodProcess(Page page);


}
