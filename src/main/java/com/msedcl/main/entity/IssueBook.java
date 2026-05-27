package com.msedcl.main.entity;

import java.sql.Date;

public class IssueBook{

	private Book book;
	private Member member;
	private Date issueDate;	
	private Date dueDate;	
	private double fineAmount;	
	
	public IssueBook() {
		// TODO Auto-generated constructor stub
	}

	public IssueBook(Book book, Member member, Date issueDate, Date dueDate, double fineAmount) {
		super();
		this.book = book;
		this.member = member;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.fineAmount = fineAmount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	@Override
	public String toString() {
		return "IssueBook [book=" + book + ", member=" + member + ", issueDate=" + issueDate + ", dueDate=" + dueDate
				+ ", fineAmount=" + fineAmount + "]";
	}
	
	
	
}
