package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;

//@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		
		int year=Integer.parseInt(request.getParameter("year"));
		
		Employee emp=new Employee(id,name,salary,year);
		
		EmployeeDAO dao=new EmployeeDAOImpl();
		
		int res=dao.saveEmployee(emp);
		if(res>0) {
			out.print("<h1>"+"SUCCESS ADD!!!"+"</h1>");
		}
		else
			out.print("<h1>"+"FAILED TO ADD!!!"+"</h1>");
		
	

		

	}

}
