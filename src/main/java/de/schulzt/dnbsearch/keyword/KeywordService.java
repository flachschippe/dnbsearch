package de.schulzt.dnbsearch.keyword;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import de.schulzt.dnbdb.Book;
import de.schulzt.dnbdb.BookRepository;
import de.schulzt.dnbdb.Keyword;

@Service
public class KeywordService {

	@Autowired
	private BookRepository bookRepo;
	
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	public List<Book> searchForTitle(String searchPhrase, Pageable pageable) {

		Slice<Book> books = bookRepo.findByTitleContainingIgnoringCaseOrAuthors_TitleContainingIgnoringCase(searchPhrase, searchPhrase, pageable);
		
	
		return books.getContent();
	}


}
