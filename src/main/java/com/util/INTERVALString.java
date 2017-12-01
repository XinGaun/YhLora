package com.util;


@SuppressWarnings("all")
public class INTERVALString {
	public static String INTERVALString(String str){
		//0 years 0 mons 0 days 0 hours 2 mins 40.00 secs
		//System.out.println(str);
		if(str!=null&&str!=""){
			str = str.replace(" ","");
			String years = str.substring(0,str.indexOf("years"));
			String mons = str.substring(str.indexOf("years")+5,str.indexOf("mons"));
			String days = str.substring(str.indexOf("mons")+4,str.indexOf("days"));
			String hours = str.substring(str.indexOf("days")+4,str.indexOf("hours"));
			String mins = str.substring(str.indexOf("hours")+5,str.indexOf("mins"));
			String secs = str.substring(str.indexOf("mins")+4,str.indexOf(".00secs"));
			int nian = 525600*Integer.parseInt(years);
			int yue = 43200*Integer.parseInt(mons);
			int ri = 1440*Integer.parseInt(days);
			int shi =60*Integer.parseInt(hours);
			int fen =Integer.parseInt(mins);
			Float miao = Float.parseFloat(secs);
			if(miao>0){
				miao=miao/60;
			}
			fen=nian+yue+ri+shi+fen;
			miao =fen+miao;
			str = miao+"";
			str =str.substring(0,str.indexOf(".")+2);
			return str;
		}else{
			return str;
		}
	}
}
