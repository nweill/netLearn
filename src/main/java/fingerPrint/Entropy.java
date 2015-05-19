package fingerPrint;

import java.util.List;

import com.google.common.collect.Lists;

public class Entropy {
	
	public static double entropyOf(List<Double> distribution,boolean freq){
		double res = 0;
		List<Double> dist = Lists.newArrayList();
		dist.addAll(distribution);
		if (!freq){
			double sum = 0;
			for (int i = 0 ;i < distribution.size() ; i++ )
				sum+=distribution.get(i);
			for (int i = 0 ;i < dist.size() ; i++ )
				dist.set(i, distribution.get(i)/sum);
			
		}
		for (double d : dist)
			if(d>0)
				res -= d*Math.log(d);
		
		return res;
		
	}

}
