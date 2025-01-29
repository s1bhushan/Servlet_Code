package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SocietyDAO;
import com.dao.SocietyDAOImpl;


//@WebServlet("/SocietyDeleteServlet")
public class SocietyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SocietyDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int flatno=Integer.parseInt(request.getParameter("flatno"));
		
		
		
		SocietyDAO dao=new SocietyDAOImpl();
		
		int res=dao.deleteinfobyFlatno(flatno);
		if(res>0) {
			out.print("<h1>"+"SUCCESS DELETE!!!"+"</h1>");
		}
		else
			out.print("<h1>"+"FAILED TO DELETE!!!"+"</h1>");



	}

}
