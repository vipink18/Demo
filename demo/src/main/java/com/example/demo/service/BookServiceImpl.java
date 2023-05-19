package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Books;

import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	private String msg = "Id Not Found";
	@Autowired
	private BookRepository bookRepository; 
		
	@Override
	public Books addBook(Books book) {
		Books b = bookRepository.save(book);
		System.out.println("Book has been added ");
		return b;
	}

	@Override
	public Books updateBook(int bookId, Books book) throws Exception {
		
		Books books = bookRepository.findById(bookId).orElseThrow( () -> new Exception(msg));
		bookRepository.save(books);
		System.out.println("The book with id: "+bookId+" has been updated");
		return books;
	}

	@Override
	public Books deleteBook(int bookId) throws Exception {
		Books books = bookRepository.findById(bookId).orElseThrow( () -> new Exception(msg));
		//Student student = st.getsId()
		bookRepository.deleteById(bookId);
		return books;
		
	}

	@Override
	public Books getByBookId(int bookId) throws Exception {
		
		return bookRepository.findById(bookId).orElseThrow( () -> new Exception(msg));
	}

	@Override
	public List<Books> getAllBook() {
		
		return bookRepository.findAll();
	}}
//	   






