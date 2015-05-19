package io;

import java.util.List;

public class FormatFP {
	
	public static String getHeader(int numCol,String sep){
		StringBuilder sb = new StringBuilder();
		sb.append("col0");
		for (int i = 1 ; i < numCol ; i++){
			sb.append(sep+"col"+i);
		}
		return sb.toString();
	}
	
	public static String list2String(List<Double> values,String sep){
		StringBuilder sb = new StringBuilder();
		sb.append(values.get(0));
		for (int i = 1 ; i < values.size() ; i++){
			sb.append(sep+values.get(i));
		}
		return sb.toString();
	}

}
