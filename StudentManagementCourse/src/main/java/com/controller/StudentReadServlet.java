
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Student;

//@WebServlet("/StudentReadServlet")
public class StudentReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		StudentDAO dao = new StudentDAOImpl();

		List<Student> studList = dao.getAllStudent();

		Iterator<Student> itr = studList.iterator();

		out.print("<table style='border:1px solid black'>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> MARKS </th>");
		out.print("</tr>");

		while (itr.hasNext()) {
			Student student = (Student) itr.next();
			out.print("<tr>");
			out.print("<td>" + student.getRollno() + "</td>");
			out.print("<td>" + student.getName() + "</td>");
			out.print("<td>" + student.getMarks() + "</td>");
			out.print("</tr>");
		}

		out.print("</table>");

	}


	}
