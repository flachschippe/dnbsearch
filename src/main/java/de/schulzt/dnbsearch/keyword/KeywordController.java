package de.schulzt.dnbsearch.keyword;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.schulzt.dnbdb.Book;


@RestController
public class KeywordController {
	
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired
	private KeywordService service;
	
	
	public KeywordController () {
		
	}
	
	@RequestMapping("/keywords{searchPhrase}")
	public List<Book> getKeywords(@RequestParam("searchPhrase") String searchPhrase, Pageable pageable) {
		return service.searchForTitle(searchPhrase, pageable);
	}

}
