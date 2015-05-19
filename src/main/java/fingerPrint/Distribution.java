package fingerPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.junit.Assert;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Distribution {
	private List<Double> values;
	private TreeMap<Double,Integer> beans;
	
	private List<Double> distribution = Lists.newArrayList();
	private boolean frequency;
	

	public static TreeMap<Double,Integer>generateBeans(List<Double> values){
		int numOfBeans =(int)( 1+3.3*Math.log(values.size()));
		return generateBeans(values,numOfBeans);
		
	}
	
	public static TreeMap<Double,Integer> generateBeans(double min, double max, int numOfBeans){
		TreeMap<Double,Integer>res = Maps.newTreeMap();
		
		double range = (max-min)/numOfBeans;
		for (int i = 0 ; i<numOfBeans ; i++){
			res.put(min +i*range,i);
		}
		return res;
	}
	
	public static TreeMap<Double,Integer> generateBeans(List<Double> values,int numOfBeans){
		DescriptiveStatistics ds = new DescriptiveStatistics();
		for (Double d : values)
			ds.addValue(d);
		return generateBeans(ds.getMin(),ds.getMax(),numOfBeans);
		
	}
	
	
	public Distribution(List<Double> values,TreeMap<Double,Integer> beans,boolean frequency){
		Assert.assertTrue(beans.size()>1);
		this.values = values;
		this.beans = beans;
		this.frequency = frequency;
		this.create();
		
	}
	
	public List<Double> getDistribution() {
		return distribution;
	}

	private void create(){
		
		for (int i = 0 ; i < beans.size()  ; i++)
			distribution.add(0.0);
		for (Double d : values){
			int id = beans.floorEntry(d).getValue();
			double old = this.distribution.get(id);
			this.distribution.set(id,old+1);
		}
		if (frequency)
			for (int i = 0 ; i< distribution.size() ; i++)
				this.distribution.set(i,this.distribution.get(i)/
						values.size());
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		List<Double> beanList = new ArrayList<Double>(beans.keySet()); 
		for (int i = 0 ; i < distribution.size() ; i++){
			sb.append(
					beanList.get(i) +  
					" : "+distribution.get(i)+"\n");
		}
		return sb.toString();
	}

}
