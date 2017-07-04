package com.books;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.user.ConnectionFactory;

/**
 * Servlet implementation class uploadJournal
 */
@WebServlet("/uploadBooks")
public class uploadBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String savefile = "C:/Users/Harshit/Desktop/new";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public uploadBooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps1 = null;
		try {
			ps1 = conn.prepareStatement("insert into books(authors_name,dept,book_title,publisher,scope,year,month_pub,pages,isbn_no,hyperlink,pwsgte,link_index,book_file,plag_report,username) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File f = null;
		int j=13;
		PrintWriter out = response.getWriter();
		List<String[]> formdata = new ArrayList<>();
		try {
			boolean ismultipart = ServletFileUpload.isMultipartContent(request);
			if (!ismultipart) {

			} else {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = null;

				try {
					items = upload.parseRequest(request);
				} catch (Exception e) {

				}
				System.out.println(items);
				Iterator itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {
						
						String form_value_name = item.getFieldName();
						String form_value_value = item.getString();
						System.out.println("FORM DATA:" + form_value_name + " " + form_value_value);
						formdata.add(new String[]{form_value_name, form_value_value});
						
						int i=1;
						System.out.println(ps1);
						System.out.println(formdata.size());
						for(String[] s:formdata){
							//if(s[1].isEmpty()){
								//ps1.setNull(i, Types.VARCHAR);
							//}
							//else{
								ps1.setString(i, s[1]);
							//}
							
							i++;
							if(i==13){
								break;
							}
						}
						
					} else  {
						
						String itemname = item.getName();
						System.out.println(item);
						if ((itemname == null) || itemname.equals("")) {
							continue;
						}
						String filename = FilenameUtils.getName(itemname);
						f = checkExist(filename);
						System.out.println(f.getAbsolutePath());
						item.write(f);
							ps1.setString(j, f.getName());
							j++;
							
						
						
					}
				}

			}
		
			String name = null;
            HttpSession sess=request.getSession(false);  
            if(sess!=null){  
            name=(String)sess.getAttribute("name");  
            }
			
            ps1.setString(15, name);
			
		
		
			
			try{
				//System.out.println(ps1);
				System.out.println(ps1.executeUpdate());
				response.sendRedirect("user/select.jsp");
	
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
			catch (Exception e) {
			}
		
		

	}

	private File checkExist(String fileName) {

		File f = new File(savefile + "/" + fileName);
		if (f.exists()) {
			StringBuffer sb = new StringBuffer(fileName);
			sb.insert(sb.lastIndexOf("."), "-" + new Date().getTime());
			f = new File(savefile + "/" + sb.toString());
		}
		return f;

	}

}
