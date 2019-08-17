package com.rickywong.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickywong.mvc.models.Book;
import com.rickywong.mvc.repositories.BookRepository;

@Service
public class BookService {
	// this gives all the methods used in API
    // adding the book repository as a dependency
	private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // update
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book book = new Book(id, title, desc, lang, numOfPages);
    	return bookRepository.save(book);
    }
    // delete
    public Book deleteBook(Long id) {
    	bookRepository.deleteById(id);
    	return null;
    }

    
}
