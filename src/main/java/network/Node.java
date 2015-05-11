package network;

import java.util.List;

public class Node {
	private List<Edge> edges;
	private NodeInfo info;
	
	public Node(List<Edge> edges, NodeInfo info) {
		super();
		this.edges = edges;
		this.info = info;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public NodeInfo getInfo() {
		return info;
	}

	public void setInfo(NodeInfo info) {
		this.info = info;
	}
	
	
	public boolean equals (Object o){
		if(o == null) 
			return false;
		if (o instanceof Node){
			Node n = (Node) o;
			if (n.info.equals(this.info))
				return true;
		}
		
		return false;
		
	}

}
