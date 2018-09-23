package de.schulzt.dnbsearch.keyword;

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
	
	

	public KeywordService() {
	}
	
	public KeywordGraph searchForTitle(String searchPhrase, Pageable pageable) {

		Slice<Book> books = bookRepo.findByTitleContainingIgnoringCaseOrAuthors_TitleContainingIgnoringCase(searchPhrase, searchPhrase, pageable);
		KeywordGraph graph = new KeywordGraph();
		
		for(Book book : books) {
			for(Keyword keyword: book.getKeywords()) {
				for(Keyword keyword1 : book.getKeywords()) {
					if(keyword != keyword1) {
						graph.addLink(keyword.getTitle(), keyword1.getTitle());
					}
				}
			}
		}
		return graph;
	}


}
