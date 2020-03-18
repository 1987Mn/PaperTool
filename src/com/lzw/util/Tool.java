package com.lzw.util;

import java.util.ArrayList;

import javax.swing.JTable;

public class Tool {

	public static <T> ArrayList<T> getTable(JTable table,ArrayList<T> list) {
		
		return list;
	}

	public static String fM(Double d) {
		return String.format("%.2f", d);
	}
	
	public static boolean isEmpty(String s) {
		
		if(s!=null) {
			if(!s.equals("")) {
				return false;
			}
		}
		return true;
	}
	public static boolean isEmpty(Object s) {
		if(s!=null) {
			if(!s.toString().equals("")) {
				return false;
			}
		}
		return true;
	}
	
	public String zh(int i) {

		String s = null;

		switch (i) {
		case 1:
			s = "一";
			break;
		case 2:
			s = "二";
			break;
		case 3:
			s = "三";
			break;
		case 4:
			s = "四";
			break;
		case 5:
			s = "五";
			break;
		case 6:
			s = "六";
			break;
		case 7:
			s = "七";
			break;
		case 8:
			s = "八";
			break;
		case 9:
			s = "九";
			break;
		case 10:
			s = "十";
			break;
		}
		return s;
	}
	
	
}
