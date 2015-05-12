package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Assert;

import com.google.common.collect.Lists;

import network.Edge;
import network.EdgeInfo;
import network.Network;
import network.NetworkInfo;
import network.Node;
import network.NodeInfo;

public class Dijkstra
{
	public static void computePaths(Network net,Node s)
	{
		Assert.assertTrue(net.getNodes().contains(s));
		Node source = net.getNodes().get(net.getNodes().indexOf(s));
		net.initializeMinDist();
		source.minDistance = 0.;
		PriorityQueue<Node> vertexQueue = new PriorityQueue<Node>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Node u = vertexQueue.poll();
			// Visit each edge exiting u
			for (Edge e : u.adjacencies)
			{
				Node v = e.getTarget();
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);
					v.minDistance = distanceThroughU ;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Node> getShortestPathTo(Node t,Network net)
	{
		Assert.assertTrue(net.getNodes().contains(t));
		Node target = net.getNodes().get(net.getNodes().indexOf(t));
		List<Node> path = new ArrayList<Node>();
		for (Node vertex = target; vertex != null; vertex = vertex.previous){
			path.add(vertex);
		}
		Collections.reverse(path);
		return path;
	}

	
}
