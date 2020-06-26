package com.lwl.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lwl.bookapp.domain.Book;
import com.lwl.bookapp.repo.BookRepository;
@Service
public class BookServiceImpl implements BookService  {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	@Cacheable(value = "books",key = "#id")
	public Book findById(Long id) {
		Optional<Book> retBook = bookRepository.findById(id);
		return Optional.of(retBook).flatMap(e->e).orElse(null);
		
	}

	@Override
	public List<Book> findAllBooks() {
		return null;
	}


}
