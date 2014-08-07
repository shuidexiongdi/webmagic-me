package com.myselef.utils;

import java.util.regex.Pattern;

public final class RegexUtil {
	
	
	public static int getIntFromString(String string) {
		 return Integer.valueOf(Pattern.compile("[^0-9]").matcher(string).replaceAll("").trim());
	}
}
