package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleTransaction {
	public static void main(String[] args) throws SQLException {
		Connection conn;
		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Sehwag@219");
			conn.setAutoCommit(false);
			try{
				saveCity(conn);
				saveUser(conn,false);
				System.out.println("Data saved Succesfully  commitung the Transaction");
				conn.commit();
			}
			catch(SQLException se){
			System.err.println("Error while saving data   rolling back the transaction");
			conn.rollback();
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	}

	private static void saveUser(Connection conn, boolean generatedError) throws SQLException {
		PreparedStatement ps1=conn.prepareStatement("insert into user_table values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		ps1.setInt(1,2);
		ps1.setString(2, "user2_3121");
		ps1.setString(3,"Gutta");
		ps1.setString(4, "Ajay");
		if(generatedError)
			ps1.setString(5, "1234567");
		else
			ps1.setString(5, "12345");
		ps1.executeUpdate();
		ResultSet res=ps1.getGeneratedKeys();
		while(res.next()){
			System.out.println("primary key in user_table" +res.getString(1));
		}
		
	}

	private static void saveCity(Connection conn) throws SQLException {
		PreparedStatement ps2=conn.prepareStatement("insert into cities(name,location) values(?,?)",Statement.RETURN_GENERATED_KEYS);
		ps2.setString(1, "Robstown");
		ps2.setString(2, "TX");
		ps2.executeUpdate();
		ResultSet res=ps2.getGeneratedKeys();
		while(res.next()){
			System.out.println("primary key in cities" +res.getString(3));
		}
	}

}
