package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.ConnectionFactory;

/**
 * Servlet implementation class pcn
 */
@WebServlet("/pcn")
public class pcn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pcn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	    String pcn=null;
		String dept=request.getParameter("dept");
		String year=request.getParameter("year");
		//String name=request.getParameter("authors_name");
		String id1=request.getParameter("id");
		int id=Integer.valueOf(id1);
		int val=1000+id;
		String type=request.getParameter("type");
		
		Calendar now = Calendar.getInstance();
		int current = now.get(Calendar.MONTH) + 1;
		String cur_month = null;
		
//		try{
//			connection=ConnectionFactory.getConnection();
//			PreparedStatement ps=connection.prepareStatement("sel set pcn = ?,status=?,pcn_month=? where id = ?");
//			ps.setString(1, pcn);
//			ps.setString(2, "accepted");
//			ps.setString(3, cur_month);
//			ps.setInt(4, id);
//			ps.executeUpdate();
//
//			response.sendRedirect("Journal/Journal.jsp");
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		

		switch (current) {
		case 1:
			cur_month = "January";
			break;
		case 2:
			cur_month = "February";
			break;
		case 3:
			cur_month = "March";
			break;
		case 4:
			cur_month = "April";
			break;
		case 5:
			cur_month = "May";
			break;
		case 6:
			cur_month = "June";
			break;
		case 7:
			cur_month = "July";
			break;
		case 8:
			cur_month = "August";
			break;
		case 9:
			cur_month = "September";
			break;
		case 10:
			cur_month = "October";
			break;
		case 11:
			cur_month = "November";
			break;
		case 12:
			cur_month = "December";
			break;
        default:
			System.out.println("failed");
		}
		
		
		//PrintWriter out = response.getWriter();
		//out.println(dept);
		//out.println(year);
		
		if(dept.equals("CSE")){
			dept="CSU";
		}
		else if(dept.equals("ME")){
			dept="MU";
		}
		else if(dept.equals("ECE")){
			dept="ECU";
		}
		else if(dept.equals("CE")){
			dept="CU";
		}
		
		int y=Integer.parseInt(year);
		//out.println(y);
		
		y-=2000;
		
		year=String.valueOf(y);
		
		String value=String.valueOf(val);
		
		if(type.equals("journal")){
			pcn=year+dept+'J'+value;
		}
		else if(type.equals("books")){
			pcn=year+dept+'B'+value;
		}
		else if(type.equals("book_chapter")){
			pcn=year+dept+'O'+value;
		}
		else if(type.equals("conf_proceedings")){
			pcn=year+dept+'P'+value;
		}
		else if(type.equals("conf_presentations")){
			pcn=year+dept+'C'+value;
		}
		else if(type.equals("patents")){
			pcn=year+dept+'T'+value;
		}
		else if(type.equals("tech_reports")){
			pcn=year+dept+'R'+value;
		}
		
		
		
	//	String uniqueID = UUID.randomUUID().toString();
		
	//  println(uniqueID);
		
		try{
			
			PreparedStatement  ps=null;
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
		
			if(type.equals("journal")){
				ps=connection.prepareStatement("update journal set pcn = ?,status=?,pcn_month=? where id = ?");
			}
			else if(type.equals("books")){
				ps=connection.prepareStatement("update books set pcn = ?,status=?,month_pcn=? where id = ?");
			}
		/*	else if(type.equals("books")){
				ps=connection.prepareStatement("update books set pcn = ?,status=?,pcn_month=? where id = ?");
			}
			else if(type.equals("books")){
				ps=connection.prepareStatement("update books set pcn = ?,status=?,pcn_month=? where id = ?");
			}
			else if(type.equals("books")){
				ps=connection.prepareStatement("update books set pcn = ?,status=?,pcn_month=? where id = ?");
			}
			else if(type.equals("books")){
				ps=connection.prepareStatement("update books set pcn = ?,status=?,pcn_month=? where id = ?");
			}
			else if(type.equals("books")){
				ps=connection.prepareStatement("update books set pcn = ?,status=?,pcn_month=? where id = ?");
			}*/
			
			ps.setString(1, pcn);
			ps.setString(2, "accepted");
			ps.setString(3, cur_month);
			ps.setInt(4, id);
			ps.executeUpdate();

			
			if(type.equals("journal")){
				response.sendRedirect("Journal/Journal.jsp");

			}
			else if(type.equals("books")){
				response.sendRedirect("Books/Books.jsp");
			}
		/*	else if(type.equals("book_chapter")){
				pcn=year+dept+'O'+value;
			}
			else if(type.equals("conf_proceedings")){
				pcn=year+dept+'P'+value;
			}
			else if(type.equals("conf_presentations")){
				pcn=year+dept+'C'+value;
			}
			else if(type.equals("patents")){
				pcn=year+dept+'T'+value;
			}
			else if(type.equals("tech_reports")){
				pcn=year+dept+'R'+value;
			}*/
								
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
