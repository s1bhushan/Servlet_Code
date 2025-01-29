package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;



//@WebServlet("/EmployeeReadServlet")
public class EmployeeReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EmployeeReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		EmployeeDAO dao=new EmployeeDAOImpl();
		
		List<Employee> empList=dao.getAllEmployee();
		
		Iterator<Employee> itr = empList.iterator();
		
		out.print("<table style='border:1px solid black'>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> Salary </th>");
		out.print("<th> Year </th>");
		out.print("</tr>");
		
		while (itr.hasNext()) {
			Employee emp = (Employee) itr.next();
			out.print("<tr>");
			out.print("<td>" + emp.getId() + "</td>");
			out.print("<td>" + emp.getName() + "</td>");
			out.print("<td>" + emp.getSalary() + "</td>");
			out.print("<td>" + emp.getYear() + "</td>");
			out.print("</tr>");
		}

		out.print("</table>");
		
		
		
	}

}
