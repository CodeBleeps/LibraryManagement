package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msedcl.main.entity.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	private JdbcTemplate jdbcTemplate;

	private static final String ADD_NEW_BOOK_SQL = "INSERT INTO book_details(book_title,book_author,issuable_status,availabity_status) values(?,?,?,?)";
	private static final String UPDATE_EXISTING_BOOK_SQL = "UPDATE book_details set availabity_status = ? WHERE book_code = ?";
	private static final String SELECT_ALL_BOOK_SQL = "SELECT * FROM book_details";
	private static final String SELECT_A_BOOK_BY_TITLE_OR_AUTHER_SQL = "SELECT * FROM book_details WHERE book_title = ? or book_author = ?";
	private static final String SELECT_A_BOOK_BY_ID_SQL = "SELECT * FROM book_details WHERE book_code = ?";
	private static final String SELECT_ISSUED_BOOKS_SQL = "SELECT * FROM book_details WHERE availabity_status = 'N'";
	

	public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded Constructor Called - BookRepositoryImpl");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public Book addNewBook(Book book) {
		int rowsInserted = jdbcTemplate.update(ADD_NEW_BOOK_SQL, book.getBookTitle(), book.getBookAuthor(), book.isIssuableStatus()?"Y":"N", book.isAvailabityStatus()?"Y":"N");
		if (rowsInserted > 0)
			return book;
		else
			return null;
	}

	@Override
	public Book updateAvailabityStatus(Book book) {
		int rowsUpdated = jdbcTemplate.update(UPDATE_EXISTING_BOOK_SQL, book.isAvailabityStatus()?"Y":"N", book.getBookCode());
		if (rowsUpdated > 0)
			return book;
		else
			return null;
	}

	@Override
	public Book getBookbyBookId(int bookId) {
		return jdbcTemplate.queryForObject(SELECT_A_BOOK_BY_ID_SQL,(rs, row) -> new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).equals("Y"), rs.getString(5).equals("Y")),  bookId);
	}

	@Override
	public List<Book> listAllBooks() {
		return jdbcTemplate.query(SELECT_ALL_BOOK_SQL, (rs, row) -> new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).equals("Y"), rs.getString(5).equals("Y")));
	}

	@Override
	public List<Book> listAllIssuedBooks() {
		return jdbcTemplate.query(SELECT_ISSUED_BOOKS_SQL, (rs, row) -> new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).equals("Y"), rs.getString(5).equals("Y")));
	}

	@Override
	public List<Book> searchBookbyTitleOrAuthor(String name) {
		return jdbcTemplate.query(SELECT_A_BOOK_BY_TITLE_OR_AUTHER_SQL, (rs, row) -> new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).equals("Y"), rs.getString(5).equals("Y")), name, name);
	}


}
