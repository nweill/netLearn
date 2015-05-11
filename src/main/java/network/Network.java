package network;

import java.util.List;

public class Network {
	private NetworkInfo netInfo;
	private List<Node> nodes;
	private List<Edge> edges;
	
	private Matrix connectivityMat;
	
	
	public NetworkInfo getNetInfo() {
		return netInfo;
	}
	public void setNetInfo(NetworkInfo netInfo) {
		this.netInfo = netInfo;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	public Network(NetworkInfo netInfo, List<Node> nodes, List<Edge> edges) {
		super();
		this.netInfo = netInfo;
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public boolean isOriented(){
		
		for (Edge e : edges){
			if (!e.isOriented())
				return false;
		}
		return true;
	}
	
	
	

	

}
