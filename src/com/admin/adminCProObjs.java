
package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.conf_proceedings.conf_proceedings;

import com.user.ConnectionFactory;

public class adminCProObjs {
	
static Connection connection = null;
	

	public static List<conf_proceedings> getAllC_Pro(){
		List<conf_proceedings> list=new ArrayList<conf_proceedings>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from conf_proceedings");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				conf_proceedings c=new conf_proceedings();
				c.setId(rs.getInt(1));
				c.setPcn(rs.getString(2));
				c.setName(rs.getString(3));
				c.setDept(rs.getString(4));
				c.setTitle(rs.getString(5));
				c.setProceedings(rs.getString(6));
				c.setScope(rs.getString(7));
				c.setVenue(rs.getString(8));
				c.setYear(rs.getInt(9));
				c.setMonth_pub(rs.getString(10));
				c.setMonth_pcn(rs.getString(11));
				c.setDates(rs.getString(12));
				c.setPublishers(rs.getString(13));
				c.setPages(rs.getString(14));
				c.setHyperlink(rs.getString(15));
				c.setP_index(rs.getString(16));
				c.setLink_index(rs.getString(17));
				c.setPro_file(rs.getString(18));
				c.setPlag_report(rs.getString(19));
				c.setRevision(rs.getInt(20));
				c.setStatus(rs.getString(21));
				c.setUsername(rs.getString(22));
				c.setComment(rs.getString(23));
				list.add(c);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static List<conf_proceedings> getC_ProById(String id){
		List<conf_proceedings> list=new ArrayList<conf_proceedings>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from conf_proceedings where username=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				conf_proceedings c=new conf_proceedings();
				c.setId(rs.getInt(1));
				c.setPcn(rs.getString(2));
				c.setName(rs.getString(3));
				c.setDept(rs.getString(4));
				c.setTitle(rs.getString(5));
				c.setProceedings(rs.getString(6));
				c.setScope(rs.getString(7));
				c.setVenue(rs.getString(8));
				c.setYear(rs.getInt(9));
				c.setMonth_pub(rs.getString(10));
				c.setMonth_pcn(rs.getString(11));
				c.setDates(rs.getString(12));
				c.setPublishers(rs.getString(13));
				c.setPages(rs.getString(14));
				c.setHyperlink(rs.getString(15));
				c.setP_index(rs.getString(16));
				c.setLink_index(rs.getString(17));
				c.setPro_file(rs.getString(18));
				c.setPlag_report(rs.getString(19));
				c.setRevision(rs.getInt(20));
				c.setStatus(rs.getString(21));
				c.setUsername(rs.getString(22));
				c.setComment(rs.getString(23));
				list.add(c);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static int AllCPro(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from conf_proceedings");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	public static int AllNewCPro(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from conf_proceedings where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev1CPro(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from conf_proceedings where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev2CPro(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from conf_proceedings where revision=? and pcn is ? and status is ?");
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
	
	
	
	
	public static List<conf_proceedings> getC_ProSearch(String search){
		
		List<conf_proceedings> list=new ArrayList<conf_proceedings>();
				
				try{
					
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from conf_proceedings where authors_name "
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
						conf_proceedings c=new conf_proceedings();
						c.setId(rs.getInt(1));
						c.setPcn(rs.getString(2));
						c.setName(rs.getString(3));
						c.setDept(rs.getString(4));
						c.setTitle(rs.getString(5));
						c.setProceedings(rs.getString(6));
						c.setScope(rs.getString(7));
						c.setVenue(rs.getString(8));
						c.setYear(rs.getInt(9));
						c.setMonth_pub(rs.getString(10));
						c.setMonth_pcn(rs.getString(11));
						c.setDates(rs.getString(12));
						c.setPublishers(rs.getString(13));
						c.setPages(rs.getString(14));
						c.setHyperlink(rs.getString(15));
						c.setP_index(rs.getString(16));
						c.setLink_index(rs.getString(17));
						c.setPro_file(rs.getString(18));
						c.setPlag_report(rs.getString(19));
						c.setRevision(rs.getInt(20));
						c.setStatus(rs.getString(21));
						c.setUsername(rs.getString(22));
						c.setComment(rs.getString(23));
						list.add(c);
						}

					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}
	
public static List<conf_proceedings> getNewC_Pro(){
		
	List<conf_proceedings> list=new ArrayList<conf_proceedings>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from conf_proceedings where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 0);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				conf_proceedings c=new conf_proceedings();
				c.setId(rs.getInt(1));
				c.setPcn(rs.getString(2));
				c.setName(rs.getString(3));
				c.setDept(rs.getString(4));
				c.setTitle(rs.getString(5));
				c.setProceedings(rs.getString(6));
				c.setScope(rs.getString(7));
				c.setVenue(rs.getString(8));
				c.setYear(rs.getInt(9));
				c.setMonth_pub(rs.getString(10));
				c.setMonth_pcn(rs.getString(11));
				c.setDates(rs.getString(12));
				c.setPublishers(rs.getString(13));
				c.setPages(rs.getString(14));
				c.setHyperlink(rs.getString(15));
				c.setP_index(rs.getString(16));
				c.setLink_index(rs.getString(17));
				c.setPro_file(rs.getString(18));
				c.setPlag_report(rs.getString(19));
				c.setRevision(rs.getInt(20));
				c.setStatus(rs.getString(21));
				c.setUsername(rs.getString(22));
				c.setComment(rs.getString(23));
				list.add(c);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
public static List<conf_proceedings> getNewC_ProSearch(String search){
	
	List<conf_proceedings> list=new ArrayList<conf_proceedings>();
				
				try{
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from conf_proceedings where authors_name "
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
						conf_proceedings c=new conf_proceedings();
						c.setId(rs.getInt(1));
						c.setPcn(rs.getString(2));
						c.setName(rs.getString(3));
						c.setDept(rs.getString(4));
						c.setTitle(rs.getString(5));
						c.setProceedings(rs.getString(6));
						c.setScope(rs.getString(7));
						c.setVenue(rs.getString(8));
						c.setYear(rs.getInt(9));
						c.setMonth_pub(rs.getString(10));
						c.setMonth_pcn(rs.getString(11));
						c.setDates(rs.getString(12));
						c.setPublishers(rs.getString(13));
						c.setPages(rs.getString(14));
						c.setHyperlink(rs.getString(15));
						c.setP_index(rs.getString(16));
						c.setLink_index(rs.getString(17));
						c.setPro_file(rs.getString(18));
						c.setPlag_report(rs.getString(19));
						c.setRevision(rs.getInt(20));
						c.setStatus(rs.getString(21));
						c.setUsername(rs.getString(22));
						c.setComment(rs.getString(23));
						list.add(c);
						}	
					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}


public static List<conf_proceedings> getRev1C_Pro(){
	
	List<conf_proceedings> list=new ArrayList<conf_proceedings>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from conf_proceedings where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 1);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			conf_proceedings c=new conf_proceedings();
			c.setId(rs.getInt(1));
			c.setPcn(rs.getString(2));
			c.setName(rs.getString(3));
			c.setDept(rs.getString(4));
			c.setTitle(rs.getString(5));
			c.setProceedings(rs.getString(6));
			c.setScope(rs.getString(7));
			c.setVenue(rs.getString(8));
			c.setYear(rs.getInt(9));
			c.setMonth_pub(rs.getString(10));
			c.setMonth_pcn(rs.getString(11));
			c.setDates(rs.getString(12));
			c.setPublishers(rs.getString(13));
			c.setPages(rs.getString(14));
			c.setHyperlink(rs.getString(15));
			c.setP_index(rs.getString(16));
			c.setLink_index(rs.getString(17));
			c.setPro_file(rs.getString(18));
			c.setPlag_report(rs.getString(19));
			c.setRevision(rs.getInt(20));
			c.setStatus(rs.getString(21));
			c.setUsername(rs.getString(22));
			c.setComment(rs.getString(23));
			list.add(c);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}

public static List<conf_proceedings> getRev2C_Pro(){
	
	List<conf_proceedings> list=new ArrayList<conf_proceedings>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from conf_proceedings where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 2);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			conf_proceedings c=new conf_proceedings();
			c.setId(rs.getInt(1));
			c.setPcn(rs.getString(2));
			c.setName(rs.getString(3));
			c.setDept(rs.getString(4));
			c.setTitle(rs.getString(5));
			c.setProceedings(rs.getString(6));
			c.setScope(rs.getString(7));
			c.setVenue(rs.getString(8));
			c.setYear(rs.getInt(9));
			c.setMonth_pub(rs.getString(10));
			c.setMonth_pcn(rs.getString(11));
			c.setDates(rs.getString(12));
			c.setPublishers(rs.getString(13));
			c.setPages(rs.getString(14));
			c.setHyperlink(rs.getString(15));
			c.setP_index(rs.getString(16));
			c.setLink_index(rs.getString(17));
			c.setPro_file(rs.getString(18));
			c.setPlag_report(rs.getString(19));
			c.setRevision(rs.getInt(20));
			c.setStatus(rs.getString(21));
			c.setUsername(rs.getString(22));
			c.setComment(rs.getString(23));
			list.add(c);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}



public static List<conf_proceedings> getRev1C_ProSearch(String search){
	
	List<conf_proceedings> list=new ArrayList<conf_proceedings>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from conf_proceedings where authors_name "
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
					conf_proceedings c=new conf_proceedings();
					c.setId(rs.getInt(1));
					c.setPcn(rs.getString(2));
					c.setName(rs.getString(3));
					c.setDept(rs.getString(4));
					c.setTitle(rs.getString(5));
					c.setProceedings(rs.getString(6));
					c.setScope(rs.getString(7));
					c.setVenue(rs.getString(8));
					c.setYear(rs.getInt(9));
					c.setMonth_pub(rs.getString(10));
					c.setMonth_pcn(rs.getString(11));
					c.setDates(rs.getString(12));
					c.setPublishers(rs.getString(13));
					c.setPages(rs.getString(14));
					c.setHyperlink(rs.getString(15));
					c.setP_index(rs.getString(16));
					c.setLink_index(rs.getString(17));
					c.setPro_file(rs.getString(18));
					c.setPlag_report(rs.getString(19));
					c.setRevision(rs.getInt(20));
					c.setStatus(rs.getString(21));
					c.setUsername(rs.getString(22));
					c.setComment(rs.getString(23));
					list.add(c);
					}
				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static List<conf_proceedings> getRev2C_ProSearch(String search){
	
	List<conf_proceedings> list=new ArrayList<conf_proceedings>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from conf_proceedings where authors_name "
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
					conf_proceedings c=new conf_proceedings();
					c.setId(rs.getInt(1));
					c.setPcn(rs.getString(2));
					c.setName(rs.getString(3));
					c.setDept(rs.getString(4));
					c.setTitle(rs.getString(5));
					c.setProceedings(rs.getString(6));
					c.setScope(rs.getString(7));
					c.setVenue(rs.getString(8));
					c.setYear(rs.getInt(9));
					c.setMonth_pub(rs.getString(10));
					c.setMonth_pcn(rs.getString(11));
					c.setDates(rs.getString(12));
					c.setPublishers(rs.getString(13));
					c.setPages(rs.getString(14));
					c.setHyperlink(rs.getString(15));
					c.setP_index(rs.getString(16));
					c.setLink_index(rs.getString(17));
					c.setPro_file(rs.getString(18));
					c.setPlag_report(rs.getString(19));
					c.setRevision(rs.getInt(20));
					c.setStatus(rs.getString(21));
					c.setUsername(rs.getString(22));
					c.setComment(rs.getString(23));
					list.add(c);					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static conf_proceedings getUserById(int id){
    if(id <= 0){
        return null;
    }
    conf_proceedings c=new conf_proceedings();

    ResultSet rs = null;
    try{
    	connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from conf_proceedings where id=?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
        	//Book_chapter bc=new Book_chapter();
        	//conf_proceedings c=new conf_proceedings();
			c.setId(rs.getInt(1));
			c.setPcn(rs.getString(2));
			c.setName(rs.getString(3));
			c.setDept(rs.getString(4));
			c.setTitle(rs.getString(5));
			c.setProceedings(rs.getString(6));
			c.setScope(rs.getString(7));
			c.setVenue(rs.getString(8));
			c.setYear(rs.getInt(9));
			c.setMonth_pub(rs.getString(10));
			c.setMonth_pcn(rs.getString(11));
			c.setDates(rs.getString(12));
			c.setPublishers(rs.getString(13));
			c.setPages(rs.getString(14));
			c.setHyperlink(rs.getString(15));
			c.setP_index(rs.getString(16));
			c.setLink_index(rs.getString(17));
			c.setPro_file(rs.getString(18));
			c.setPlag_report(rs.getString(19));
			c.setRevision(rs.getInt(20));
			c.setStatus(rs.getString(21));
			c.setUsername(rs.getString(22));
			c.setComment(rs.getString(23));
			
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



public static List<conf_proceedings> getSearch2(String search){
	
	List<conf_proceedings> list=new ArrayList<conf_proceedings>();
	PreparedStatement p1=null;
			
			try{
				connection = ConnectionFactory.getConnection();
				if(search.equals("p")){
					p1 = connection.prepareStatement("select * from conf_proceedings where pwsgte = ?");
				}
				
				p1.setString(1, "Yes");
				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					conf_proceedings c=new conf_proceedings();
					c.setId(rs.getInt(1));
					c.setPcn(rs.getString(2));
					c.setName(rs.getString(3));
					c.setDept(rs.getString(4));
					c.setTitle(rs.getString(5));
					c.setProceedings(rs.getString(6));
					c.setScope(rs.getString(7));
					c.setVenue(rs.getString(8));
					c.setYear(rs.getInt(9));
					c.setMonth_pub(rs.getString(10));
					c.setMonth_pcn(rs.getString(11));
					c.setDates(rs.getString(12));
					c.setPublishers(rs.getString(13));
					c.setPages(rs.getString(14));
					c.setHyperlink(rs.getString(15));
					c.setP_index(rs.getString(16));
					c.setLink_index(rs.getString(17));
					c.setPro_file(rs.getString(18));
					c.setPlag_report(rs.getString(19));
					c.setRevision(rs.getInt(20));
					c.setStatus(rs.getString(21));
					c.setUsername(rs.getString(22));
					c.setComment(rs.getString(23));
					list.add(c);		
					}	
				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}

public static List<conf_proceedings> getC_ProSearch2(String search){
	
	List<conf_proceedings> list=new ArrayList<conf_proceedings>();
			
			try{
				
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from conf_proceedings where authors_name "
						+ "like ? or authors_name like ? or authors_name like ? or authors_name like ?");
				p1.setString(1, search+"%");
				p1.setString(2, "%"+search+"%");
				p1.setString(3, "%"+search);
				p1.setString(4, search);

				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					conf_proceedings c=new conf_proceedings();
					c.setId(rs.getInt(1));
					c.setPcn(rs.getString(2));
					c.setName(rs.getString(3));
					c.setDept(rs.getString(4));
					c.setTitle(rs.getString(5));
					c.setProceedings(rs.getString(6));
					c.setScope(rs.getString(7));
					c.setVenue(rs.getString(8));
					c.setYear(rs.getInt(9));
					c.setMonth_pub(rs.getString(10));
					c.setMonth_pcn(rs.getString(11));
					c.setDates(rs.getString(12));
					c.setPublishers(rs.getString(13));
					c.setPages(rs.getString(14));
					c.setHyperlink(rs.getString(15));
					c.setP_index(rs.getString(16));
					c.setLink_index(rs.getString(17));
					c.setPro_file(rs.getString(18));
					c.setPlag_report(rs.getString(19));
					c.setRevision(rs.getInt(20));
					c.setStatus(rs.getString(21));
					c.setUsername(rs.getString(22));
					c.setComment(rs.getString(23));
					list.add(c);
					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}



}
