import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import au.com.bytecode.opencsv.CSVWriter;

public class CsvWriter {

    public static void main(String args[]) {
        // File input path
      
        File file = new File("C:\\Om\\pam.csv");
        try {
            FileWriter output = new FileWriter(file);
            CSVWriter write = new CSVWriter(output);

            // Header column value
            String[] header = { "ID", "Name", "Address", "Phone Number" };
            write.writeNext(header);
         
            String[] data1 = { "1", "First Name", "Address1", "12345" };
         
            write.writeNext(data1);
            write.close();
        } catch (Exception e) {
           
            e.printStackTrace();

        }

        

    }
}