package shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserInfo {
public static void main(String[] args) throws SQLException {
	//OrderInfo o1=new OrderInfo(436442,"Mountain dew",11.99);
	//OrderInfo o2=new OrderInfo(8743,"Budwiser",9.99);
	int userid=1;
		//addOrderToUser(o1,userid);
		//updateOrderToUser(o2,userid1);
	List<OrderInfo> li=new ArrayList<OrderInfo>();
	li=readOrdersForUser(userid);
	System.out.println("orders for "+userid+" are ");
	for (Object object : li) {
		System.out.println(object);	
		}
	
	
		System.out.println("finished");
}

private static List<OrderInfo> readOrdersForUser(int userid) throws SQLException {
	Connection conn;
	Statement stmt;
	List<OrderInfo> list=new ArrayList<OrderInfo>();
	try {
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Sehwag@219");
		stmt=conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from orderInfo");
			int pid=0;
			String title=null;
			double price=0.0;
			int uid=0;
		if(res!=null){
			while(res.next()){
				pid=res.getInt("pid");
				title=res.getString("title");
				price=res.getDouble("price");
				uid=res.getInt("uid");
				if(uid==userid){
				list.add(new OrderInfo(pid,title,price));
				}
			}
		}
		conn.close();
		stmt.close();
		
	} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	return list;
}

/*private static void updateOrderToUser(OrderInfo o2, int userid1) throws SQLException {
	Connection conn;
	Statement stmt;
	;
	try {
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Sehwag@219");
		stmt=conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from userinfo");
		if(res!=null){
			while(res.next()){
				if(res.getInt("id")==userid1){
					o2.orders(userid1);
					
				}
			}
		}
		conn.close();
		stmt.close();
		
	} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
}

private static void addOrderToUser(OrderInfo o1, int userid) throws SQLException {
	Connection conn;
	Statement stmt;
	;
	try {
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Sehwag@219");
		stmt=conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from userinfo");
		if(res!=null){
			while(res.next()){
				if(res.getInt("id")==userid){
					o1.orders(userid);
					
				}
			}
		}
		conn.close();
		stmt.close();
		
	} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	
}*/
}