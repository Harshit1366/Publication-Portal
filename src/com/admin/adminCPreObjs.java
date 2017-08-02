package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.conf_presentations.conf_presentations;
import com.user.ConnectionFactory;

public class adminCPreObjs {
	
	
static Connection connection = null;
	

	public static List<conf_presentations> getAllC_Pre(){
		List<conf_presentations> list=new ArrayList<conf_presentations>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from conf_presentations");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				conf_presentations c=new conf_presentations();
				c.setId(rs.getInt(1));
				c.setPcn(rs.getString(2));
				c.setName(rs.getString(3));
				c.setDept(rs.getString(4));
				c.setTitle(rs.getString(5));
				c.setPresentation(rs.getString(6));
				c.setScope(rs.getString(7));
				c.setOrganiser(rs.getString(8));
				c.setVenue(rs.getString(9));
				c.setYear(rs.getInt(10));
				c.setMonth_pub(rs.getString(11));
				c.setMonth_pcn(rs.getString(12));
				c.setDates(rs.getString(13));
				c.setHyperlink(rs.getString(14));
				c.setPre_file(rs.getString(15));
				c.setPlag_report(rs.getString(16));
				c.setRevision(rs.getInt(17));
				c.setStatus(rs.getString(18));
				c.setUsername(rs.getString(19));
				c.setComment(rs.getString(20));
				list.add(c);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static List<conf_presentations> getC_PreById(String id){
		List<conf_presentations> list=new ArrayList<conf_presentations>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from conf_presentations where username=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				conf_presentations c=new conf_presentations();
				c.setId(rs.getInt(1));
				c.setPcn(rs.getString(2));
				c.setName(rs.getString(3));
				c.setDept(rs.getString(4));
				c.setTitle(rs.getString(5));
				c.setPresentation(rs.getString(6));
				c.setScope(rs.getString(7));
				c.setOrganiser(rs.getString(8));
				c.setVenue(rs.getString(9));
				c.setYear(rs.getInt(10));
				c.setMonth_pub(rs.getString(11));
				c.setMonth_pcn(rs.getString(12));
				c.setDates(rs.getString(13));
				c.setHyperlink(rs.getString(14));
				c.setPre_file(rs.getString(15));
				c.setPlag_report(rs.getString(16));
				c.setRevision(rs.getInt(17));
				c.setStatus(rs.getString(18));
				c.setUsername(rs.getString(19));
				c.setComment(rs.getString(20));
				list.add(c);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	
	public static List<conf_presentations> getC_PreSearch(String search){
		
		List<conf_presentations> list=new ArrayList<conf_presentations>();
		
				
				try{
					
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from conf_presentations where authors_name "
							+ "like ? or authors_name like ? or authors_name like ? or authors_name like ? or pcn like ? or pcn like ? "
							+ "or pcn like ? or pcn like ? ");
					p1.setString(1, search+"%");
					p1.setString(2, "%"+search+"%");
					p1.setString(3, "%"+search);
					p1.setString(4, search);
					p1.setString(5, search+"%");
					p1.setString(6, "%"+search+"%");
					p1.setString(7, "%"+search);
					p1.setString(8, search);
					ResultSet rs=p1.executeQuery();
					if(rs.next()){
						rs.previous();
					while(rs.next()){
						conf_presentations c=new conf_presentations();
						c.setId(rs.getInt(1));
						c.setPcn(rs.getString(2));
						c.setName(rs.getString(3));
						c.setDept(rs.getString(4));
						c.setTitle(rs.getString(5));
						c.setPresentation(rs.getString(6));
						c.setScope(rs.getString(7));
						c.setOrganiser(rs.getString(8));
						c.setVenue(rs.getString(9));
						c.setYear(rs.getInt(10));
						c.setMonth_pub(rs.getString(11));
						c.setMonth_pcn(rs.getString(12));
						c.setDates(rs.getString(13));
						c.setHyperlink(rs.getString(14));
						c.setPre_file(rs.getString(15));
						c.setPlag_report(rs.getString(16));
						c.setRevision(rs.getInt(17));
						c.setStatus(rs.getString(18));
						c.setUsername(rs.getString(19));
						c.setComment(rs.getString(20));
						list.add(c);
						}

					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}
	
	public static int AllCPre(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from conf_presentations");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	public static int AllNewCPre(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from conf_presentations where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 0);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	
	public static int AllRev1CPre(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from conf_presentations where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 1);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	
	public static int AllRev2CPre(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from conf_presentations where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 2);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	
	
	
	
public static List<conf_presentations> getNewC_Pre(){
		
	List<conf_presentations> list=new ArrayList<conf_presentations>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from conf_presentations where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 0);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				conf_presentations c=new conf_presentations();
				c.setId(rs.getInt(1));
				c.setPcn(rs.getString(2));
				c.setName(rs.getString(3));
				c.setDept(rs.getString(4));
				c.setTitle(rs.getString(5));
				c.setPresentation(rs.getString(6));
				c.setScope(rs.getString(7));
				c.setOrganiser(rs.getString(8));
				c.setVenue(rs.getString(9));
				c.setYear(rs.getInt(10));
				c.setMonth_pub(rs.getString(11));
				c.setMonth_pcn(rs.getString(12));
				c.setDates(rs.getString(13));
				c.setHyperlink(rs.getString(14));
				c.setPre_file(rs.getString(15));
				c.setPlag_report(rs.getString(16));
				c.setRevision(rs.getInt(17));
				c.setStatus(rs.getString(18));
				c.setUsername(rs.getString(19));
				c.setComment(rs.getString(20));
				list.add(c);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
public static List<conf_presentations> getNewC_PreSearch(String search){
	
	List<conf_presentations> list=new ArrayList<conf_presentations>();
				
				try{
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from conf_presentations where authors_name "
							+ "like ? or authors_name like ? or authors_name like ? or authors_name like ? or pcn like ? or pcn like ? "
							+ "or pcn like ? or pcn like ? and revision=? and pcn is ? and status is ?");
					p1.setString(1, search+"%");
					p1.setString(2, "%"+search+"%");
					p1.setString(3, "%"+search);
					p1.setString(4, search);
					p1.setString(5, search+"%");
					p1.setString(6, "%"+search+"%");
					p1.setString(7, "%"+search);
					p1.setString(8, search);
					p1.setInt(9, 0);
					p1.setNull(10, Types.VARCHAR);
					p1.setNull(11, Types.VARCHAR);
					ResultSet rs=p1.executeQuery();
					if(rs.next()){
						rs.previous();
					while(rs.next()){
						conf_presentations c=new conf_presentations();
						c.setId(rs.getInt(1));
						c.setPcn(rs.getString(2));
						c.setName(rs.getString(3));
						c.setDept(rs.getString(4));
						c.setTitle(rs.getString(5));
						c.setPresentation(rs.getString(6));
						c.setScope(rs.getString(7));
						c.setOrganiser(rs.getString(8));
						c.setVenue(rs.getString(9));
						c.setYear(rs.getInt(10));
						c.setMonth_pub(rs.getString(11));
						c.setMonth_pcn(rs.getString(12));
						c.setDates(rs.getString(13));
						c.setHyperlink(rs.getString(14));
						c.setPre_file(rs.getString(15));
						c.setPlag_report(rs.getString(16));
						c.setRevision(rs.getInt(17));
						c.setStatus(rs.getString(18));
						c.setUsername(rs.getString(19));
						c.setComment(rs.getString(20));
						list.add(c);
						}	
					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}


public static List<conf_presentations> getRev1C_Pre(){
	
	List<conf_presentations> list=new ArrayList<conf_presentations>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from conf_presentations where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 1);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			conf_presentations c=new conf_presentations();
			c.setId(rs.getInt(1));
			c.setPcn(rs.getString(2));
			c.setName(rs.getString(3));
			c.setDept(rs.getString(4));
			c.setTitle(rs.getString(5));
			c.setPresentation(rs.getString(6));
			c.setScope(rs.getString(7));
			c.setOrganiser(rs.getString(8));
			c.setVenue(rs.getString(9));
			c.setYear(rs.getInt(10));
			c.setMonth_pub(rs.getString(11));
			c.setMonth_pcn(rs.getString(12));
			c.setDates(rs.getString(13));
			c.setHyperlink(rs.getString(14));
			c.setPre_file(rs.getString(15));
			c.setPlag_report(rs.getString(16));
			c.setRevision(rs.getInt(17));
			c.setStatus(rs.getString(18));
			c.setUsername(rs.getString(19));
			c.setComment(rs.getString(20));
			list.add(c);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}

public static List<conf_presentations> getRev2C_Pre(){
	
	List<conf_presentations> list=new ArrayList<conf_presentations>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from conf_presentations where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 2);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			conf_presentations c=new conf_presentations();
			c.setId(rs.getInt(1));
			c.setPcn(rs.getString(2));
			c.setName(rs.getString(3));
			c.setDept(rs.getString(4));
			c.setTitle(rs.getString(5));
			c.setPresentation(rs.getString(6));
			c.setScope(rs.getString(7));
			c.setOrganiser(rs.getString(8));
			c.setVenue(rs.getString(9));
			c.setYear(rs.getInt(10));
			c.setMonth_pub(rs.getString(11));
			c.setMonth_pcn(rs.getString(12));
			c.setDates(rs.getString(13));
			c.setHyperlink(rs.getString(14));
			c.setPre_file(rs.getString(15));
			c.setPlag_report(rs.getString(16));
			c.setRevision(rs.getInt(17));
			c.setStatus(rs.getString(18));
			c.setUsername(rs.getString(19));
			c.setComment(rs.getString(20));
			list.add(c);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}



public static List<conf_presentations> getRev1C_PreSearch(String search){
	
	List<conf_presentations> list=new ArrayList<conf_presentations>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from conf_presentations where authors_name "
						+ "like ? or authors_name like ? or authors_name like ? or authors_name like ? or pcn like ? or pcn like ? "
						+ "or pcn like ? or pcn like ? and revision=? and pcn is ? and status is ?");
				p1.setString(1, search+"%");
				p1.setString(2, "%"+search+"%");
				p1.setString(3, "%"+search);
				p1.setString(4, search);
				p1.setString(5, search+"%");
				p1.setString(6, "%"+search+"%");
				p1.setString(7, "%"+search);
				p1.setString(8, search);
				p1.setInt(9, 1);
				p1.setNull(10, Types.VARCHAR);
				p1.setNull(11, Types.VARCHAR);
				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					conf_presentations c=new conf_presentations();
					c.setId(rs.getInt(1));
					c.setPcn(rs.getString(2));
					c.setName(rs.getString(3));
					c.setDept(rs.getString(4));
					c.setTitle(rs.getString(5));
					c.setPresentation(rs.getString(6));
					c.setScope(rs.getString(7));
					c.setOrganiser(rs.getString(8));
					c.setVenue(rs.getString(9));
					c.setYear(rs.getInt(10));
					c.setMonth_pub(rs.getString(11));
					c.setMonth_pcn(rs.getString(12));
					c.setDates(rs.getString(13));
					c.setHyperlink(rs.getString(14));
					c.setPre_file(rs.getString(15));
					c.setPlag_report(rs.getString(16));
					c.setRevision(rs.getInt(17));
					c.setStatus(rs.getString(18));
					c.setUsername(rs.getString(19));
					c.setComment(rs.getString(20));
					list.add(c);
					}
				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static List<conf_presentations> getRev2C_PreSearch(String search){
	
	List<conf_presentations> list=new ArrayList<conf_presentations>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from conf_presentations where authors_name "
						+ "like ? or authors_name like ? or authors_name like ? or authors_name like ? or pcn like ? or pcn like ? "
						+ "or pcn like ? or pcn like ? and revision=? and pcn is ? and status is ?");
				p1.setString(1, search+"%");
				p1.setString(2, "%"+search+"%");
				p1.setString(3, "%"+search);
				p1.setString(4, search);
				p1.setString(5, search+"%");
				p1.setString(6, "%"+search+"%");
				p1.setString(7, "%"+search);
				p1.setString(8, search);
				p1.setInt(9, 2);
				p1.setNull(10, Types.VARCHAR);
				p1.setNull(11, Types.VARCHAR);
				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					conf_presentations c=new conf_presentations();
					c.setId(rs.getInt(1));
					c.setPcn(rs.getString(2));
					c.setName(rs.getString(3));
					c.setDept(rs.getString(4));
					c.setTitle(rs.getString(5));
					c.setPresentation(rs.getString(6));
					c.setScope(rs.getString(7));
					c.setOrganiser(rs.getString(8));
					c.setVenue(rs.getString(9));
					c.setYear(rs.getInt(10));
					c.setMonth_pub(rs.getString(11));
					c.setMonth_pcn(rs.getString(12));
					c.setDates(rs.getString(13));
					c.setHyperlink(rs.getString(14));
					c.setPre_file(rs.getString(15));
					c.setPlag_report(rs.getString(16));
					c.setRevision(rs.getInt(17));
					c.setStatus(rs.getString(18));
					c.setUsername(rs.getString(19));
					c.setComment(rs.getString(20));
					list.add(c);
					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static conf_presentations getC_PreById(int id){
    if(id <= 0){
        return null;
    }
    conf_presentations c=new conf_presentations();

    ResultSet rs = null;
    try{
    	connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from conf_presentations where id=?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
        	
			c.setId(rs.getInt(1));
			c.setPcn(rs.getString(2));
			c.setName(rs.getString(3));
			c.setDept(rs.getString(4));
			c.setTitle(rs.getString(5));
			c.setPresentation(rs.getString(6));
			c.setScope(rs.getString(7));
			c.setOrganiser(rs.getString(8));
			c.setVenue(rs.getString(9));
			c.setYear(rs.getInt(10));
			c.setMonth_pub(rs.getString(11));
			c.setMonth_pcn(rs.getString(12));
			c.setDates(rs.getString(13));
			c.setHyperlink(rs.getString(14));
			c.setPre_file(rs.getString(15));
			c.setPlag_report(rs.getString(16));
			c.setRevision(rs.getInt(17));
			c.setStatus(rs.getString(18));
			c.setUsername(rs.getString(19));
			c.setComment(rs.getString(20));
			
            connection.close();
            return c;
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

	return c;
}


public static List<conf_presentations> getC_PreSearch2(String search){
	
	List<conf_presentations> list=new ArrayList<conf_presentations>();
	
			
			try{
				
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from conf_presentations where authors_name "
						+ "like ? or authors_name like ? or authors_name like ? or authors_name like ?");
				p1.setString(1, search+"%");
				p1.setString(2, "%"+search+"%");
				p1.setString(3, "%"+search);
				p1.setString(4, search);
				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					conf_presentations c=new conf_presentations();
					c.setId(rs.getInt(1));
					c.setPcn(rs.getString(2));
					c.setName(rs.getString(3));
					c.setDept(rs.getString(4));
					c.setTitle(rs.getString(5));
					c.setPresentation(rs.getString(6));
					c.setScope(rs.getString(7));
					c.setOrganiser(rs.getString(8));
					c.setVenue(rs.getString(9));
					c.setYear(rs.getInt(10));
					c.setMonth_pub(rs.getString(11));
					c.setMonth_pcn(rs.getString(12));
					c.setDates(rs.getString(13));
					c.setHyperlink(rs.getString(14));
					c.setPre_file(rs.getString(15));
					c.setPlag_report(rs.getString(16));
					c.setRevision(rs.getInt(17));
					c.setStatus(rs.getString(18));
					c.setUsername(rs.getString(19));
					c.setComment(rs.getString(20));
					list.add(c);
					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}



}
