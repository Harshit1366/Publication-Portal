package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.ConnectionFactory;;

/**
 * Servlet implementation class reset_password
 */
@WebServlet("/reset_password")
public class reset_password extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public reset_password() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		Connection connection = null;

		String session = request.getParameter("sess");
		String npas = request.getParameter("np");
		String cpas = request.getParameter("cnp");

		String user=null;
		PrintWriter out = response.getWriter();

		try {
			if (!npas.equals(cpas)) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Passwords do not match.');");
				out.println("location='user/reset_password.jsp';");
				out.println("</script>");
				return;
			} else {
				connection = ConnectionFactory.getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("select username,session_id from forgot where session_id=?");
				stmt.setString(1, session);
				ResultSet rs=stmt.executeQuery();
				if(rs.next()) {
					user=rs.getString(1);
					PreparedStatement stmt1 = connection.prepareStatement("update login set password=? where username=?");
					stmt1.setString(1, npas);
					stmt1.setString(2, user);
					if (stmt1.executeUpdate() > 0) {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Password Changed.');");
						out.println("location='login.jsp';");
						out.println("</script>");
						return;
					} else {
						System.out.println("throwing...");
						throw new SQLException();
					}
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Reset link was closed earlier.');");
					out.println("location='login.jsp';");
					out.println("</script>");
					return;

				}
				
			}

		} catch (SQLException e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password cannot be changed.');");
			out.println("location='login.jsp';");
			out.println("</script>");
			System.out.println(e);
			return;
		} finally {
			if (null != connection) {
				ConnectionFactory.close(connection);
			}
			if (null != out) {
				out.close();
				out = null;
			}
		}

		//
		// try {
		//
		// if(!npas.equals(cpas)){
		//
		// out.println("<script type=\"text/javascript\">");
		// out.println("alert('Passwords do not match.');");
		// out.println("</script>");
		// out.close();
		// return;
		//
		// }
		//
		// connection = (Connection) ConnectionFactory.getConnection();
		//
		// PreparedStatement ps1 = connection.prepareStatement("update login set
		// password = ? where username=?");
		// ps1.setString(1, npas);
		// ps1.setString(2, user);
		// ps1.executeUpdate();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }finally {
		// ConnectionFactory.close(connection);
		// response.sendRedirect("login/login.jsp");
		// }
		//
	}

}
