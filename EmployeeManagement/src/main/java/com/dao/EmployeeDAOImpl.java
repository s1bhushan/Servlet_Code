package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.utility.DBUtility;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public int saveEmployee(Employee emp) {
		int i=0;
		String sql = "insert into emp values(?,?,?,?)";
		
		try(Connection con=DBUtility.getDBConnection();PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4,emp.getYear());
			
			i = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println("EmployeeDAO  SaveEmployee   " + e);
		}
		return i;
	}
	
	public int deleteEmployee(Employee emp) {
		int i=0;
		String sql="delete from emp where id=?";
		
		try(Connection con=DBUtility.getDBConnection(); PreparedStatement ps=con.prepareStatement(sql);){
			ps.setInt(1,emp.getId());
			i=ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("EmployeeDAO  deleteEmployee  " + e);
		}
		return i;
	}
	
	public int deleteEmployeebyID(int id) {
		int i=0;
		String sql="delete from emp where id=?";
		
		try(Connection con=DBUtility.getDBConnection(); PreparedStatement ps=con.prepareStatement(sql);){
			ps.setInt(1,id);
			i=ps.executeUpdate();			
		}catch(Exception e) {
			System.out.println("EmployeeDAO  deleteEmployee  " + e);
		}
		return i;
	}
	
	public int updateEmployee(Employee upEmp) {
		int i = 0;
		String sql = "UPDATE emp set name=? , salary=?,year=? where id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, upEmp.getName());
			ps.setDouble(2, upEmp.getSalary());
			ps.setInt(3, upEmp.getYear());
			ps.setInt(4, upEmp.getId());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("EmployeeDAO  UpdateEmployee   " + e);
		}
		return i;
	}
	
	public List<Employee> getAllEmployee(){
		
		List<Employee> empList=new ArrayList<Employee>(); 
		String sql="select * from emp";
		
		try(Connection con=DBUtility.getDBConnection(); PreparedStatement ps=con.prepareStatement(sql)){
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {

			  Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3) ,rs.getInt(4));
				empList.add(emp);

			}

		}catch(Exception e) {
			System.out.println("EmployeeDAO  get All Student   " + e);
		}
		return empList;
		
	}
	
	public Employee getEmployeeById(int id) {

		String sql = "SELECT * FROM emp WHERE id=?";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
				return emp;
			}

		} catch (Exception e) {
			System.out.println(" EmployeeDAO   GET ALL Employee  " + e);
		}

		return null;

	}


}
