package com.springboot.verialimenti;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.stereotype.Controller;



@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
//@Controller
class ArticlesController {

	private final ArticlesRepository repository;

	ArticlesController(ArticlesRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
/*
	@RequestMapping("/galery")
	public String galery() {
		return "galery/galery";
	}
*/
	@GetMapping("/db/articles")
	List<Articles> all() {
		return repository.findAll();
	}

	@PostMapping("/db/articles")
	Articles newArticle(@RequestBody Articles newArticle) {
		return repository.save(newArticle);
	}

	// Single item

	@GetMapping("/db/articles/{id}")
	Articles one(@PathVariable Long id) {

		return repository.findById(id)
			.orElseThrow(() -> new ArticleNotFoundException(id));
	}

	@PutMapping("/db/articles/{id}")
	Articles replaceArticle(@RequestBody Articles newArticle, @PathVariable Long id) {

		return repository.findById(id)
			.map(article -> {
				article.setName(newArticle.getName());
				article.setKprice(newArticle.getKprice());
				article.setTprice(newArticle.getTprice());
				article.setAmount(newArticle.getAmount());
				return repository.save(article);
			})
			.orElseGet(() -> {
				newArticle.setId(id);
				return repository.save(newArticle);
			});
	}

	@DeleteMapping("/db/articles/{id}")
	void deleteArticle(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
