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
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection=null;
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		//String name=request.getParameter("authors_name");
		//System.out.println(name);
		String id1=request.getParameter("id");
		int id=Integer.valueOf(id1);
		String file1 = null;
		String type=request.getParameter("type");
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			connection=ConnectionFactory.getConnection();
			PreparedStatement p1=null;
			
			if(type.equals("journal")){
				p1 = connection.prepareStatement(
						"select journal_file from journal where id = ?");
			}
			else if(type.equals("books")){
				p1 = connection.prepareStatement(
						"select book_file from books where id = ?");
			}
			else if(type.equals("book_chapter")){
				p1 = connection.prepareStatement(
						"select chap_file from book_chap where id = ?");
			}
			else if(type.equals("conf_proceedings")){
				p1 = connection.prepareStatement(
						"select pro_file from conf_proceedings where id = ?");
			}
			else if(type.equals("conf_presentations")){
				p1 = connection.prepareStatement(
						"select pre_file from conf_presentations where id = ?");
			}
			else if(type.equals("patents")){
				p1 = connection.prepareStatement(
						"select patent_file from patents where id = ?");
			}
			else if(type.equals("tech_report")){
				p1 = connection.prepareStatement(
						"select tech_report from tech_report where id = ?");
			}
			
			p1.setInt(1, id);
			
			ResultSet rs=p1.executeQuery();
			while(rs.next()){
				file1=rs.getString(1);
				//System.out.println(file1);
			}
			
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		 
		String filepath = "C:\\Users\\Harshit\\Desktop\\new\\";   
		File file = new File(filepath+file1);
		
		//out.println(file.getAbsolutePath()+ "    "+ file.getName() );
		   

		response.setHeader("Content-Disposition","attachment; filename=\"" + file.getName() + "\"");  
		  
		  
		FileInputStream fileInputStream = new FileInputStream(file);               
		int i;   
		while ((i=fileInputStream.read()) != -1) {  
		out.write(i);   
		}   
		fileInputStream.close();   
		out.close();   
		  
		  
	
		}
}
	



