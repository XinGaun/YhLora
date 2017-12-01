package com.util;

import java.util.ArrayList;
import java.util.HashMap;

public class Count {
	public static ArrayList<HashMap<String,Object>> count(ArrayList<HashMap<String,Object>> list,int count,HashMap<String,Object> hashMap){
		if(count>0){
			int page = Integer.parseInt(hashMap.get("page").toString());
			int counts = count/page;
			if(counts==0){
				counts =counts+1;
			}
			if(count%page>0&&count>page){
				counts =counts+1;
			}

			hashMap.put("count",counts);
			list.add(hashMap);
		}else{
			list.add(hashMap);
		}
		return list;

	}
}
