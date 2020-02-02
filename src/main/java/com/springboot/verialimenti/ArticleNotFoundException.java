package com.springboot.verialimenti;

class ArticleNotFoundException extends RuntimeException {

	ArticleNotFoundException(Long id) {
		super("Could not find article " + id);
	}
}
