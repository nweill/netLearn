package io;

import java.io.IOException;
import java.util.List;

import network.Network;
import network.Node;
import network.NodeInfo;

import org.junit.Assert;
import org.junit.Test;

import algo.Dijkstra;

public class NetParserTest {

	@Test
	public void test() {
		NetParser parser = new NetParser("./src/test/resources/net.txt");
		try {
			parser.parseTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Network net = parser.build();
	
		Dijkstra.computePaths(net, new Node(new NodeInfo("1"),1));
		List<Node> path=Dijkstra.getShortestPathTo(new Node(new NodeInfo("45"),1),net);
		Dijkstra.computePaths(net, new Node(new NodeInfo("45"),1));
		List<Node> back=Dijkstra.getShortestPathTo(new Node(new NodeInfo("1"),1),net);
		System.out.println(path);
		System.out.println(back);
		System.out.println(path.size()+back.size());
		Assert.assertEquals(path.size()+back.size(), 18,0);
	}

}
