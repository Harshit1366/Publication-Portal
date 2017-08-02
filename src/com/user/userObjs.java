package com.user;

import com.user.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class userObjs {
	
	public static String getComment(int id) {
	
	Connection connection = null;
	String comment = null;

		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("select comment from journal where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				comment = rs.getString(1);
				
			}
		} catch (Exception e) {

		}finally{
			ConnectionFactory.close(connection);
		}
		
		return comment;
	
	}
	
	
	public static String getName(String id) {
		Connection conn=null;
		String name=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select name from register where username=?");
			ps1.setString(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				name=rs.getString(1);
			}
			//return name;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		return name;
		
	}
	
	
	public static void setUUID(String id, String uuid) {
		Connection conn=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("update login set session_id = ? where username=?");
			ps1.setString(1, uuid);
			ps1.setString(2, id);
			ps1.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		
	}
	
	
	public static String getJUser(int id) {
		Connection conn=null;
		String user=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select username from journal where id=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				user=rs.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		return user;
	}
	
	
	public static String getBUser(int id) {
		Connection conn=null;
		String user=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select username from books where id=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				user=rs.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		return user;
	}
	
	public static String getBCUser(int id) {
		Connection conn=null;
		String user=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select username from book_chap where id=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				user=rs.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		return user;
	}
	
	public static String getCPOUser(int id) {
		Connection conn=null;
		String user=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select username from conf_proceedings where id=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				user=rs.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		return user;
	}
	
	public static String getCPEUser(int id) {
		Connection conn=null;
		String user=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select username from conf_presentations where id=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				user=rs.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		return user;
	}
	
	
	public static String getPUser(int id) {
		Connection conn=null;
		String user=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select username from patents where id=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				user=rs.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		return user;
	}
	
	public static String getTRUser(int id) {
		Connection conn=null;
		String user=null;
		try{
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select username from tech_report where id=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				user=rs.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
		}
		return user;
	}
	
	

	public static User getUserById(String id){
        if(id == null){
            return null;
        }
        User u= new User();

        Connection connection = null;
        ResultSet rs = null;
        try{
            connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement("select name,designation,email_id,"
            		+ "contact_no,dob from register where username=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	u.setName(rs.getString(1));
				u.setDesg(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setContact(rs.getLong(4));
				u.setDob(rs.getString(5));
			//	u.setUsername(rs.getString(6));
			//	u.setPassword(rs.getString(7));
                connection.close();
                return u;
                
            }
            else{
                return null;
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                rs.close();
                ConnectionFactory.close(connection);
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
	
	
    public static void deleteS_ID(String id) {
        Connection connection = null;
        PreparedStatement p1 = null;
        try {
            connection = ConnectionFactory.getConnection();
            p1 = connection.prepareStatement("update login set session_id=? where session_id=?");
            p1.setNull(1, Types.VARCHAR);
            p1.setString(2, id);
            if (p1.executeUpdate() == 1) {
            } else {
                System.out.println("You are not logged out!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(connection);
        }

    }
	
}
