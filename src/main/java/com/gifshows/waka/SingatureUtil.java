package com.gifshows.waka;

import java.net.URLDecoder;
import java.util.*;

import com.kwai.chat.a.d.StringUtils;
import com.kwai.sdk.f.Md5Util;
/**
 * 尝试 gifshow sign
 * @author wakasann<wakasann@sohu.com>
 * 
 * @link https://blog.csdn.net/u010814849/article/details/88207931 
 */
public class SingatureUtil {
	
	private static final String FANS_SALT = "382700b563f4";
	
	public static String genSignature(Map<String,String> params,String salt) {
        if(params == null){
            return null;
        }
        String sign = "";
        StringBuffer sb = new StringBuffer();
        try {
            // 1. 字典升序排序
            SortedMap<String,String> sortedMap = new TreeMap<>(params);
            // 2. 拼按URL键值对
            Set<String> keySet = sortedMap.keySet();
            for(String key : keySet){
                //sign不参与算法
                if(key.equals("sig") || key.equals("__NStokensig")){
                    continue;
                }
                String value = sortedMap.get(key);
                sb.append(key + "=" + URLDecoder.decode(value,"UTF-8"));
            }
            String uriString = sb.toString();
            uriString = uriString + salt;
            System.out.println("My String: \n" + uriString);
            // 3. MD5运算得到请求签名
            sign = Md5Util.md5(uriString);
            System.out.println("My Sign:\n" +sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }

    public static Map<String,String> getMapFromStr(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        String[] arr = str.split("\\&");
        Map<String,String> map = new HashMap<>();
        for(String item : arr){
            String[] itemArr = item.split("=",2);
            map.put(itemArr[0],itemArr[1]);
        }
        return map;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String srcStr = "app=0&lon=104.073269&did_gt=1551777466213&c=XIAOMI&sys=ANDROID_4.4.4&isp=&mod=Xiaomi%28MI%203%29&did=ANDROID_b07d34ee8ff226b0&hotfix_ver=&ver=6.1&net=WIFI&country_code=cn&iuid=&appver=6.1.2.8197&max_memory=192&oc=XIAOMI&ftt=&kpn=KUAISHOU&ud=1273257807&language=zh-cn&kpf=ANDROID_PHONE&lat=30.537794&user=74476707&token=6f8b8954c34e4462a1c0117ac5a5af21-1273257807&os=android&client_key=3c2cd3f3&sig=8ab207f1762b17b47d1ca0cc26ce6576&__NStokensig=334b7f77f9fec536c1dce00467f8cf79bed4f66cd8a24ffc205b3e1a151ab1e7";
		
        genSignature(getMapFromStr(srcStr),FANS_SALT);
        
        String queryString = "app=0&kpf=ANDROID_PHONE&ver=6.5&c=HUAWEI_KWAI&mod=HUAWEI%28COR-AL10%29&appver=6.5.3.9366&ftt=&isp=CTCC&kpn=KUAISHOU&lon=114.146495&language=zh-cn&sys=ANDROID_9&max_memory=384&ud=559580078&country_code=cn&oc=HUAWEI_KWAI&hotfix_ver=&did_gt=1557366744252&iuid=&net=WIFI&did=ANDROID_6b475c191f8d3c1c&lat=22.611695";
        //response sig:sig=411d761a6ce189177fee906d0062f10b&client_key=3c2cd3f3&os=android&__NStokensig=c4f6eb423798cb38c15672b0a84ddfd6bffdccc65603ff67c104e6bf6d16168f
        genSignature(getMapFromStr(queryString),FANS_SALT);

	}

}
