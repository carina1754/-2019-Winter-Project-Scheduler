package first;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class BLOBOutputTest {
 
    //전역변수선언
    private Connection con;
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String dbURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public BLOBOutputTest(String fileName) {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL, "root", "asd3356");
            
            int maxID = getMaxID(con) +1;
            File file = new File(fileName);
            int fileLength = (int)file.length();
            System.out.println("fileLength : "+fileLength);
            InputStream is = new FileInputStream(file);
            
            String sql ="insert into new_table (id, filename, file) values (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, maxID);
            pstmt.setString(2, fileName);
            pstmt.setBinaryStream(3, is, fileLength);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected int getMaxID(Connection con) throws SQLException{
        
        int maxID = 0;
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("select max(id) from new_table");
        while(result.next()){
            maxID = result.getInt(1);
        }
        result.close();
        stmt.close();
        return maxID;
    }
    
    public static void main(String[] args) {
        String fileName = "C:\\Users\\JUNG-SU\\Desktop\\Calendar\\src\\application\\Main.java";
        BLOBOutputTest fileup = new BLOBOutputTest(fileName);
        System.out.println("성공");
 
    }
 
}