package com.kwai.chat.a.d;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;



public final class StringUtils {
	public static final Pattern a = Pattern.compile("\\s+");
	
	public static Boolean isEmpty(String str) {
        return str == null ? true : false;
    }

}
