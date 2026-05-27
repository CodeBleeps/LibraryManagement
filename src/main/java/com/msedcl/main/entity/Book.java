package com.msedcl.main.entity;

public class Book{

	private int bookCode;
	private String bookTitle;
	private String bookAuthor;	
	private boolean issuableStatus;	
	private boolean availabityStatus;	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookCode, String bookTitle, String bookAuthor, boolean issuableStatus, boolean availabityStatus) {
		super();
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.issuableStatus = issuableStatus;
		this.availabityStatus = availabityStatus;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public boolean isIssuableStatus() {
		return issuableStatus;
	}

	public void setIssuableStatus(boolean issuableStatus) {
		this.issuableStatus = issuableStatus;
	}

	public boolean isAvailabityStatus() {
		return availabityStatus;
	}

	public void setAvailabityStatus(boolean availabityStatus) {
		this.availabityStatus = availabityStatus;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", issuableStatus=" + issuableStatus + ", availabityStatus=" + availabityStatus + "]";
	}
	
	
	
}
