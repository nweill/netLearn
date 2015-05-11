package network;

import java.util.List;
import java.util.TreeMap;

import weka.core.matrix.Matrix;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Network {
	private NetworkInfo netInfo;
	private List<Node> nodes;
	private List<Edge> edges;
	private Matrix mat;
	private TreeMap<Integer,Matrix> mats;
	
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
		mats = Maps.newTreeMap();
		createMatrix();
		mats.put(1,this.mat);
		
	}
	
	public boolean isOriented(){
		
		for (Edge e : edges){
			if (!e.isOriented())
				return false;
		}
		return true;
	}
	
	private void createMatrix(){
		this.mat = new Matrix(this.nodes.size(), this.nodes.size());
		for (Edge e : edges){
			mat.set(e.getSource().getId(), e.getTarget().getId(), 1);
		}
	}
	
	public Matrix getMatN(int n){
		if (n==0)
			return Matrix.identity(mat.getRowDimension(), mat.getColumnDimension());
		if (n == 1)
			return this.mat;
		if (this.mats.size() > n)
			return this.mats.get(n);
		else{
			Matrix m = this.mat.times(getMatN(n-1));
			this.mats.put(n,m);
			return m;
		}
	}
	
	
	
	
	

	

}
