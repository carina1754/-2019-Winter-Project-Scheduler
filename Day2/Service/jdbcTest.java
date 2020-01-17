package first;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

public class jdbcTest {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","asd3356");
		
		String qu = "select * from new_table";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qu);
		
		while(rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");

			System.out.format("%s %s\n",id, pw);
		}
		System.out.println("success");
		st.close();
	}catch(Exception e) {
		System.err.println("Got an exception");
		System.err.println(e.getMessage());
	}
}
}
