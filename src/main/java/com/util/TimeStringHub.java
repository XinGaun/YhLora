package com.util;

import java.util.ArrayList;
import java.util.HashMap;
@SuppressWarnings("all")
public  class TimeStringHub {
	public static  ArrayList<HashMap<String,Object>> TimeStringMeter(ArrayList<HashMap<String,Object>> list){
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).get("date")!=null){
					String date = list.get(i).get("date").toString();
					list.get(i).put("date",date);
				}
			}
		}
		return list;
	}
	
	public static ArrayList<HashMap<String,Object>> TimeStringHub(ArrayList<HashMap<String,Object>> list){
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).get("date")!=null){
					String date = list.get(i).get("date").toString();
					list.get(i).put("date",date);
				}
				if(list.get(i).get("reset_time")!=null){
					String reset_time = list.get(i).get("reset_time").toString();
					list.get(i).put("reset_time", reset_time);
				}
				if(list.get(i).get("login")!=null){
					String login = list.get(i).get("login").toString();
					list.get(i).put("login", login);
				}
				if(list.get(i).get("logout")!=null){
					String logout = list.get(i).get("logout").toString();
					list.get(i).put("logout", logout);
				}
				if(list.get(i).get("keepalive")!=null){
					String keepalive = list.get(i).get("keepalive").toString();
					list.get(i).put("keepalive", keepalive);
				}					
			}		
		}
		return list;
	}
	public static ArrayList<HashMap<String,Object>> BitLOW(ArrayList<HashMap<String,Object>> list){
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).get("ch_sprf")!=null&&list.get(i).get("ch_sprf")!=""){
					String sa=list.get(i).get("ch_sprf")+"";
					/*byte low = (byte)(a & 0xff);
					byte hig = (byte)(a>>8); */
					list.get(i).put("ch","0x"+sa.substring(0,2));
					list.get(i).put("sprf","0x"+sa.substring(2,4));
				}
			}
			return list;
		}else{
			return list;
		}		
	}
	public static String toHexString(String s) {  
	    String str = "";  
	    for (int i = 0; i < s.length(); i++) {  
	        int ch = (int) s.charAt(i);  
	        String s4 = Integer.toHexString(ch);  
	        str = str + s4;  
	    }  
	    return str;  
	} 
}
