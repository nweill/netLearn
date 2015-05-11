package network;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class NetworkTest {

	@Test
	public void test() {
		List<Node> nodes = Lists.newArrayList();
		for (int i = 0; i < 10; i++) {
			nodes.add(new Node(new NodeInfo("ID" + i), i));
		}
		List<Edge> edges = Lists.newArrayList();
		Random r = new Random(0);
		for (int i = 0; i < 15; i++) {
			edges.add(
					new Edge(
							true, 
							nodes.get(r.nextInt(nodes.size())),
							nodes.get(r.nextInt(nodes.size())),
							new EdgeInfo("Edge"+i)
							)
			);
		}
		
		Network net = new Network(new NetworkInfo("net1"), nodes, edges);
		System.out.println(net.getMatN(1));
		System.out.println(net.getMatN(200));
		System.out.println(net.getMatN(0));
		System.out.println(net.getMatN(20));
		Assert.assertEquals(19.0, net.getMatN(20).get(5, 8),0.0);

	}

}
