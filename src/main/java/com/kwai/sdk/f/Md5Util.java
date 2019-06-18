package com.kwai.sdk.f;
import java.security.MessageDigest;

public final class Md5Util {
	static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	 public static String md5(String str) {
	        try {
	            MessageDigest instance = MessageDigest.getInstance("MD5");
	            instance.update(str.getBytes());
	            byte[] digest = instance.digest();
	            StringBuilder stringBuilder = new StringBuilder();
	            for (int i : digest) {
	                int i2 = i;
	                if (i2 < 0) {
	                    i2 += 256;
	                }
	                if (i2 < 16) {
	                    stringBuilder.append("0");
	                }
	                stringBuilder.append(Integer.toHexString(i2));
	            }
	            return stringBuilder.toString();
	        } catch (Exception e) {
	            return null;
	        }
	    }
	 


}
