package com.pratice.lamdaexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example1 {

	public static void main(String[] args) {

		   //using lambda expression list
		    Set<String> places = new HashSet<>();
	        // add places and country to the list
	        places.add("Nepal, Kathmandu");
	        places.add(null);
	        places.add("India, Delhi");
	        places.add("USA, New York");
	        places.add("Africa, Nigeria");
	        
	     if(places.size()==1){
	    	System.out.println("hey got"); 
	     }
		    //using lambda expression
	        places.forEach(s -> System.out.println(s));
		
       
	        //Counting even numbers in a list, using Collection#stream() and java.util.stream.Stream
	        List<Integer> list =
	                Arrays.asList(3, 2, 12, 5, 6, 11, 13);
	        long count = list.stream()
	                         .filter(i -> i % 2 == 0)
	                         .count();
	        System.out.println(count);
	        
	        //Retrieving even number list
	        List<Integer> list1 = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
	        List<Integer> evenList =
	                             list1.stream()
	                            .filter(i -> i % 2 == 0)
	                            .collect(Collectors.toList());
	        System.out.println(evenList);
	        
	        //Finding whether all integers are less than 10 in the list
	        List<Integer> list2 =
	                Arrays.asList(3, 2, 12, 5, 6, 11, 13);
	        long b = list2.stream().filter(i -> i<10).count();
	                        ;
	        System.out.println(b);
	        
	        
	        Set<String> list3 =new HashSet();
	        list3.add("https://www.logicbig.com/tutorials/core-java-tutorial/java-util-stream/stateful-vs-stateless.html");
	        list3.add("https://www.logicbig.com/tutorials.html");
	        list3.add("https://www.logicbig.com/tutorials/java-ee-tutorial.html");
	        list3.add("https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs.html");
	        list3.add("https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/path-regex-matching.html");
	        list3.add("https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/jax-rs-client-api.html");
	        list3.add("https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/json-response.html");
	        list3.add("https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/path-regex-matching.html");
	        list3.stream()
            .filter(i -> i.replace("https://wwww", "").length()>70).forEach(i->System.out.println(i));
	       
	        System.out.println();
	         System.out.println( list3.stream()
                    .filter(i -> i.replace("https://wwww", "").length()>75)
                    .findFirst().toString().replace("Optional[", "").replace("]", ""));
                
	
	}

}
