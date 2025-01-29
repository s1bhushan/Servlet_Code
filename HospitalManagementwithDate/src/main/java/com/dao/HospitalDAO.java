package com.dao;

import java.util.List;


import com.model.Hospital;

public interface HospitalDAO{
	
	int savePatient(Hospital medilife);
	int deletePatient(Hospital medilife);
	int deletePatientByid(int id);
	
	int updatePatient(Hospital medilife);
	
	
	List<Hospital> getAllPatient();
	List<Hospital> getPaitentsbyID(int id);
	List<Hospital> shortIdAllPatient();
	List<Hospital> shortPnameAllPatient();
	List<Hospital> shortAgeAllPatient();
	List<Hospital> shortDnameAllPatient();
	List<Hospital> shortApdateAllPatient();
	
	

}
