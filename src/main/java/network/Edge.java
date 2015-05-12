package network;

public class Edge {
	private final boolean oriented;
	private Node source;
	private Node target;
	private EdgeInfo edgeInfo;
	public double weight;

	public Edge(boolean oriented, Node source, Node target, EdgeInfo edgeInfo) {
		super();
		this.oriented = oriented;
		this.source = source;
		this.target = target;
		this.setEdgeInfo(edgeInfo);
		this.weight = 1;
	}
	public Edge(boolean oriented, Node source, Node target, EdgeInfo edgeInfo,double weight) {
		
		this(oriented,source,target,edgeInfo);
		this.weight = weight;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public Node getTarget() {
		return target;
	}

	public void setTarget(Node target) {
		this.target = target;
	}

	public boolean isOriented() {
		return oriented;
	}
	public String toString(){
		return this.edgeInfo.toString();
	}

	@Override
	public boolean equals(Object e){
		if (e==null)
			return false;
		if (e instanceof Edge){
			Edge ed = (Edge) e ;
			if (oriented && ed.oriented)
				return ed.source.equals(this.source) && ed.target.equals(this.target);
			else
				return (ed.source.equals(this.source) && ed.target.equals(this.target))
						|| (ed.source.equals(this.target) && ed.target.equals(this.source));
		}

		return false;

	}

	public EdgeInfo getEdgeInfo() {
		return edgeInfo;
	}

	public void setEdgeInfo(EdgeInfo edgeInfo) {
		this.edgeInfo = edgeInfo;
	}
}
