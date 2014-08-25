package com.myselef.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MeituanUrlLoader {
	
	private static Properties meituanProp = null;
	
	static {
		meituanProp = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir")+"\\meituanUrls.properties"));
			meituanProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			meituanProp = null;
		}
	}
	
	public static String[] getUrls() {
		if(meituanProp != null) {
			String urlString = meituanProp.getProperty("urls");
			if(urlString != null) {
				return urlString.split(";");
			}
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		System.out.println(MeituanUrlLoader.getUrls());
//	}

}
