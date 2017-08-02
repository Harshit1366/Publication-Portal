package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.tech_reports.tech_reports;
import com.user.ConnectionFactory;

public class adminTRObjs {
	
static Connection connection = null;
	

	public static List<tech_reports> getAllTech(){
		List<tech_reports> list=new ArrayList<tech_reports>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from tech_report");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				tech_reports t=new tech_reports();
				t.setId(rs.getInt(1));
				t.setPcn(rs.getString(2));
				t.setName(rs.getString(3));
				t.setDept(rs.getString(4));
				t.setTitle(rs.getString(5));
				t.setYear(rs.getInt(6));
				t.setMonth_pub(rs.getString(7));
				t.setMonth_pcn(rs.getString(8));
				t.setDate(rs.getString(9));
				t.setRemarks(rs.getString(10));
				t.setTech_report(rs.getString(11));
				t.setPlag_report(rs.getString(12));
				t.setRevision(rs.getInt(13));
				t.setStatus(rs.getString(14));
				t.setUsername(rs.getString(15));
				t.setComment(rs.getString(16));
				list.add(t);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static List<tech_reports> getTechById(String id){
		List<tech_reports> list=new ArrayList<tech_reports>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from tech_report where username=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				tech_reports t=new tech_reports();
				t.setId(rs.getInt(1));
				t.setPcn(rs.getString(2));
				t.setName(rs.getString(3));
				t.setDept(rs.getString(4));
				t.setTitle(rs.getString(5));
				t.setYear(rs.getInt(6));
				t.setMonth_pub(rs.getString(7));
				t.setMonth_pcn(rs.getString(8));
				t.setDate(rs.getString(9));
				t.setRemarks(rs.getString(10));
				t.setTech_report(rs.getString(11));
				t.setPlag_report(rs.getString(12));
				t.setRevision(rs.getInt(13));
				t.setStatus(rs.getString(14));
				t.setUsername(rs.getString(15));
				t.setComment(rs.getString(16));
				list.add(t);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	
	public static List<tech_reports> getTechSearch(String search){
		
		List<tech_reports> list=new ArrayList<tech_reports>();
				
				try{
					
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from tech_report where authors_name "
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
						tech_reports t=new tech_reports();
						t.setId(rs.getInt(1));
						t.setPcn(rs.getString(2));
						t.setName(rs.getString(3));
						t.setDept(rs.getString(4));
						t.setTitle(rs.getString(5));
						t.setYear(rs.getInt(6));
						t.setMonth_pub(rs.getString(7));
						t.setMonth_pcn(rs.getString(8));
						t.setDate(rs.getString(9));
						t.setRemarks(rs.getString(10));
						t.setTech_report(rs.getString(11));
						t.setPlag_report(rs.getString(12));
						t.setRevision(rs.getInt(13));
						t.setStatus(rs.getString(14));
						t.setUsername(rs.getString(15));
						t.setComment(rs.getString(16));
						list.add(t);
						}

					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}
	
	
	public static int AllTR(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from tech_report");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	public static int AllNewTR(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from tech_report where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev1TR(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from tech_report where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev2TR(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from tech_report where revision=? and pcn is ? and status is ?");
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
	
	
	
	
public static List<tech_reports> getNewTech(){
		
	List<tech_reports> list=new ArrayList<tech_reports>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from tech_report where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 0);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				tech_reports t=new tech_reports();
				t.setId(rs.getInt(1));
				t.setPcn(rs.getString(2));
				t.setName(rs.getString(3));
				t.setDept(rs.getString(4));
				t.setTitle(rs.getString(5));
				t.setYear(rs.getInt(6));
				t.setMonth_pub(rs.getString(7));
				t.setMonth_pcn(rs.getString(8));
				t.setDate(rs.getString(9));
				t.setRemarks(rs.getString(10));
				t.setTech_report(rs.getString(11));
				t.setPlag_report(rs.getString(12));
				t.setRevision(rs.getInt(13));
				t.setStatus(rs.getString(14));
				t.setUsername(rs.getString(15));
				t.setComment(rs.getString(16));
				list.add(t);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
public static List<tech_reports> getNewTechSearch(String search){
	
	List<tech_reports> list=new ArrayList<tech_reports>();
				
				try{
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from tech_report where authors_name "
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
						tech_reports t=new tech_reports();
						t.setId(rs.getInt(1));
						t.setPcn(rs.getString(2));
						t.setName(rs.getString(3));
						t.setDept(rs.getString(4));
						t.setTitle(rs.getString(5));
						t.setYear(rs.getInt(6));
						t.setMonth_pub(rs.getString(7));
						t.setMonth_pcn(rs.getString(8));
						t.setDate(rs.getString(9));
						t.setRemarks(rs.getString(10));
						t.setTech_report(rs.getString(11));
						t.setPlag_report(rs.getString(12));
						t.setRevision(rs.getInt(13));
						t.setStatus(rs.getString(14));
						t.setUsername(rs.getString(15));
						t.setComment(rs.getString(16));
						list.add(t);
						}	
					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}


public static List<tech_reports> getRev1Tech(){
	
	List<tech_reports> list=new ArrayList<tech_reports>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from tech_report where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 1);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			tech_reports t=new tech_reports();
			t.setId(rs.getInt(1));
			t.setPcn(rs.getString(2));
			t.setName(rs.getString(3));
			t.setDept(rs.getString(4));
			t.setTitle(rs.getString(5));
			t.setYear(rs.getInt(6));
			t.setMonth_pub(rs.getString(7));
			t.setMonth_pcn(rs.getString(8));
			t.setDate(rs.getString(9));
			t.setRemarks(rs.getString(10));
			t.setTech_report(rs.getString(11));
			t.setPlag_report(rs.getString(12));
			t.setRevision(rs.getInt(13));
			t.setStatus(rs.getString(14));
			t.setUsername(rs.getString(15));
			t.setComment(rs.getString(16));
			list.add(t);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}

public static List<tech_reports> getRev2Tech(){
	
	List<tech_reports> list=new ArrayList<tech_reports>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from tech_report where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 2);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			tech_reports t=new tech_reports();
			t.setId(rs.getInt(1));
			t.setPcn(rs.getString(2));
			t.setName(rs.getString(3));
			t.setDept(rs.getString(4));
			t.setTitle(rs.getString(5));
			t.setYear(rs.getInt(6));
			t.setMonth_pub(rs.getString(7));
			t.setMonth_pcn(rs.getString(8));
			t.setDate(rs.getString(9));
			t.setRemarks(rs.getString(10));
			t.setTech_report(rs.getString(11));
			t.setPlag_report(rs.getString(12));
			t.setRevision(rs.getInt(13));
			t.setStatus(rs.getString(14));
			t.setUsername(rs.getString(15));
			t.setComment(rs.getString(16));
			list.add(t);		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}



public static List<tech_reports> getRev1TechSearch(String search){
	
	List<tech_reports> list=new ArrayList<tech_reports>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from tech_report where authors_name "
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
					tech_reports t=new tech_reports();
					t.setId(rs.getInt(1));
					t.setPcn(rs.getString(2));
					t.setName(rs.getString(3));
					t.setDept(rs.getString(4));
					t.setTitle(rs.getString(5));
					t.setYear(rs.getInt(6));
					t.setMonth_pub(rs.getString(7));
					t.setMonth_pcn(rs.getString(8));
					t.setDate(rs.getString(9));
					t.setRemarks(rs.getString(10));
					t.setTech_report(rs.getString(11));
					t.setPlag_report(rs.getString(12));
					t.setRevision(rs.getInt(13));
					t.setStatus(rs.getString(14));
					t.setUsername(rs.getString(15));
					t.setComment(rs.getString(16));
					list.add(t);
					}
				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static List<tech_reports> getRev2TechSearch(String search){
	
	List<tech_reports> list=new ArrayList<tech_reports>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from tech_report where authors_name "
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
					tech_reports t=new tech_reports();
					t.setId(rs.getInt(1));
					t.setPcn(rs.getString(2));
					t.setName(rs.getString(3));
					t.setDept(rs.getString(4));
					t.setTitle(rs.getString(5));
					t.setYear(rs.getInt(6));
					t.setMonth_pub(rs.getString(7));
					t.setMonth_pcn(rs.getString(8));
					t.setDate(rs.getString(9));
					t.setRemarks(rs.getString(10));
					t.setTech_report(rs.getString(11));
					t.setPlag_report(rs.getString(12));
					t.setRevision(rs.getInt(13));
					t.setStatus(rs.getString(14));
					t.setUsername(rs.getString(15));
					t.setComment(rs.getString(16));
					list.add(t);
					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static tech_reports getTechById(int id){
    if(id <= 0){
        return null;
    }
    tech_reports t=new tech_reports();

    ResultSet rs = null;
    try{
    	connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from tech_report where id=?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
        	
			t.setId(rs.getInt(1));
			t.setPcn(rs.getString(2));
			t.setName(rs.getString(3));
			t.setDept(rs.getString(4));
			t.setTitle(rs.getString(5));
			t.setYear(rs.getInt(6));
			t.setMonth_pub(rs.getString(7));
			t.setMonth_pcn(rs.getString(8));
			t.setDate(rs.getString(9));
			t.setRemarks(rs.getString(10));
			t.setTech_report(rs.getString(11));
			t.setPlag_report(rs.getString(12));
			t.setRevision(rs.getInt(13));
			t.setStatus(rs.getString(14));
			t.setUsername(rs.getString(15));
			t.setComment(rs.getString(16));
			
            connection.close();
            return t;
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

	return t;
}


public static List<tech_reports> getTechSearch2(String search){
	
	List<tech_reports> list=new ArrayList<tech_reports>();
			
			try{
				
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from tech_report where authors_name "
						+ "like ? or authors_name like ? or authors_name like ? or authors_name like ?");
				p1.setString(1, search+"%");
				p1.setString(2, "%"+search+"%");
				p1.setString(3, "%"+search);
				p1.setString(4, search);
				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					tech_reports t=new tech_reports();
					t.setId(rs.getInt(1));
					t.setPcn(rs.getString(2));
					t.setName(rs.getString(3));
					t.setDept(rs.getString(4));
					t.setTitle(rs.getString(5));
					t.setYear(rs.getInt(6));
					t.setMonth_pub(rs.getString(7));
					t.setMonth_pcn(rs.getString(8));
					t.setDate(rs.getString(9));
					t.setRemarks(rs.getString(10));
					t.setTech_report(rs.getString(11));
					t.setPlag_report(rs.getString(12));
					t.setRevision(rs.getInt(13));
					t.setStatus(rs.getString(14));
					t.setUsername(rs.getString(15));
					t.setComment(rs.getString(16));
					list.add(t);
					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}



}
