package studentpackage;

import java.sql.*;


public class StudentProject {

	public static void main(String[] args) throws Exception 
	{
		String url = "jdbc:mysql://localhost:3306/shivadb";
		String uname = "root";
		String pass = "Shiv@hari1mysql";
		String query = "select * from student";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		String userData = "";
		
		while(rs.next())
		{
		userData = rs.getInt(1) + " : " + rs.getString(2);
		
		System.out.println(userData);
		}
		
		st.close();
		con.close();

	}

}
