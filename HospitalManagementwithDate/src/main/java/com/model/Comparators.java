package com.model;

import java.util.Comparator;

public class Comparators {
	
	
	public static Comparator<Hospital> MEDIID=new Comparator<Hospital>() {
		
		@Override
		public int compare(Hospital o1, Hospital o2) {
			// TODO Auto-generated method stub
			return o1.getMedID() - o2.getMedID();
		}
	
	};
	
	public static Comparator<Hospital> PNAME=new Comparator<Hospital>() {
		

		@Override
		public int compare(Hospital o1, Hospital o2) {
			// TODO Auto-generated method stub
			return o1.getPname().compareTo(o2.getPname());
		}
	
	};
	
	public static Comparator<Hospital> AGE=new Comparator<Hospital>() {
		

		@Override
		public int compare(Hospital o1, Hospital o2) {
			// TODO Auto-generated method stub
			return o1.getAge() - o2.getAge();
		}
	
	};
	
	public static Comparator<Hospital> DNAME=new Comparator<Hospital>() {
		
		@Override
		public int compare(Hospital o1, Hospital o2) {
			// TODO Auto-generated method stub
			return o1.getDname().compareTo(o2.getDname());
		}
	
	};
	
	public static Comparator<Hospital> APDATE=new Comparator<Hospital>() {
		

		@Override
		public int compare(Hospital o1, Hospital o2) {
			// TODO Auto-generated method stub
			int i = o1.getApdate().compareTo(o2.getApdate());
            if (i == 0) {
                i = o1.getMedID() - o2.getMedID();
            }
            return i;
		}
	
	};

}
