package studentpackage;

import java.sql.*;


public class StudentProject {

	public static void main(String[] args) throws Exception 
	{
		String url = "jdbc:mysql://localhost:3306/shivadb";
		String uname = "root";
		String pass = "Shiv@hari1mysql";
		int studentid = 6;
		String studentname = "kempegowda";
		String query = "insert into student values (?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, studentid);
		st.setString(2, studentname);
		int count = st.executeUpdate();
		
		
		
		System.out.println(count + "row/s affected");
		
		
		st.close();
		con.close();

	}

}
