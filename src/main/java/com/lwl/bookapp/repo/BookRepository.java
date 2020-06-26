package com.lwl.bookapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwl.bookapp.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}