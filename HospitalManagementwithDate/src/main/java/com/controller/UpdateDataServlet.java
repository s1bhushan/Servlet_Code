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

import com.dao.HospitalDAO;
import com.dao.HospitalDAOImpl;
import com.model.Hospital;



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
		
		HospitalDAO dao = new HospitalDAOImpl();


		List<Hospital> bookList = dao.getPaitentsbyID(id);

		Iterator<Hospital> itr = bookList.iterator();
		out.print("<head>");
		out.print("<link rel=\"stylesheet\" href=\"./css/table.css\">");
		out.print("</head>");

		out.print("<table id='customers'>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> PNAME </th>");
		out.print("<th> Age </th>");
		out.print("<th> DName </th>");
		out.print("<th> ApDate </th>");
		out.print("<th> Remove </th>");
		out.print("<th> Update </th>");
		out.print("</tr>");

		while (itr.hasNext()) {
			Hospital hospital = (Hospital) itr.next();
			out.print("<tr>");
			out.print("<td>" + hospital.getMedID() + "</td>");
			out.print("<td>" + hospital.getPname() + "</td>");
			out.print("<td>" + hospital.getAge() + "</td>");
			out.print("<td>" + hospital.getDname() + "</td>");
			out.print("<td>" + hospital.getApdate() + "</td>");
			out.print("<td>");
			out.print("<a href='delete?MediId="+hospital.getMedID()+"'>"+"DELETE"+"</a>");
			out.print("</td>");
			out.print("<td>");
			out.print("<a href='UpdateDataServlet?id="+hospital.getMedID()+"'>"+"UPDATE"+"</a>");
			out.print("</td>");
			updateid=hospital.getMedID();
			out.print("</tr>");
		}

		out.print("</table>");
		

		out.print("<table id='customers'>");
		out.print("<tr>");
	     	
            out.print("<h1>Hospital ADD Form</h1>");
            out.print("<hr>");
			out.print("<form action=\"update\" method=\"get\">");
			out.print("<th> MediId   :<input type=\"text\" name=\"MediId\" value=\""+updateid+"\"></th>");
			out.print("<th>Pname : <input type=\"text\" name=\"Pname\"><br></th>");
			out.print("<th>Age: <input type=\"text\" name=\"Age\"><br></th>");
			out.print("<th>Dname: <input type=\"text\" name=\"Dname\"><br></th>");
			out.print("<th>APdate : <input type=\"Date\" name=\"APdate\"><br></th>");
			
			out.print("<th><input type=\"submit\" value=\"SUBMIT\"></th>");
		
			out.print("</form>");
			out.print("</tr>");
			out.print("</table>");


	}

}
