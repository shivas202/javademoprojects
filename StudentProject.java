package studentpackage;

import java.sql.*;


public class StudentProject {

	public static void main(String[] args) throws Exception 
	{
		String url = "jdbc:mysql://localhost:3306/shivadb";
		String uname = "root";
		String pass = "Shiv@hari1mysql";
		int studentid = 5;
		String studentname = "GMR";
		String query = "insert into student values (" + studentid + ",'" + studentname + "')";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		int count = st.executeUpdate(query);
		
		
		
		System.out.println(count + "row/s affected");
		
		
		st.close();
		con.close();

	}

}
