package com.somebunnycodes.bookclub.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.somebunnycodes.bookclub.models.Book;
import com.somebunnycodes.bookclub.models.User;
import com.somebunnycodes.bookclub.services.BookService;

@Controller
public class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public String listBooks(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("user", user);
		model.addAttribute("books", books);
		return "home.jsp";
	}
	
	@GetMapping("/books/new")
	public String createBook(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		model.addAttribute("book", new Book());
		model.addAttribute("user", user);
		return "addBook.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showBook(HttpSession session, @PathVariable Long id, Model model) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		Optional<Book> book = bookService.getBook(id);
		model.addAttribute("book", book.get());
		return "book.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(HttpSession session, @PathVariable Long id, Model model) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		Optional<Book> book = bookService.getBook(id);
		model.addAttribute("book", book.get());
		model.addAttribute("user", user);
		return "editBook.jsp";
	}
	
	@PostMapping("/books")
	public String postBook(@Valid @ModelAttribute("book") Book newBook, BindingResult result, Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		Book book = bookService.createBook(newBook, result);
		if (book == null) {
			model.addAttribute("book", newBook);
			return "addBook.jsp";
		}
		return "redirect:/books";
	}
	
	@PutMapping("/books/{id}")
	public String putBook(@PathVariable Long id, @Valid @ModelAttribute("book") Book updatedBook, BindingResult result, Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		
		// Set book ID to the one in the path so right book is updated
		updatedBook.setId(id);
		
		Book book = bookService.updateBook(updatedBook, result);
		if (book == null) {
			model.addAttribute("book", updatedBook);
			return "editBook.jsp";
		}
		return "redirect:/books";
	}
}
