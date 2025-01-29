package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.model.Book;

@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		
		LocalDate date=LocalDate.parse(request.getParameter("date"));
		
		Book book=new Book(id,name,price,date);
		
		BookDAO dao=new BookDAOImpl();
		
		
		int res=dao.SaveBook(book);
		RequestDispatcher rd=request.getRequestDispatcher("/read");
		if(res>0) {
			
			out.print("<h1>"+"SUCCESS ADD!!!"+"</h1>");

			rd.include(request, response);

		}else {
			out.print("<h1>"+"FAILED TO ADD!!!"+"</h1>");
			rd.include(request, response);

		
		}

	}

}
