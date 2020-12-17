package com.pratice.lamdaexpressions;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {

    // create an object of list using ArrayList
    static List<String> places = new ArrayList<>();

    // preparing our data
    public static List<String> getPlaces(){

        // add places and country to the list
        places.add("Nepal, Kathmandu");
        places.add("Nepal, Pokhara");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Africa, Nigeria");

        return places;
    }

    public static void main( String[] args ) {

        List<String> myPlaces = getPlaces();
        System.out.println("Places from Nepal:");
        
        // Filter places from Nepal
        myPlaces.stream().forEach((p) -> System.out.println(p));
    }

}
