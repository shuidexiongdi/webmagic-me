package com.myselef.spiderlistener;

import java.util.Map;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.SpiderListener;

public class DefaultAbstractListener implements SpiderListener {

	@Override
	public void onSuccess(Request request) {
		onSuccess(request.getResultItems());
		
	}
	
	@Override
	public void  onError(Request request) {
		//do nothing;
	}
	
	void onSuccess(ResultItems resultItems) {
		for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
	}

}
