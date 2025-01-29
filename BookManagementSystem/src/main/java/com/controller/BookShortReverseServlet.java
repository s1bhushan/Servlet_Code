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


@WebServlet("/BookShortReverseServlet")
public class BookShortReverseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookShortReverseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		BookDAO dao = new BookDAOImpl();

		List<Book> bookList = dao.getReverseShort();

		Iterator<Book> itr = bookList.iterator();
		
		out.print("<head>");
		out.print("<link rel=\"stylesheet\" href=\"./css/table.css\">");
		out.print("</head>");
		
		


		out.print("<table id='customers'");
		out.print("<tr>");
		out.print("<th>");
		out.print("<form action=\"BookShortServlet\" method=\"get\">");
		out.print("<input type=\"submit\" value=\"ID\">");
		out.print("</form>");
		out.print("</th>");
		out.print("<th>");
		out.print("<form action=\"BookShortByName\" method=\"get\">");
		out.print("<input type=\"submit\" value=\"NAME\">");
		out.print("</form>");
		out.print("</th>");
		out.print("<th>");
		out.print("<form action=\"ShoetByPriceServlet\" method=\"get\">");
		out.print("<input type=\"submit\" value=\"PRICE\">");
		out.print("</form>");
		out.print("</th>");
		out.print("<th>");
		out.print("<form action=\"ShortByDateServlet\" method=\"get\">");
		out.print("<input type=\"submit\" value=\"DATE\">");
		out.print("</form>");
		out.print("</th>");
		out.print("<th> Remove </th>");
		out.print("<th> Update </th>");


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
			out.print("<td>");
			out.print("<a href='UpdateDataServlet?id="+book.getId()+"'>"+"UPDATE"+"</a>");
			out.print("</td>");
			

			out.print("</tr>");
		}

		out.print("</table>");
		
		out.print("<table id='customers'>");
		out.print("<tr>");
	     	
            out.print("<h1>Book Info ADD Form</h1>");
            out.print("<hr>");
			out.print("<form action=\"add\" method=\"get\">");
			out.print("<th> ID   :<input type=\"text\" name=\"id\"><br></th>");
			out.print("<th>Name : <input type=\"text\" name=\"name\"><br></th>");
			out.print("<th>Price: <input type=\"text\" name=\"price\"><br></th>");
			out.print("<th>Date : <input type=\"Date\" name=\"date\"><br></th>");
			
			out.print("<th><input type=\"submit\" value=\"SUBMIT\"></th>");
		
			out.print("</form>");
			out.print("</tr>");
			out.print("</table>");

		


	}

	}

