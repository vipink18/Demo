package com.example.demo.service;


import java.util.List;
import com.example.demo.entity.Books;

public interface BookService {
	
	Books addBook(Books book);
	
	Books updateBook(int bookid, Books book) throws Exception;
	
	public Books deleteBook(int bookid)throws Exception;
	
	Books getByBookId(int bookId)throws Exception ;
	
	
	List<Books> getAllBook();

}
