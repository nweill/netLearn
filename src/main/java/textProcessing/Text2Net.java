package textProcessing;

import java.util.List;
import java.util.Map;

import network.Edge;
import network.Network;
import network.Node;
import network.NodeInfo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Text2Net {
	
	final static String wordSep = "\\s+";
	final static String sentenceSep = "[\\.!?\n-]+";
	public static int window = 2 ;
	public static Network read(String text, TextCleaner tc){
		
		String cleanText = tc.clean(text);
		String [] words = cleanText.split(wordSep);
		if (words.length <2) {
			System.out.println("O_o");
			return null;
		}
		int i = 0 ;
		List<Node> nodes = Lists.newArrayList();
		Map<String,Node> dico = Maps.newHashMap();
		for (String word : words){
			if (word .equals(""))
				continue;
			Node n = new Node(new NodeInfo(word),0);
			if (!dico.containsKey(n)){
				n.setId(i++);
				nodes.add(n);
				dico.put(word, n);
			}
		}
		List<Edge> edges = Lists.newArrayList();
		for (i = window ; i<nodes.size()-window ; i++ ){
			for (int j = i-window ; j <i+window ; j++){
				
				Edge e = new Edge(true, dico.get(nodes.get(i).getInfo().getName()), dico.get(nodes.get(j).getInfo().getName()));
				if (!edges.contains(e))
				edges.add(e);
			}
				
		}
		
		Network res = new Network(nodes, edges);
		return res;
		
	}
	
	
	
	
	

}
