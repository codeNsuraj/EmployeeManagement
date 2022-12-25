package com.employeemanagement.controller;

import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, String> map = new HashMap<>();
		map.put("Rohan", "123");
		map.put("Sheetal", "153");
		map.put("Mohan", "143");
		
		map.forEach((x,y)->System.out.println(x+" "+y));

	}

}
