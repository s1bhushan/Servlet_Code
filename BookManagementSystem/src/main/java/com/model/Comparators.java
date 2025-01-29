package com.model;

import java.util.Comparator;

public class Comparators {
	
	 public static Comparator<Book> NAME = new Comparator<Book>() {
         @Override
         public int compare(Book o1, Book o2) {
             return o1.getName().compareTo(o2.getName());
         }
     };
     public static Comparator<Book> ID = new Comparator<Book>() {
         @Override
         public int compare(Book o1, Book o2) {
             return o1.getId() - o2.getId();
         }
     };
     
     public static Comparator<Book> RevID = new Comparator<Book>() {
         @Override
         public int compare(Book o1, Book o2) {
             return o2.getId()-o1.getId();
         }
     };
     
     
     public static Comparator<Book> PRICE = new Comparator<Book>() {
         @Override
         public int compare(Book o1, Book o2) {
             return (int) (o1.getPrice() - o2.getPrice());
         }
     };
     
     public static Comparator<Book> DATE = new Comparator<Book>() {
         @Override
         public int compare(Book o1, Book o2) {
             int i = o1.getDate().compareTo(o2.getDate());
             if (i == 0) {
                 i = o1.getId() - o2.getId();
             }
             return i;
         }

     };
}
