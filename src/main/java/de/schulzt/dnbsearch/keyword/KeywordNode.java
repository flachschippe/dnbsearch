package de.schulzt.dnbsearch.keyword;

public class KeywordNode {

	private String id;
	private int group;
	private int value;
	
	public KeywordNode(String id) {
		super();
		this.id = id;
		this.group = 1;
		this.value = 1;
	}	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
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
		return this.id.equals(((KeywordNode)other).getId());
	}
	
}
