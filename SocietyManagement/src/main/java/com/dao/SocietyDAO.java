package com.dao;

import java.util.List;

import com.model.Society;

public interface SocietyDAO {
	
	int saveinfo(Society Appartment);
	int updateinfo(Society Appartment);
	int deleteinfo(Society Appartment);
	int deleteinfobyFlatno(int no);
	List<Society> getAllFlates();
	

}
