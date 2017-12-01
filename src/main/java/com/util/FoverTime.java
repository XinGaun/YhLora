package com.util;

/**
 * 
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

/**
 * @说明：时间工具类
 * 
 */
public class FoverTime {
	
	/**
	 * 切换时间格式
	 * @param date 未初始化时间格式
	 * @return 返回一个初始化过的时间格式
	 */
	public static String dateToString(Date date){
		SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=time.format(date);
		return dateStr;
	}
	/**
	 * 切换时间格式
	 * @param date String时间格式
	 * @return 返回一个初始化过的时间格式
	 */
	public static Date stringToDate(String date){
		Date strDate=null;
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
		try {
			strDate=time.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDate;
	}
	/**
	 * 转换数据库格式
	 * @param date String类型时间
	 * @return 返回一个SQL类型的时间格式
	 */
	public static java.sql.Date stringToSqlDate(String date){
		Date strDate=null;
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
		try {
			strDate=time.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(strDate.getTime());
	}
	/**
	 * 当前时间自动加一天
	 * @param 
	 * @return 返回一个当前时间的后一天时间格式
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, +1);//+1今天的时间加一天
		date = calendar.getTime();
		return date;
	}
	/**
	 * 返回一个PrintWriter
	 * @return
	 */
	public static PrintWriter getOut(HttpServletResponse resp){
		
		try {
			return resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				resp.getWriter().flush();
				resp.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
