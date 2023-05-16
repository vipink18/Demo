package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Books;
import com.example.demo.repository.BookRepository;

@Service
public class BookingServiceImpl implements BookingService{

	private String msg = "Id Not Found";
	@Autowired
	private BookRepository repo; 
	
	
	
	@Override
	public Books add(Books book) {
		Books b = repo.save(book);
		System.out.println("Book has been added ");
		return b;
	}

	@Override
	public Books update(int bookId, Books book) throws Exception {
		
		Books books = repo.findById(bookId).orElseThrow( () -> new Exception(msg));
		repo.save(books);
		System.out.println("The book with id: "+bookId+" has been updated");
		return books;
	}

	@Override
	public List<Books> delete(int bookId) throws Exception {
		Books books = repo.findById(bookId).orElseThrow( () -> new Exception(msg));
		repo.delete(books);
		return getAll();
	}

	@Override
	public Books getById(int bookId) throws Exception {
		
		return repo.findById(bookId).orElseThrow( () -> new Exception(msg));
	}

	@Override
	public List<Books> getAll() {
		
		return repo.findAll();
	}

	

}
