package com.lwl.bookapp.service;

import java.util.List;

import com.lwl.bookapp.domain.Book;

public interface BookService {
	public Book addBook(Book book);
	public Book findById(Long id);
	public List<Book> findAllBooks();
}
