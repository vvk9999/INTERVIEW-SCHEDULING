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
@WebServlet("/Hr_review")
public class Hr_review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hr_review() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String eb = request.getParameter("eb");
        String exp = request.getParameter("exp");
        String tech = request.getParameter("tech");
        String cs = request.getParameter("cs");
        int marks = Integer.parseInt(request.getParameter("marks"));
        String rating = request.getParameter("rating");
        int cexp=Integer.parseInt(request.getParameter("cexp"));
        String Mode=null;
        String result=null;
      if(cexp<=3)
      {
    	  Mode="Online test";
      }
      else if(cexp>3 && cexp<=6 )
      {
    	  Mode="In Person";
      }
      else
      {
    	  Mode="Telephonic";
      }
      if(marks < 60 )
      {
    	  result ="Rejected";
      }
      
      else if(marks >60 && marks<65 )
      {
    	  result ="Second opinion";
      }
      
      else
      {
    	  result="Selected";
      }
    	try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","v.venkat");
			PreparedStatement ps = conn.prepareStatement
                    ("insert into interview values(?,?,?,?,?,?,?,?,?,?)");
	        ps.setString(1, id);
	        ps.setString(2,eb);
	        ps.setString(3,exp);
	        ps.setString(4,tech);
	        ps.setString(5,cs);
	        ps.setInt(6,marks);
	        ps.setString(7,rating);
	        ps.setInt(8,cexp);
	        ps.setString(9,Mode);
	        ps.setString(10,result);
	        
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
