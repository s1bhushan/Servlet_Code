package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HospitalDAO;
import com.dao.HospitalDAOImpl;


//@WebServlet("/HospitalDeleteServlet")
public class HospitalDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HospitalDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int medID=Integer.parseInt(request.getParameter("MediId"));
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/read");
		HospitalDAO dao=new HospitalDAOImpl();
		
		int res=dao.deletePatientByid(medID);
		if(res>0) {
			out.print("<h1>"+"SUCCESS DELETE!!!"+"</h1>");
			rd.include(request, response);
		}
		else {
			out.print("<h1>"+"FAILED TO DELETE!!!"+"</h1>");
		rd.include(request, response);
		}



	}

}
