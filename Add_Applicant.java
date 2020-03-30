import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add_Applicant
 */
@WebServlet("/Add_Applicant")
public class Add_Applicant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Applicant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static int y=1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String empid=request.getParameter("id");
		String domain=request.getParameter("domain");
		String requiredvac=request.getParameter("vac");
		String date=request.getParameter("date");
		String priority=request.getParameter("priority");
		int experience=Integer.parseInt(request.getParameter("exp"));
		String type=null;
		if(experience <= 2){
			type="Written test";
		}else if(experience>2 & experience<6){
			type="personal interview";
		}
		else
		{
			type="Telephonic interview";
		}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","v.venkat");
			PreparedStatement ps = conn.prepareStatement
                    ("insert into applicant values(?,?,?,?,?,?,?,?)");
	        ps.setInt(1, y);
	        ps.setString(2, empid);
	        ps.setString(3, domain);
	        ps.setString(4, requiredvac);
	        ps.setString(5, date);
	        ps.setString(6,priority);
	        ps.setInt(7,experience);
	        ps.setString(8,type);
	        
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

