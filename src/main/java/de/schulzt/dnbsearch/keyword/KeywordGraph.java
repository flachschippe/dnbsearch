package de.schulzt.dnbsearch.keyword;

import java.util.ArrayList;
import java.util.List;

public class KeywordGraph {
	
	private List<KeywordNode> nodes;
	public List<KeywordNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<KeywordNode> nodes) {
		this.nodes = nodes;
	}

	public List<KeywordEdge> getLinks() {
		return links;
	}

	public void setLinks(List<KeywordEdge> links) {
		this.links = links;
	}

	private List<KeywordEdge> links;
	
	
	public KeywordGraph() {
		this.nodes = new ArrayList<KeywordNode>();
		this.links = new ArrayList<KeywordEdge>();
	}
	
	public KeywordNode addNode(final String id) {
		KeywordNode n = new KeywordNode(id);
		int index = this.nodes.indexOf(n);
		if(index >= 0) {
			this.nodes.get(index).incrementValue();
		} else {
			this.nodes.add(n);	
		}
		return n;
	}
	
	public void addLink(final String source, final String target) {
		
		if(source == target ||
				source.startsWith("_:node") ||
				target.startsWith("_:node"))
			return;
		
		KeywordNode s = this.addNode(source);
		KeywordNode t= this.addNode(target);

		KeywordEdge e = new KeywordEdge(s, t, "");
		int index = this.links.indexOf(e);
		if(index >= 0) {
			this.links.get(index).incrementValue();
		} else {
			this.links.add(e);	
		}
	}	

}
