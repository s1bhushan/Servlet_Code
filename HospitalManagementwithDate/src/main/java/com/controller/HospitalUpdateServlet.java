package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HospitalDAO;
import com.dao.HospitalDAOImpl;
import com.model.Hospital;



//@WebServlet("/HospitalUpdateServlet")
public class HospitalUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HospitalUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		int medID=Integer.parseInt(request.getParameter("MediId"));
		String pname=request.getParameter("Pname");
		String dname=request.getParameter("Dname");
		
		LocalDate apdate=LocalDate.parse(request.getParameter("APdate"));

		
		int age=Integer.parseInt(request.getParameter("Age"));
		
		
		Hospital hospital=new Hospital(medID, pname,age, dname,apdate);
		
		HospitalDAO dao=new HospitalDAOImpl();
		RequestDispatcher rd=request.getRequestDispatcher("/read");

		
		int res=dao.updatePatient(hospital);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS UPDATE!!!" + "</h1>");
			rd.include(request, response);

		} else {
			out.print("<h1>" + "FAILED TO UPDATE!!!" + "</h1>");
			rd.include(request, response);

		}

	}

}
