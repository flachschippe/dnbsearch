package de.schulzt.dnbsearch.keyword;

public class Keyword_ {
	
	public Keyword_() {
		
	}
	
	public Keyword_(String text) {
		super();
		this.text = text;
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
