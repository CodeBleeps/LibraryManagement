package com.msedcl.main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.msedcl.main.entity.Book;

public interface BookRepository {
	Book addNewBook(Book book);
	Book updateAvailabityStatus(Book book);
	Book getBookbyBookId(int bookId);	
	List<Book> listAllBooks();
	List<Book> listAllIssuedBooks();
	List<Book> searchBookbyTitleOrAuthor(String name);	
}
