package com.aldrich.om;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class SelectDataDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement selectStmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://10.100.10.101:3306/pase", "root", "12345");
                         
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select c.id as pase_id,c.url as url from company c inner join company_profile cp on c.id=cp.fk_company_id  where c.relevant='yes-tracking' and (state='' or state is null or state='N/A' or state='NA' or state='unknown' or state='not available' or city='' or city is null or city='N/A' or city='NA' or city='unknown' or city='not available') order by c.id;");
            while(rs.next())
            {
                System.out.println(rs.getString(1));    //First Column
                System.out.println(rs.getString(2));    //Second Column
               
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                selectStmt.close();
             
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
 