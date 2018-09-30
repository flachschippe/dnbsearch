package de.schulzt.dnbsearch.keyword;

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
	
	

	public KeywordService() {
	}
	
	public KeywordGraph searchForTitle(String searchPhrase, Pageable pageable) {

		Slice<Book> books = bookRepo.findByTitleContainingIgnoringCaseOrAuthors_TitleContainingIgnoringCase(searchPhrase, searchPhrase, pageable);
		KeywordGraph graph = new KeywordGraph();
		
		for(Book book : books) {
			List<Keyword> keywords = book.getKeywords();
			int size = keywords.size();
			if(size == 1) {
				graph.addNode(keywords.get(0).getTitle());
			} else if(size > 1){		
				for(int i = 0; i < size; i++) {
					for(int j = i + 1; j < size - 1; j++) {
						Keyword keyword1 = keywords.get(i);
						Keyword keyword2 = keywords.get(j);
						graph.addLink(keyword1.getTitle(), keyword2.getTitle());
					}		
				}
				Keyword keyword1 = keywords.get(0);
				Keyword keyword2 = keywords.get(keywords.size() - 1);
				graph.addLink(keyword1.getTitle(), keyword2.getTitle());				
			}
		}
		return graph;
	}


}
