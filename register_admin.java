import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
@WebServlet("/register_admin")
public class register_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String numbers = request.getParameter("number");
        String id = request.getParameter("id");
        String pass = request.getParameter("psw");
    	try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","v.venkat");
			PreparedStatement ps = conn.prepareStatement
                    ("insert into admintable values(?,?,?,?,?,?,?)");
	        ps.setString(1, fname);
	        ps.setString(2,lname);
	        ps.setString(3,age);
	        ps.setString(4,gender);
	        ps.setString(5,numbers);
	        ps.setString(6,id);
	        ps.setString(7,pass);
	        int i = ps.executeUpdate();
	        if(i!=0){
	        	out.println("Submitted");
	        }else{
	        	out.println("not Submitted");
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

}
