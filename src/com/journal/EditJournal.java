package com.journal;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.user.ConnectionFactory;
import com.user.userObjs;


/**
 * Servlet implementation class Edit
 */
@WebServlet("/EditJournal")
public class EditJournal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String savefile = "C:/Users/Harshit/Desktop/new";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditJournal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;

		PreparedStatement ps1 = null, ps = null, ps2 = null, ps3=null, ps4= null;

		try {

			String id1 = request.getSession(false).getAttribute("id").toString();//request.getParameter("authors_name");
			int id=Integer.valueOf(id1);
			String name = request.getSession(false).getAttribute("name").toString();
			
			conn = ConnectionFactory.getConnection();
			
			ps1 = conn.prepareStatement(
					"insert into journal(authors_name,dept,title_paper,journal,scope,year,publ_month,volume,issue,pages,doi,impact_factor,specify_if,link_if,pay,payment_done,pw,ps,pg,pi,journal_file,plag_report,username,revision) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps4 = conn.prepareStatement("insert into notify(notification,user_id) values(?,?)");
				//	"update journal set authors_name=?,dept=?,title_paper=?,journal=?,scope=?,year=?,"
					//		+ "publ_month=?,volume=?,issue=?,pages=?,impact_factor=?,specify_if=?,link_if=?,pay=?,payment_done=?,"
						//	+ "pw=?,ps=?,pg=?,pi=?,journal_file=?,plag_report=? where id=?");

			if (!conn.isClosed()) {
				System.out.println("CONNECTED");

				File f = null;
				int j = 21;

				List<String[]> formdata = new ArrayList<>();
				boolean ismultipart = ServletFileUpload.isMultipartContent(request);
				System.out.println(ismultipart);
				if (!ismultipart) {
					System.out.println("INSIDE MULP IF");
				} else {
					System.out.println("INSIDE MULP ELSE");
					FileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(factory);
					List<FileItem> items = upload.parseRequest(request);
					System.out.println(items);
					Iterator<FileItem> itr = items.iterator();
					while (itr.hasNext()) {
						FileItem item = (FileItem) itr.next();
						if (item.isFormField()) {

							String form_value_name = item.getFieldName();
							String form_value_value = item.getString();
							System.out.println("FORM DATA:" + form_value_name + " " + form_value_value);

							formdata.add(new String[] { form_value_name, form_value_value });


						} else {

							String itemname = item.getName(),file=null,repo=null;

							if ((itemname == null) || itemname.equals("")) {
								//continue;
								ResultSet rs1 = null;
								ps3 = conn.prepareStatement("select journal_file,plag_report from journal where id=?");
								ps3.setInt(1, id);
								rs1 = ps3.executeQuery();

								if (rs1.next()) {
									//rs1.previous();
									file = rs1.getString(1);
									repo = rs1.getString(2);
								}
								
								ps1.setString(21, file);
								ps1.setString(22, repo);
								
							}else{
								
								String filename = FilenameUtils.getName(itemname);
								f = checkExist(filename);

								item.write(f);

								if (j == 23) {
									break;
								}

								ps1.setString(j, f.getName());
								j++;
							}
							
							

						}
					}

				}

				
				int i = 1;
				System.out.println(ps1);
				System.out.println(formdata.size());
				for (String[] s : formdata) {

						ps1.setString(i, s[1]);
					

					i++;
					if (i == 21) {
						break;
					}

				}
				System.out.println(ps1);
				
				ResultSet rs = null;
				ps = conn.prepareStatement("select revision from journal where id=?");
				ps.setInt(1, id);
				rs = ps.executeQuery();

				int rev = 0;
				if (rs.next()) {
					rev = rs.getInt(1);
					System.out.println("Revision : " + rev);
				}

				ps2 = conn.prepareStatement("update journal set revision =? where id=?");
				ps2.setInt(1, (rev + 2));
				ps2.setInt(2, id);

				
				ps1.setString(23, name);
				ps1.setInt(24, (rev + 1));
				
				
				String n = userObjs.getName(name);
				ps4.setString(1, "Journal publication is edited by "+n+" for "+(rev+1)+" time/s");
	            ps4.setString(2, "admin");
				
				System.out.println(ps1);
				if(ps1.executeUpdate() > 0){
					ps4.executeUpdate();
					ps2.executeUpdate();
				}
				
				response.sendRedirect("user/publications.jsp");

			}
			try{
				request.getSession(false).removeAttribute("id");
			}catch(NullPointerException p){
				p.printStackTrace();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
