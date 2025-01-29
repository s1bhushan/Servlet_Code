package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Society;
import com.utility.DBUtility;

public class SocietyDAOImpl implements SocietyDAO {

	public int saveinfo(Society Appartment) {
		int i = 0;

		String sql = " insert into home values(?,?,?,?);";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, Appartment.getWing());
			ps.setInt(2, Appartment.getFlatno());
			ps.setString(3, Appartment.getName());
			ps.setDouble(4, Appartment.getAmount());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("SocietyDAO saveinfo: " + e);
		}
		return i;
	}

	public int updateinfo(Society Appartment) {
		int i = 0;
		String sql = "UPDATE home set name=?, Mamount=? where (Wing=? &&flatno=?)";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(3, Appartment.getWing());
			ps.setString(1, Appartment.getName());
			ps.setDouble(2, Appartment.getAmount());
			ps.setInt(4, Appartment.getFlatno());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("SocietyDAO  Update Home   " + e);
		}
		return i;
	}

	public int deleteinfo(Society Appartment) {
		int i = 0;
		String sql = "DELETE FROM home WHERE flatno=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, Appartment.getFlatno());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("SocietyDAO deleteinfo  " + e);
		}
		return i;
	}

	public int deleteinfobyFlatno(int no) {
		int i = 0;
		String sql = "DELETE FROM home WHERE flatno=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, no);

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("SocietyDAO deleteinfobyno  " + e);
		}
		return i;
	}

	public List<Society> getAllFlates() {

		List<Society> listP = new ArrayList<Society>();
		String sql = "SELECT * FROM home";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Society itroom = new Society(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
				listP.add(itroom);

			}

		} catch (Exception e) {
			System.out.println(" SocietyDAO   GET ALL Flat Count  " + e);
		}

		return listP;

	}

}
