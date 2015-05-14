package algo;

import io.NetParser;

import java.io.IOException;
import java.util.List;

import network.Network;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.junit.Assert;
import org.junit.Test;


public class CentralityMetricsTest {
	static Network net;
	static{
		NetParser parser = new NetParser("./src/test/resources/net.txt");
		try {
			parser.parseTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		net = parser.build();
	
	}

	@Test
	public void test1() {
		
		List<Double> degsOut = CentralityMetrics.getOutDegrees(net);
		System.out.println(degsOut);
		List<Double> degsIn = CentralityMetrics.getInDegrees(net);
		System.out.println(degsIn);
		List<Double>degs = CentralityMetrics.getDegrees(net);
		System.out.println(degs);
		
		Assert.assertEquals(degsIn.get(10)+degsOut.get(10), degs.get(10),0);
	}
	
	@Test
	public void test2() {
		
		List<Double> betCen = CentralityMetrics.getBetweenesCentrality(net);
		DescriptiveStatistics ds = new DescriptiveStatistics();
		for (Double d: betCen)
			ds.addValue(d);

		System.out.println(ds.toString());

	}

}
