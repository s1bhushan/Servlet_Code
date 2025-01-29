package com.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SocietyDAO;
import com.dao.SocietyDAOImpl;
import com.model.Society;

//@WebServlet("/SocietyUpdateServlet")
public class SocietyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SocietyUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String wing=request.getParameter("wing");
		int flatno=Integer.parseInt(request.getParameter("flatno"));
		
		String Name=request.getParameter("Name");
		double amount=Double.parseDouble(request.getParameter("amount"));
		
		Society flat=new Society(wing,flatno, Name, amount);
		
		SocietyDAO dao=new SocietyDAOImpl();
		
		int res=dao.updateinfo(flat);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS UPDATE!!!" + "</h1>");
		} else
			out.print("<h1>" + "FAILED TO UPDATE!!!" + "</h1>");

	}

}
