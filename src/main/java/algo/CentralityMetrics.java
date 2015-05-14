package algo;

import java.util.List;

import network.Edge;
import network.Network;
import network.Node;
import util.Util;


public class CentralityMetrics {
	
	public static List<Double> getOutDegrees(Network net){
		double[] degrees = new double[net.getNodes().size()];
		for (Edge e : net.getEdges())
			degrees[e.getSource().getId()]++;
		return Util.listFromArray(degrees);
	}
	
	public static List<Double> getInDegrees(Network net){
		double[] degrees = new double[net.getNodes().size()];
		for (Edge e : net.getEdges())
			degrees[e.getTarget().getId()]++;
		return Util.listFromArray(degrees);
	}
	
	public static List<Double> getDegrees(Network net){
		double[] degrees = new double[net.getNodes().size()];
		for (Edge e : net.getEdges()){
			degrees[e.getTarget().getId()]++;
			degrees[e.getSource().getId()]++;
		}
		return Util.listFromArray(degrees);
	}
	
	// a modifier
	public static List<Double> getBetweenesCentrality(Network net){
		double[] betCen = new double[net.getNodes().size()];
		for (Node s: net.getNodes()){
			
			Dijkstra.computePaths(net, s);
			for (Node t : net.getNodes()){
				
				List<Node> path = Dijkstra.getShortestPathTo(t, net);
				for (int i = 1 ; i < path.size()-1 ;i++){
					betCen[path.get(i).getId()]++;
				}
			}
		}
		
		return Util.listFromArray(betCen);
	}
	
	

}
