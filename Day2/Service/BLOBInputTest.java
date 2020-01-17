package first;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class BLOBInputTest {
    private Connection con;
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String dbURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public BLOBInputTest() {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, "root", "asd3356"); //JDBC연결
        
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM new_table");
 
            if(rs.next()){
                InputStream is = rs.getBinaryStream("file");
                String sql ="C:\\\\Users\\\\JUNG-SU\\\\Desktop\\\\Calendar\\\\src\\\\application\\\\Mains.java";
                FileOutputStream fos = new FileOutputStream(sql);
                byte[] buff = new byte[8192];
                int len;
                while( (len = is.read(buff)) > 0){
                    fos.write(buff, 0, len);
                }
                fos.close();
                is.close();
                rs.close();
            }
            con.close();
 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
        new BLOBInputTest();
        System.out.println("성공");
    }
 
}