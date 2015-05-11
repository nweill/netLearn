package network;

import java.util.List;

import com.google.common.collect.Lists;

public class Node implements Comparable<Node>{
	private NodeInfo info;
	private int id;
	public double minDistance=Double.POSITIVE_INFINITY;
	public List<Edge> adjacencies;
	public Node previous;
	
	public int getId() {
		return id;
	}

	public Node( NodeInfo info,int id) {
		super();
		
		this.info = info;
		this.id = id;
		this.adjacencies = Lists.newArrayList();
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
	
	public String toString(){
		return this.info.toString();
	}

	 public int compareTo(Node other)
	    {
	        return Double.compare(minDistance, other.minDistance);
	    }
}
