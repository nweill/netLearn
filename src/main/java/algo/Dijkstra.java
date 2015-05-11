package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.google.common.collect.Lists;

import network.Edge;
import network.EdgeInfo;
import network.Network;
import network.NetworkInfo;
import network.Node;
import network.NodeInfo;

public class Dijkstra
{
	public static void computePaths(Network net,Node source)
	{
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

	public static List<Node> getShortestPathTo(Node target)
	{
		List<Node> path = new ArrayList<Node>();
		for (Node vertex = target; vertex != null; vertex = vertex.previous){
			
			path.add(vertex);
		}
		Collections.reverse(path);
		return path;
	}

	
}
