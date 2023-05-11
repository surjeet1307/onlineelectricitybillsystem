package BillApplication;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	Conn(){
		try {
			
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","Surjeet@9780");
			s=c.createStatement();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
