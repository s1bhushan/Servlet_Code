package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.model.Book;

@WebServlet("/UpdateDataServlet")
public class UpdateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		int updateid=0;
		
		BookDAO dao = new BookDAOImpl();


		List<Book> bookList = dao.getBookById(id);

		Iterator<Book> itr = bookList.iterator();
		
		out.print("<head>");
		out.print("<link rel=\"stylesheet\" href=\"./css/table.css\">");
		out.print("</head>");

		out.print("<table id='customers'");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> PRICE </th>");
		out.print("<th> DATE </th>");
		out.print("<th> Remove </th>");
		
		out.print("</tr>");

		while (itr.hasNext()) {
			Book book = (Book) itr.next();
			out.print("<tr>");
			out.print("<td>" + book.getId() + "</td>");
			out.print("<td>" + book.getName() + "</td>");
			out.print("<td>" + book.getPrice() + "</td>");
			out.print("<td>" + book.getDate() + "</td>");
			out.print("<td>");
			out.print("<a href='delete?id="+book.getId()+"'>"+"DELETE"+"</a>");
			out.print("</td>");
			updateid=book.getId();
			
			
			out.print("</tr>");
		}
		


		out.print("</table>");
		
		out.print("<table id='customers'>");
		out.print("<tr>");
	     	
            out.print("<h1>Book Info Update Form</h1>");
            out.print("<hr>");
			out.print("<form action=\"update\" method=\"get\">");
			out.print("<th> ID   :<input type=\"text\" name=\"id\" value=\""+updateid+"\"><br></th>");
			out.print("<th>Name : <input type=\"text\" name=\"name\"><br></th>");
			out.print("<th>Price: <input type=\"text\" name=\"price\"><br></th>");
			out.print("<th>Date : <input type=\"Date\" name=\"date\"><br></th>");
			
			out.print("<th><input type=\"submit\" value=\"SUBMIT\"></th>");
		
			out.print("</form>");
			out.print("</tr>");
			out.print("</table>");
		
		



	}

}
