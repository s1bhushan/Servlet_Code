package com.dao;

import java.util.List;

import com.model.Book;

public interface BookDAO {
	
	int SaveBook(Book book);
	int DeleteBook(Book book);
    int DeleteBookByid(int id);
    int UpdateBook(Book book);
    
    List<Book> getAllBook();
    
    List<Book>  getBookById(int id);
    
    List<Book> getAssendingBookShort();
	List<Book> getAssendingBookShortByName();
	List<Book> getReverseShort();
	List<Book> getShortbyPrice();
	List<Book> getShortbyDate();
    
}
