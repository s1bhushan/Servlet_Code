package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SocietyDAO;
import com.dao.SocietyDAOImpl;
import com.model.Society;

//@WebServlet("/SocietyReadServlet")
public class SocietyReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SocietyReadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		SocietyDAO dao = new SocietyDAOImpl();

		List<Society> flatList = dao.getAllFlates();

		Iterator<Society> itr = flatList.iterator();

		out.print("<table style='border:1px solid black'>");
		out.print("<tr>");
		out.print("<th> Wing </th>");
		out.print("<th> Flateno </th>");
		out.print("<th> Name </th>");
		out.print("<th> Amount </th>");
		out.print("</tr>");

		while(itr.hasNext()) {
			Society flat = (Society) itr.next();
			out.print("<tr>");
			out.print("<td>" + flat.getWing() + "</td>");
			out.print("<td>" + flat.getFlatno() + "</td>");
			out.print("<td>" + flat.getName()+ "</td>");
			out.print("<td>" + flat.getAmount() + "</td>");
			out.print("</tr>");
		}

		out.print("</table>");

	}

}
