package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.model.Comparators;
import com.model.Hospital;
import com.utility.DBUtility;

public class HospitalDAOImpl implements HospitalDAO {

	public int savePatient(Hospital medilife) {
		int i = 0;

		String sql = "insert into care values(?,?,?,?,?)";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, medilife.getMedID());
			ps.setString(2, medilife.getPname());
			ps.setInt(3, medilife.getAge());
			ps.setString(4, medilife.getDname());
			// java.sql.Date date = java.sql.Date.valueOf(medilife.getApdate());
			ps.setObject(5, medilife.getApdate());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("HospitalDAO saveperson: " + e);
		}
		return i;
	}

	public int deletePatient(Hospital medilife) {
		int i = 0;
		String sql = "DELETE FROM care WHERE MediId=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, medilife.getMedID());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("HospitalDAO  deleteStudent  " + e);
		}
		return i;
	}

	public int deletePatientByid(int id) {
		int i = 0;
		String sql = "DELETE FROM care WHERE MediId=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("HospitalDAO  deleteStudent  " + e);
		}
		return i;
	}

	public int updatePatient(Hospital medilife) {
		int i = 0;
		String sql = " UPDATE care set Pname=?,Dname=?, APdate=? ,Age=? where MediId=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(5, medilife.getMedID());
			ps.setString(1, medilife.getPname());
			ps.setInt(4, medilife.getAge());
			ps.setString(2, medilife.getDname());
			// java.sql.Date date = java.sql.Date.valueOf(medilife.getApdate());
			ps.setObject(3, medilife.getApdate());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("EmployeeDAO  UpdateEmployee   " + e);
		}
		return i;
	}

	public List<Hospital> getAllPatient() {

		List<Hospital> listP = new ArrayList<Hospital>();
		String sql = "SELECT * FROM care";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Date date = rs.getDate(5);

				Hospital patient = new Hospital(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						// LocalDate.of(date.getYear(), date.getMonth(), date.getDay())
						LocalDate.parse(date.toString()));

				listP.add(patient);

			}

		} catch (Exception e) {
			System.out.println(" HospitalDao  GET ALL Patient  " + e);
		}

		return listP;

	}

	@Override
	public List<Hospital> getPaitentsbyID(int id) {
		List<Hospital> listset = new ArrayList<Hospital>();
		String sql = "select * from care where MediId=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Date date = rs.getDate(5);

				Hospital hosp = new Hospital(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						LocalDate.parse(date.toString()));
				listset.add(hosp);
			}
		} catch (Exception e) {
			System.out.println("List All Patients" + e);

		}

		return listset;

	}

	public List<Hospital> shortIdAllPatient() {

		List<Hospital> listP = new ArrayList<Hospital>();
		String sql = "SELECT * FROM care";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Date date = rs.getDate(5);

				Hospital patient = new Hospital(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						// LocalDate.of(date.getYear(), date.getMonth(), date.getDay())
						LocalDate.parse(date.toString()));

				listP.add(patient);

			}

		} catch (Exception e) {
			System.out.println(" HospitalDao  GET ALL Patient  " + e);
		}

		Collections.sort(listP, Comparators.MEDIID);

		return listP;

	}

	public List<Hospital> shortPnameAllPatient() {

		List<Hospital> listP = new ArrayList<Hospital>();
		String sql = "SELECT * FROM care";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Date date = rs.getDate(5);

				Hospital patient = new Hospital(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						// LocalDate.of(date.getYear(), date.getMonth(), date.getDay())
						LocalDate.parse(date.toString()));

				listP.add(patient);

			}

		} catch (Exception e) {
			System.out.println(" HospitalDao  GET ALL Patient  " + e);
		}

		Collections.sort(listP, Comparators.PNAME);

		return listP;

	}
	
	public List<Hospital> shortAgeAllPatient() {

		List<Hospital> listP = new ArrayList<Hospital>();
		String sql = "SELECT * FROM care";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Date date = rs.getDate(5);

				Hospital patient = new Hospital(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						// LocalDate.of(date.getYear(), date.getMonth(), date.getDay())
						LocalDate.parse(date.toString()));

				listP.add(patient);

			}

		} catch (Exception e) {
			System.out.println(" HospitalDao  GET ALL Patient  " + e);
		}

		Collections.sort(listP, Comparators.AGE);

		return listP;

	}
	public List<Hospital> shortDnameAllPatient() {

		List<Hospital> listP = new ArrayList<Hospital>();
		String sql = "SELECT * FROM care";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Date date = rs.getDate(5);

				Hospital patient = new Hospital(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						// LocalDate.of(date.getYear(), date.getMonth(), date.getDay())
						LocalDate.parse(date.toString()));

				listP.add(patient);

			}

		} catch (Exception e) {
			System.out.println(" HospitalDao  GET ALL Patient  " + e);
		}

		Collections.sort(listP, Comparators.DNAME);

		return listP;

	}
	public List<Hospital> shortApdateAllPatient() {

		List<Hospital> listP = new ArrayList<Hospital>();
		String sql = "SELECT * FROM care";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Date date = rs.getDate(5);

				Hospital patient = new Hospital(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						// LocalDate.of(date.getYear(), date.getMonth(), date.getDay())
						LocalDate.parse(date.toString()));

				listP.add(patient);

			}

		} catch (Exception e) {
			System.out.println(" HospitalDao  GET ALL Patient  " + e);
		}

		Collections.sort(listP, Comparators.APDATE);

		return listP;

	}

}
