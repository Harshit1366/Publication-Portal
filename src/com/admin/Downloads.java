package com.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.ConnectionFactory;

/**
 * Servlet implementation class Downloads
 */
@WebServlet("/Downloads")
public class Downloads extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Downloads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection connection =null;
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		String id1=request.getParameter("id");
		int id=Integer.valueOf(id1);
		//System.out.println(name);
		String type=request.getParameter("type");
		String file2=null;
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			connection=ConnectionFactory.getConnection();
			PreparedStatement p1 = null;
			
			if(type.equals("journal")){
				p1 = connection.prepareStatement(
						"select plag_report from journal where id = ?");
			}
			else if(type.equals("books")){
				p1 = connection.prepareStatement(
						"select plag_report from books where id = ?");
			}
			else if(type.equals("books")){
				p1 = connection.prepareStatement(
						"select plag_report from books where id = ?");
			}
			else if(type.equals("books")){
				p1 = connection.prepareStatement(
						"select plag_report from books where id = ?");
			}
			else if(type.equals("books")){
				p1 = connection.prepareStatement(
						"select plag_report from books where id = ?");
			}
			else if(type.equals("books")){
				p1 = connection.prepareStatement(
						"select plag_report from books where id = ?");
			}
			else if(type.equals("books")){
				p1 = connection.prepareStatement(
						"select plag_report from books where id = ?");
			}
			
			
			p1.setInt(1, id);
			
			ResultSet rs=p1.executeQuery();
			while(rs.next()){
				file2=rs.getString(1);
				
				//System.out.println(file1);
			}
			
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		

		String filepath = "C:\\Users\\Harshit\\Desktop\\new\\";   
		
		File files = new File(filepath+file2);

		response.setHeader("Content-Disposition","attachment; filename=\"" + files.getName() + "\"");  
		  
		  
		FileInputStream fileInputStream = new FileInputStream(files);               
		int i;   
		while ((i=fileInputStream.read()) != -1) {  
		out.write(i);   
		}   
		fileInputStream.close();   
		out.close();  
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
