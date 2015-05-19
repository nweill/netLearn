package fingerPrint;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import org.junit.Test;

import com.google.common.collect.Lists;

public class DistributionTest {

	@Test
	public void test() {
		List<Double> l = Lists.newArrayList();
		Random r = new Random(0);
		for (int i = 0 ; i< 100 ; i++)
			l.add(0.5*r.nextGaussian()+4);
		
		TreeMap<Double, Integer> beans = Distribution.generateBeans(l);
		System.out.println(beans);
		Distribution d = new Distribution(l,beans, true);
		System.out.println(d);
		d = new Distribution(l,beans, false);
		System.out.println(d);
	}

}
