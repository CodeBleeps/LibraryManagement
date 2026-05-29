package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.entity.Book;
import com.msedcl.main.entity.Member;
import com.msedcl.main.entity.MemberType;
import com.msedcl.main.service.BookService;
import com.msedcl.main.service.BookServiceImpl;
import com.msedcl.main.service.MemberService;
import com.msedcl.main.service.MemberServiceImpl;
import com.msedcl.main.service.MemberTypeService;
import com.msedcl.main.service.MemberTypeServiceImpl;

public class LibraryManagement {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.msedcl.main");
		BookService bookService = context.getBean(BookServiceImpl.class);
		MemberTypeService memberTypeService  = context.getBean(MemberTypeServiceImpl.class);
		MemberService memberService  = context.getBean(MemberServiceImpl.class);
		Scanner scanner = new Scanner(System.in);

		int bookId, memberId, memberTypeId, choice;
		String title, author, memberName, continueChoice;
		boolean issuableStatus, availabityStatus;	 
		double salary;
		List<Book> bookList;
		List<Member> memberList;
		do {
			System.out.println("Menu :");
			System.out.println("1. Add New Book");
			System.out.println("2. Search Book by BookId");		
			System.out.println("3. Search Book by Title Or Author");	
			System.out.println("4. Update Availabity Status by BookId");
			System.out.println("5. View All Book");
			System.out.println("6. View All Issued Book");	
			System.out.println("7. Add New Member");
			System.out.println("8. View All Member");
			System.out.println("9. Search Member by MemberId");
			System.out.println("10. Issue a Book");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Enter Book Title : ");
				title = scanner.nextLine();
				System.out.println("Enter Book Author : ");
				author = scanner.nextLine();
				System.out.println("Is Book Issuable? (Y/N) : ");
				issuableStatus = scanner.next().equals("Y");
				System.out.println("Is Book Availble for Issuing? (Y/N) : ");
				availabityStatus = scanner.next().equals("Y");
				Book book = new Book(0, title, author, issuableStatus, availabityStatus);
				if(bookService.addNewBook(book)!= null) {
					System.out.println("New Book Added Successfully");
					System.out.println("BookId :" + book.getBookCode());
				};
				break;
			case 2:
				System.out.println("Enter the bookId :");
				bookId = scanner.nextInt();
				Book existingBook = bookService.getBookbyBookId(bookId);
				if(existingBook!= null) {
					System.out.println("Book Found :"+ existingBook);
				};
				break;
			case 3:
				scanner.nextLine();
				System.out.println("Enter the Book Title Or Author Name:");
				title = scanner.nextLine();
				bookList = bookService.searchBookbyTitleOrAuthor(title);
				System.out.println("Search Result :");
				if(bookList != null && !bookList.isEmpty()) {
					bookList.forEach(e -> System.out.println(e));
				}else {
					System.out.println("No Books Found.");
				}
				break;
			case 4:
				System.out.println("Enter the bookId :");
				bookId = scanner.nextInt();
				System.out.println("Is Book Availble for Issuing? (Y/N) : ");
				availabityStatus = scanner.next().equals("Y");				
				book = new Book(bookId, null, null, false, availabityStatus);
				book = bookService.updateAvailabityStatus(book);
				if(book!= null) {
					System.out.println("Book Availabity Status Updated :"+ book);
				};
				break;
			case 5:
				System.out.println("List of All Books :");
				bookList= bookService.listAllBooks();
				if(bookList != null && !bookList.isEmpty()) {
					bookList.forEach(e -> System.out.println(e));
				}else {
					System.out.println("No Books Found.");
				}
				break;
			case 6:
				System.out.println("List of All Issued Books :");
				bookList= bookService.listAllIssuedBooks();
				if(bookList != null && !bookList.isEmpty()) {					
					bookList.forEach(e -> System.out.println(e));
				}else {
					System.out.println("No Books Found.");
				}
				
				break;	
			case 7:
				scanner.nextLine();
				System.out.println("Enter Member Name : ");
				memberName = scanner.nextLine();
				System.out.println("Enter Member Type 1/2[1- Student 2-Faulty] : ");
				memberTypeId = scanner.nextInt();
				MemberType memberType = memberTypeService.getMemberTypeByMemberTypeId(memberTypeId);
				Member member = new Member(0, memberName, 0, memberType);
				System.out.println(member);
				if(memberService.addNewMember(member)!= null) {
					System.out.println("New Member Added Successfully");
					System.out.println("MemberId :" + member.getMemberCode());
				};
				break;
			case 8:
				System.out.println("List of All Members :");
				memberList= memberService.getAllMemberList();
				if(memberList != null && !memberList.isEmpty()) {
					memberList.forEach(e -> System.out.println(e));
				}else {
					System.out.println("No Books Found.");
				}
				break;
			case 9:
				System.out.println("Enter the memberId :");
				memberId = scanner.nextInt();
				Member existingMember = memberService.getMemberbyMemberId(memberId);
				if(existingMember!= null) {
					System.out.println("Member Found :"+ existingMember);
				};
				break;
			case 10:
				System.out.println("Enter the bookId :");
				bookId = scanner.nextInt();
				existingBook = bookService.getBookbyBookId(bookId);
				if(existingBook!= null) {
					System.out.println("Book Found :"+ existingBook);
				};
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equalsIgnoreCase("yes") || continueChoice.equalsIgnoreCase("y"));
		scanner.close();
		context.close();
		System.out.println("Closing Application..");

	}

}
