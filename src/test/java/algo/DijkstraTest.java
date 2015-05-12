package algo;


import java.util.List;

import network.Edge;
import network.EdgeInfo;
import network.Network;
import network.NetworkInfo;
import network.Node;
import network.NodeInfo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class DijkstraTest {

	@Test
	public void test() {
		List<Node> nodes = Lists.newArrayList();
		nodes.add( new Node(new NodeInfo("Redvile"),0));
		nodes.add( new Node(new NodeInfo("Blueville"),1));
		nodes.add( new Node(new NodeInfo("Greenville"),2));
		nodes.add( new Node(new NodeInfo("Orangeville"),3));
		nodes.add(new Node(new NodeInfo("Purpleville"),4));

		List<Edge> edges = Lists.newArrayList();

		edges.add( new Edge(true , nodes.get(0),nodes.get(1), new EdgeInfo((nodes.get(0)+"-"+nodes.get(1))),5));
		edges.add( new Edge(true , nodes.get(0),nodes.get(2), new EdgeInfo((nodes.get(0)+"-"+nodes.get(2))),10));
		edges.add( new Edge(true , nodes.get(0),nodes.get(3), new EdgeInfo((nodes.get(0)+"-"+nodes.get(3))),8));

		edges.add( new Edge(true , nodes.get(1),nodes.get(0), new EdgeInfo((nodes.get(1)+"-"+nodes.get(0))),5));
		edges.add( new Edge(true , nodes.get(1),nodes.get(2), new EdgeInfo((nodes.get(1)+"-"+nodes.get(2))),3));
		edges.add( new Edge(true , nodes.get(1),nodes.get(4), new EdgeInfo((nodes.get(1)+"-"+nodes.get(4))),7));

		edges.add( new Edge(true , nodes.get(2),nodes.get(0), new EdgeInfo((nodes.get(2)+"-"+nodes.get(0))),10));
		edges.add( new Edge(true , nodes.get(2),nodes.get(1), new EdgeInfo((nodes.get(2)+"-"+nodes.get(1))),3));

		edges.add( new Edge(true , nodes.get(3),nodes.get(0), new EdgeInfo((nodes.get(3)+"-"+nodes.get(0))),8));
		edges.add( new Edge(true , nodes.get(3),nodes.get(4), new EdgeInfo((nodes.get(3)+"-"+nodes.get(4))),2));

		edges.add( new Edge(true , nodes.get(4),nodes.get(1), new EdgeInfo((nodes.get(4)+"-"+nodes.get(1))),7));
		edges.add( new Edge(true , nodes.get(4),nodes.get(3), new EdgeInfo((nodes.get(4)+"-"+nodes.get(3))),2));

		Network net = new Network(new NetworkInfo("net-N-"+nodes.size()+"-E-"+edges.size()), nodes, edges);
		Node n = nodes.get(nodes.indexOf( new Node(new NodeInfo("Purpleville"),2)));
		Node v = nodes.get(nodes.indexOf( new Node(new NodeInfo("Greenville"),1)));
		System.out.println(n);
		Dijkstra.computePaths(net,n);

		System.out.println("from "+n+" to " + v + ": " + v.minDistance);
		
		List<Node> path = Dijkstra.getShortestPathTo(v,net);
		System.out.println("Path: " + path);
		Assert.assertEquals("[Purpleville, Blueville, Greenville]", ""+path);
		Assert.assertEquals(10.0,v.minDistance,0.0);

	}

}
