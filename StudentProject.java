package studentpackage;

import java.sql.*;


public class StudentProject {

	public static void main(String[] args) throws Exception 
	{
		String url = "jdbc:mysql://localhost:3306/shivadb";
		String uname = "root";
		String pass = "Shiv@hari1mysql";
		String query = "insert into student values (4, 'heethru')";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		int count = st.executeUpdate(query);
		
		
		
		System.out.println(count + "row/s affected");
		
		
		st.close();
		con.close();

	}

}
