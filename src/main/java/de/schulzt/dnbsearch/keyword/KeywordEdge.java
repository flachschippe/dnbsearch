package de.schulzt.dnbsearch.keyword;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KeywordEdge {
	
	@JsonIgnore
	private KeywordNode source;

	@JsonIgnore
	private KeywordNode target;
	
	private String label;
	private int value;
	
	public KeywordEdge(KeywordNode source, KeywordNode target, String label) {
		super();
		this.source = source;
		this.target = target;
		this.label = label;
		this.value = 1;
	}
	
	@JsonProperty("source")
	public String getSourceString() {
		return this.getSource().getId();
	}
	
	@JsonProperty("target")
	public String getTargetString() {
		return this.getTarget().getId();
	}
	
	
	public KeywordNode getSource() {
		return source;
	}
	public void setSource(KeywordNode firstNode) {
		this.source = firstNode;
	}
	public KeywordNode getTarget() {
		return target;
	}
	public void setTarget(KeywordNode secondNode) {
		this.target = secondNode;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String name) {
		this.label = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public void incrementValue() {
		this.value++;
	}
	public boolean equals(Object other) {
		return this.source.equals(((KeywordEdge)other).getSource()) &&
				this.target.equals(((KeywordEdge)other).getTarget()) ||
				this.source.equals(((KeywordEdge)other).getTarget()) &&
				this.target.equals(((KeywordEdge)other).getSource());
	}	

}
