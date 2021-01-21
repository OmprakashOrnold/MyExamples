
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author imssbora
 */
public class SelectRecordExample1 {

  public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/pase_local";
    String username = "root";
    String password = "p@s3$123";
    String sql = "select id from company;";
    
    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
        Statement stmt = conn.createStatement(); 
        ResultSet rs = stmt.executeQuery(sql);) {
     
      while (rs.next()) {
        System.out.println(rs.getString(1));
      
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
