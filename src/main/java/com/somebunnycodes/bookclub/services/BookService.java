package com.somebunnycodes.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.somebunnycodes.bookclub.models.Book;
import com.somebunnycodes.bookclub.repositories.BookRepository;

@Service
public class BookService {

	Logger logger = LoggerFactory.getLogger(BookService.class);
	
    @Autowired
    private BookRepository bookRepo;
	
    public Book createBook(Book newBook, BindingResult result) {
    	if (result.hasErrors()) {
    		return null;
    	}
    	bookRepo.save(newBook);
    	return newBook;
    }

    public Book updateBook(Book updatedBook, BindingResult result) {
    	if (result.hasErrors()) {
    		return null;
    	}
    	bookRepo.save(updatedBook);
    	return updatedBook;
    }
    
    public List<Book> getAllBooks() {
    	return bookRepo.findAll();
    }
    
    public Optional<Book> getBook(Long id) {
    	return bookRepo.findById(id);
    }
}
