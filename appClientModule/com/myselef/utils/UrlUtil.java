package com.myselef.utils;

public class UrlUtil {
	
	//end with jpg|jpeg|bmp|gif|png，no care lower or upper((?i:xxxxxx))，and no care if start with.
	public static final String PICTURE_REGEX = ".*?\\.(?i:(jpg|jpeg|bmp|gif|png))$";  
	
	//start with http|https，behide with ://，
	public static final String ABSOLUTE_REGEX = "^[http://|https://].*?";//[//w//.//-/:]+
	
	/**
	 * is Absolute Url, start with http|https
	 * @param url
	 * @return
	 */
	public static boolean isAbsoluteUrl(String url) {
		return url.matches(ABSOLUTE_REGEX);
	}
	
	/**
	 * is image Url end with jpg|jpeg|bmp|gif|png
	 * @param url
	 * @return
	 */
	public static boolean isAPictureUrl(String url) {
		return url.matches(PICTURE_REGEX);
	}
	
	/**
	 * is image absolute url, start with http|https, end with jpg|jpeg|bmp|gif|png
	 * @param url
	 * @return
	 */
	public static boolean isAPictureAbsoluteUrl(String url) {
		return isAbsoluteUrl(url) && isAPictureUrl(url);
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(isAPictureUrl("33xxx.jpg"));
//		System.out.println(isAPictureUrl("33.xxx.jPg"));
//		System.out.println(isAbsoluteUrl("http://ddd"));
//		System.out.println(isAbsoluteUrl("2http2://ddd"));
//		System.out.println(isAPictureUrl("http://affiliates.mature-amateur-interracial.com/free/2398/pictures/38304.jpg"));
//		System.out.println(isAbsoluteUrl("http://affiliates.mature-amateur-interracial.com/free/2398/pictures/38304.jpg"));
//		System.out.println(isAPictureAbsoluteUrl("http://affiliates.mature-amateur-interracial.com/free/2398/pictures/38304.jpg"));
//		System.out.println(isAPictureAbsoluteUrl("http://img123.laodabo.com:808/allimg/c120114/132A20F3J3F-344527.jpg"));
//	}
	
}