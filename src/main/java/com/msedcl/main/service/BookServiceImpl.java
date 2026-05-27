package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msedcl.main.entity.Book;
import com.msedcl.main.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		System.out.println("Overloaded Constructor Called - BookRepositoryImpl");
		this.bookRepository = bookRepository;
	}

	@Override
	@Transactional
	public Book addNewBook(Book book) {
			return bookRepository.addNewBook(book);
	}

	@Override
	public Book updateAvailabityStatus(Book book) {
		return bookRepository.updateAvailabityStatus(book);
	}

	@Override
	public Book getBookbyBookId(int bookId) {
		return bookRepository.getBookbyBookId(bookId);
	}

	@Override
	public List<Book> listAllBooks() {
		return bookRepository.listAllBooks();
	}

	@Override
	public List<Book> listAllIssuedBooks() {
		return bookRepository.listAllIssuedBooks();
	}

	@Override
	public List<Book> searchBookbyTitleOrAuthor(String name) {
		return bookRepository.searchBookbyTitleOrAuthor(name);
	}


}
