// A Java program to demonstrate random number generation 
// using java.util.Random; 
import java.util.Random; 
  
public class generateRandom{ 
  
    public static void main(String args[]) 
    { 
    	int number=7000;
        int rand_int1 = randomNumber(number); 

        // Print random integers 
        System.out.println("Random Integers: "+rand_int1); 
  
    }

	public static int randomNumber(int number) {
		// create instance of Random class 
        Random rand = new Random(); 
  
        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(number);
		return rand_int1;
	} 
} 