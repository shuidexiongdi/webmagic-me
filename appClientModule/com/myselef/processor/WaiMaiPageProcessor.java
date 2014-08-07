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
	 * �Ƿ�Ϊ����������
	 * @param page
	 * @return
	 */
	abstract boolean isDistictUrl(Page page);
	/**
	 * �Ƿ�Ϊ�̼ҵ�����
	 * @param page
	 * @return
	 */
	abstract boolean isRestaurantUrl(Page page);
	/**
	 * �Ƿ�Ϊ��Ʒ������
	 * @param page
	 * @return
	 */
	abstract boolean isFoodUrl(Page page);
	/**
	 * �������Ϣ��ȡ����
	 * @param page
	 * @return
	 */
	abstract void districtProcess(Page page);
	/**
	 * �̼ҵ���Ϣ��ȡ����
	 * @param page
	 * @return
	 */
	abstract void restaurantProcess(Page page);
	/**
	 * ��Ʒ����Ϣ��ȡ����
	 * @param page
	 * @return
	 */
	abstract void foodProcess(Page page);


}
