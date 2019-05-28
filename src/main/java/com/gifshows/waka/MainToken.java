package com.gifshows.waka;

import java.util.regex.Pattern;


import java.util.regex.Matcher;

public class MainToken {
	//@link https://www.cnblogs.com/speeding/p/5097790.html
	//@link https://blog.csdn.net/u012145252/article/details/80628451
	private static final Pattern httpLinkPattern = Pattern.compile("https{0,1}[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String gifshowShareLink = "济公模仿秀【胶水哥】发了一个快手作品，一起来看！ http://www.gifshow.com/s/yvEcB84Z 复制此链接，打开【快手】直接观看！";
		String shareLink = "";
		Matcher matcher = httpLinkPattern.matcher(gifshowShareLink);
		if(matcher.find()) {
			if(matcher.groupCount() > 0) {
				shareLink = matcher.group(0);
				System.out.println("match one:" + matcher.group(0));
			}
		}else {
			System.out.println("no match");
		}
		
		if(!shareLink.isEmpty()) {
			System.out.println("need get PhotoIds param");
			//获取photoId
		}
		
	}

}
