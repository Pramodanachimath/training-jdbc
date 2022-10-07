package com.vfislk.training;

import java.util.Arrays;
import java.util.List;

public class User {
  public String greet(String userName) {
	
	  
	  return "Have a great day "+userName;
	  
  }
  
  public List<String> showFruits() {
	
	  List<String> fruits=Arrays.asList("Apple","Orange","Mango");
	  
	  return fruits;
	 
  }
}
