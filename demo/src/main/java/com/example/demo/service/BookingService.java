package com.example.demo.service;


import java.util.List;
import com.example.demo.entity.Books;

public interface BookingService {
	
	Books add(Books book);
	
	Books update(int bookid, Books book) throws Exception;
	
	List<Books> delete(int bookid)throws Exception;
	
	Books getById(int bookId)throws Exception ;
	
	
	List<Books> getAll();

}
