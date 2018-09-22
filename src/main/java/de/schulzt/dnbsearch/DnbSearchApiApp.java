package de.schulzt.dnbsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import de.schulzt.dnbdb.*;
import de.schulzt.dnbsearch.keyword.KeywordController;
import de.schulzt.dnbsearch.keyword.KeywordService;
@SpringBootApplication
@EnableJpaRepositories("de.schulzt.dnbdb")
@EntityScan("de.schulzt.dnbdb")
@EnableSpringDataWebSupport

//@ComponentScan(basePackages={"de.schulzt"})
public class DnbSearchApiApp {

	public static void main(String[] args) {
		SpringApplication.run(DnbSearchApiApp.class, args);
	}
	
}
