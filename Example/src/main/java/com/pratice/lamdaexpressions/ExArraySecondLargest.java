package com.pratice.lamdaexpressions;
import java.util.Scanner;

public class ExArraySecondLargest
{
    public static void main(String[] args) 
    {
    	// intialise here.
        int n, max;
        
        // create object of scanner class.
        Scanner Sc = new Scanner(System.in);
        
        // enter total number of elements.
        System.out.print("Enter total number of elements you wants : ");
        n = Sc.nextInt();
        
        // creating array object.
        int a[] = new int[n];
        
        // enter the elements here.
        System.out.println("Enter all the elements:");
        for (int i = 0; i < n; i++) 
        {
            a[i] = Sc.nextInt();
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (a[i] > a[j]) 
                {
                    max = a[i];
                    a[i] = a[j];
                    a[j] = max;
                }
            }
        }
        System.out.println("The Second Largest Elements in the Array is :"+a[n-2]);
    }
}
