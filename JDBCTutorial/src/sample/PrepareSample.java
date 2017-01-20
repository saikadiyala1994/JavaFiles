package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareSample {
public static void main(String[] args) throws SQLException {
	Connection conn;
	PreparedStatement pstmt;
	try {
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
		pstmt=conn.prepareStatement("insert into cities(name,location) values(?,?)",Statement.RETURN_GENERATED_KEYS);
		String[] city={"a","b","c","d"};
		System.out.println("Hello");
		String[] location={"A","B","C","D"};
		for (int i = 0; i < location.length; i++) {
			pstmt.setString(1, city[i]);
			pstmt.setString(2, location[i]);
			pstmt.executeUpdate();
		}
		ResultSet res=pstmt.getGeneratedKeys();
		while(res.next()){
			System.out.println(" Primary key"+res.getString(3));
		}
		pstmt.close();
		conn.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
}
