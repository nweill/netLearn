package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import network.Edge;
import network.EdgeInfo;
import network.Network;
import network.NetworkInfo;
import network.Node;
import network.NodeInfo;

import com.google.common.collect.Lists;

public class NetParser {
	public static final String DEFAULT_SEP = "\\s+";
	private String fileName;
	
	public List<Node> getNodes() {
		return nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public NetParser(String fileName) {
		super();
		this.fileName = fileName;
	}

	private int currId = 0;
	List<Node> nodes = Lists.newArrayList();
	List<Edge> edges = Lists.newArrayList();
	
	public  boolean parseTxt() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line ="";
		while ((line = br.readLine())!=null){
			if (!line.toLowerCase().contains("ource"))
				parseLine(line, DEFAULT_SEP);
		}
		br.close();
		if (this.nodes.size() > 1)
			return true;
		return false;
			
		
	}
	
	public void parseLine(String line, String sep){
		String buff[] = line.split(sep);
		Node n1 = new Node(new NodeInfo(buff[0]),0);
		if (!this.nodes.contains(n1)){
			n1.setId(currId++);
			this.nodes.add(n1);
			
		}else{
			n1 = nodes.get(nodes.indexOf(n1));
		}
		
		Node n2 = new Node(new NodeInfo(buff[1]),0);
		if (!this.nodes.contains(n2)){
			n2.setId(currId++);
			this.nodes.add(n2);
			
		}else{
			n2 = nodes.get(nodes.indexOf(n2));
		}
		double weight = 1;
		if (buff.length >2)
			weight = Double.parseDouble(buff[2]);
		Edge e = new Edge(true,n1,n2,new EdgeInfo(n1+"-"+n2),weight);
		if (!edges.contains(e))
			edges.add(e);
	}
	
	public Network build(){
		Network res = new Network(new NetworkInfo(fileName), nodes, edges);
		return res;
	}

}
