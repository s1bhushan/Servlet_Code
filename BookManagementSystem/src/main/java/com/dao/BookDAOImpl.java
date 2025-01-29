package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.model.Book;
import com.model.Comparators;
import com.utility.DBUtility;

public class BookDAOImpl implements BookDAO {

	@Override
	public int SaveBook(Book book) {
		int i = 0;
		String sql = "insert into book values(?,?,?,?);";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, book.getId());
			ps.setString(2, book.getName());
			ps.setDouble(3, book.getPrice());

			//java.sql.Date date = java.sql.Date.valueOf(book.getDate());

			ps.setObject(4, book.getDate());

			i = ps.executeUpdate();
		} catch (Exception e) {

			System.out.println("SaveBook" + e);

		}
		return i;
	}

	@Override
	public int DeleteBook(Book book) {
		int i = 0;
		String sql = "delete from book where id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, book.getId());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("DeleteBook BookDAOImpl" + e);
		}
		return i;
	}

	@Override
	public int DeleteBookByid(int id) {
		int i = 0;
		String sql = "delete from book where id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1,id);

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("DeleteBook BookDAOImpl" + e);
		}
		return i;
	}

	@Override
	public int UpdateBook(Book book) {
		int i=0;
		String sql = "update book set Bookname=?,price=?,buydate=? where id=?;";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(4, book.getId());
			ps.setString(1, book.getName());
			ps.setDouble(2, book.getPrice());

			//java.sql.Date date = java.sql.Date.valueOf(book.getDate());

			ps.setObject(3, book.getDate());

			i = ps.executeUpdate();
		} catch (Exception e) {

			System.out.println("updateBook" + e);

		}
		return i;
		
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> listset=new ArrayList<Book>();
		String sql="select * from book";
		
		try(Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Date date=rs.getDate(4);
				
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),LocalDate.parse(date.toString()));
				listset.add(book);
			}
		}catch(Exception e) {
			System.out.println("List All Book"+e);
			
		}
		return listset;
	}

	@Override
	public List<Book>  getBookById(int id) {
		List<Book> listset=new ArrayList<Book>();
		String sql = "select * from book where id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Date date=rs.getDate(4);
				
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),LocalDate.parse(date.toString()));
				listset.add(book);
			}
		}catch(Exception e) {
			System.out.println("List All Book"+e);
			
		}
	
		return  listset;
		

		
			
		
	}


	@Override
	public List<Book> getAssendingBookShort() {
      
		List<Book> listset=new ArrayList<Book>();
		String sql="select * from book";
		
		try(Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Date date=rs.getDate(4);
				
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),LocalDate.parse(date.toString()));
				listset.add(book);
			}
		}catch(Exception e) {
			System.out.println("List All Book"+e);
			
		}
		
		Collections.sort(listset, Comparators.ID);
		
	
		return listset;
		
	}
	
	@Override
	public List<Book> getAssendingBookShortByName() {
      
		List<Book> listset=new ArrayList<Book>();
		String sql="select * from book";
		
		try(Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Date date=rs.getDate(4);
				
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),LocalDate.parse(date.toString()));
				listset.add(book);
			}
		}catch(Exception e) {
			System.out.println("List All Book"+e);
			
		}
		Collections.sort(listset, Comparators.NAME);
		
		
	
		return listset;
		
	}
	
	@Override
	public List<Book> getShortbyPrice() {
      
		List<Book> listset=new ArrayList<Book>();
		String sql="select * from book";
		
		try(Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Date date=rs.getDate(4);
				
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),LocalDate.parse(date.toString()));
				listset.add(book);
			}
		}catch(Exception e) {
			System.out.println("List All Book"+e);
			
		}
		Collections.sort(listset, Comparators.PRICE);
		
		
	
		return listset;
		
	}
	@Override
	public List<Book> getShortbyDate() {
      
		List<Book> listset=new ArrayList<Book>();
		String sql="select * from book";
		
		try(Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Date date=rs.getDate(4);
				
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),LocalDate.parse(date.toString()));
				listset.add(book);
			}
		}catch(Exception e) {
			System.out.println("List All Book"+e);
			
		}
		Collections.sort(listset, Comparators.DATE);
		
		
	
		return listset;
		
	}
	
	@Override
	public List<Book> getReverseShort() {
      
		List<Book> listset=new ArrayList<Book>();
		String sql="select * from book";
		
		try(Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Date date=rs.getDate(4);
				
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),LocalDate.parse(date.toString()));
				listset.add(book);
			}
		}catch(Exception e) {
			System.out.println("List All Book"+e);
			
		}
		
		
		Collections.sort(listset, Comparators.RevID);
		
		
	
		return listset;
		
	}


}
