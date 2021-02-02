package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String name=request.getParameter("user");
			String password = request.getParameter("password");
			String dbName = null;
			String dbpassword = null;
			String sql = "select * from registration where name=? and password=?";
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","HR","hr");
			   PreparedStatement ps =con.prepareStatement(sql);
			   ps.setString(1,name);
			   ps.setString(2,password);
			  ResultSet rs = ps.executeQuery();
			  PrintWriter out = response.getWriter();
			  while(rs.next()) {
				  dbName = rs.getString(1);
				  dbpassword = rs.getString("password");
			  }
			  if(name.equals(dbName)&&password.equals(dbpassword)) {
				  out.println("You have sucessfully logined");
			  }
			  else {
//				  response.sendRedirect("registration.jsp");
				  RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				          rd.include(request, response);
			  }
			  
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	   catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
