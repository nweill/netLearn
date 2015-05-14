package util;

import java.util.List;

import com.google.common.collect.Lists;

public class Util {
	public static List<Double> listFromArray(double[] doubles){
		List<Double> res = Lists.newArrayList();
		for (double d : doubles)
			res.add(d);
		return res;
	}
	
	public static List<Double> listOf(int n){
		List<Double> res = Lists.newArrayList();
		for (double i = 0 ; i< n ;i++)
			res.add(i);
		return res;
	}
}
