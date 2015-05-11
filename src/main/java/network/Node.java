package network;

import java.util.List;

public class Node {
	private NodeInfo info;
	private int id;
	
	public int getId() {
		return id;
	}

	public Node( NodeInfo info,int id) {
		super();
		
		this.info = info;
		this.id = id;
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
