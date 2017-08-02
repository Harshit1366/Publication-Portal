package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.patents.Patents;
import com.user.ConnectionFactory;

public class adminPObjs {

static Connection connection = null;
	

	public static List<Patents> getAllPatents(){
		List<Patents> list=new ArrayList<Patents>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from patents");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Patents p=new Patents();
				p.setId(rs.getInt(1));
				p.setPcn(rs.getString(2));
				p.setName(rs.getString(3));
				p.setDept(rs.getString(4));
				p.setTitle(rs.getString(5));
				p.setScope(rs.getString(6));
				p.setCountry(rs.getString(7));
				p.setApplication_no(rs.getString(8));
				p.setApplication_year(rs.getInt(9));
				p.setApplication_date(rs.getString(10));
				p.setAward_year(rs.getInt(11));
				p.setAward_date(rs.getString(12));
				p.setPatent_no(rs.getString(13));
				p.setPatent_file(rs.getString(14));
				p.setPlag_report(rs.getString(15));
				p.setRevision(rs.getInt(16));
				p.setStatus(rs.getString(17));
				p.setUsername(rs.getString(18));
				p.setComment(rs.getString(19));
				list.add(p);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static List<Patents> getPatentById(String id){
		List<Patents> list=new ArrayList<Patents>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from patents where username=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Patents p=new Patents();
				p.setId(rs.getInt(1));
				p.setPcn(rs.getString(2));
				p.setName(rs.getString(3));
				p.setDept(rs.getString(4));
				p.setTitle(rs.getString(5));
				p.setScope(rs.getString(6));
				p.setCountry(rs.getString(7));
				p.setApplication_no(rs.getString(8));
				p.setApplication_year(rs.getInt(9));
				p.setApplication_date(rs.getString(10));
				p.setAward_year(rs.getInt(11));
				p.setAward_date(rs.getString(12));
				p.setPatent_no(rs.getString(13));
				p.setPatent_file(rs.getString(14));
				p.setPlag_report(rs.getString(15));
				p.setRevision(rs.getInt(16));
				p.setStatus(rs.getString(17));
				p.setUsername(rs.getString(18));
				p.setComment(rs.getString(19));
				list.add(p);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	
	public static List<Patents> getPatentSearch(String search){
		
		List<Patents> list=new ArrayList<Patents>();
				
				try{
					
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from patents where authors_name "
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
						Patents p=new Patents();
						p.setId(rs.getInt(1));
						p.setPcn(rs.getString(2));
						p.setName(rs.getString(3));
						p.setDept(rs.getString(4));
						p.setTitle(rs.getString(5));
						p.setScope(rs.getString(6));
						p.setCountry(rs.getString(7));
						p.setApplication_no(rs.getString(8));
						p.setApplication_year(rs.getInt(9));
						p.setApplication_date(rs.getString(10));
						p.setAward_year(rs.getInt(11));
						p.setAward_date(rs.getString(12));
						p.setPatent_no(rs.getString(13));
						p.setPatent_file(rs.getString(14));
						p.setPlag_report(rs.getString(15));
						p.setRevision(rs.getInt(16));
						p.setStatus(rs.getString(17));
						p.setUsername(rs.getString(18));
						p.setComment(rs.getString(19));
						list.add(p);
						}

					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}
	
	
	public static int AllP(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from patents");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	public static int AllNewP(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from patents where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev1P(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from patents where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev2P(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from patents where revision=? and pcn is ? and status is ?");
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
	
	
public static List<Patents> getNewPatent(){
		
	List<Patents> list=new ArrayList<Patents>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from patents where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 0);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Patents p=new Patents();
				p.setId(rs.getInt(1));
				p.setPcn(rs.getString(2));
				p.setName(rs.getString(3));
				p.setDept(rs.getString(4));
				p.setTitle(rs.getString(5));
				p.setScope(rs.getString(6));
				p.setCountry(rs.getString(7));
				p.setApplication_no(rs.getString(8));
				p.setApplication_year(rs.getInt(9));
				p.setApplication_date(rs.getString(10));
				p.setAward_year(rs.getInt(11));
				p.setAward_date(rs.getString(12));
				p.setPatent_no(rs.getString(13));
				p.setPatent_file(rs.getString(14));
				p.setPlag_report(rs.getString(15));
				p.setRevision(rs.getInt(16));
				p.setStatus(rs.getString(17));
				p.setUsername(rs.getString(18));
				p.setComment(rs.getString(19));
				list.add(p);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
public static List<Patents> getNewPatentSearch(String search){
	
	List<Patents> list=new ArrayList<Patents>();
				
				try{
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from patents where authors_name "
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
						Patents p=new Patents();
						p.setId(rs.getInt(1));
						p.setPcn(rs.getString(2));
						p.setName(rs.getString(3));
						p.setDept(rs.getString(4));
						p.setTitle(rs.getString(5));
						p.setScope(rs.getString(6));
						p.setCountry(rs.getString(7));
						p.setApplication_no(rs.getString(8));
						p.setApplication_year(rs.getInt(9));
						p.setApplication_date(rs.getString(10));
						p.setAward_year(rs.getInt(11));
						p.setAward_date(rs.getString(12));
						p.setPatent_no(rs.getString(13));
						p.setPatent_file(rs.getString(14));
						p.setPlag_report(rs.getString(15));
						p.setRevision(rs.getInt(16));
						p.setStatus(rs.getString(17));
						p.setUsername(rs.getString(18));
						p.setComment(rs.getString(19));
						list.add(p);
					}}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}


public static List<Patents> getRev1Patent(){
	
	List<Patents> list=new ArrayList<Patents>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from patents where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 1);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Patents p=new Patents();
			p.setId(rs.getInt(1));
			p.setPcn(rs.getString(2));
			p.setName(rs.getString(3));
			p.setDept(rs.getString(4));
			p.setTitle(rs.getString(5));
			p.setScope(rs.getString(6));
			p.setCountry(rs.getString(7));
			p.setApplication_no(rs.getString(8));
			p.setApplication_year(rs.getInt(9));
			p.setApplication_date(rs.getString(10));
			p.setAward_year(rs.getInt(11));
			p.setAward_date(rs.getString(12));
			p.setPatent_no(rs.getString(13));
			p.setPatent_file(rs.getString(14));
			p.setPlag_report(rs.getString(15));
			p.setRevision(rs.getInt(16));
			p.setStatus(rs.getString(17));
			p.setUsername(rs.getString(18));
			p.setComment(rs.getString(19));
			list.add(p);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}

public static List<Patents> getRev2Patent(){
	
	List<Patents> list=new ArrayList<Patents>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from patents where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 2);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Patents p=new Patents();
			p.setId(rs.getInt(1));
			p.setPcn(rs.getString(2));
			p.setName(rs.getString(3));
			p.setDept(rs.getString(4));
			p.setTitle(rs.getString(5));
			p.setScope(rs.getString(6));
			p.setCountry(rs.getString(7));
			p.setApplication_no(rs.getString(8));
			p.setApplication_year(rs.getInt(9));
			p.setApplication_date(rs.getString(10));
			p.setAward_year(rs.getInt(11));
			p.setAward_date(rs.getString(12));
			p.setPatent_no(rs.getString(13));
			p.setPatent_file(rs.getString(14));
			p.setPlag_report(rs.getString(15));
			p.setRevision(rs.getInt(16));
			p.setStatus(rs.getString(17));
			p.setUsername(rs.getString(18));
			p.setComment(rs.getString(19));
			list.add(p);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}



public static List<Patents> getRev1PatentSearch(String search){
	
	List<Patents> list=new ArrayList<Patents>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from patents where authors_name "
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
					Patents p=new Patents();
					p.setId(rs.getInt(1));
					p.setPcn(rs.getString(2));
					p.setName(rs.getString(3));
					p.setDept(rs.getString(4));
					p.setTitle(rs.getString(5));
					p.setScope(rs.getString(6));
					p.setCountry(rs.getString(7));
					p.setApplication_no(rs.getString(8));
					p.setApplication_year(rs.getInt(9));
					p.setApplication_date(rs.getString(10));
					p.setAward_year(rs.getInt(11));
					p.setAward_date(rs.getString(12));
					p.setPatent_no(rs.getString(13));
					p.setPatent_file(rs.getString(14));
					p.setPlag_report(rs.getString(15));
					p.setRevision(rs.getInt(16));
					p.setStatus(rs.getString(17));
					p.setUsername(rs.getString(18));
					p.setComment(rs.getString(19));
					list.add(p);
					}
				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static List<Patents> getRev_2PatentSearch(String search){
	
	List<Patents> list=new ArrayList<Patents>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from patents where authors_name "
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
					Patents p=new Patents();
					p.setId(rs.getInt(1));
					p.setPcn(rs.getString(2));
					p.setName(rs.getString(3));
					p.setDept(rs.getString(4));
					p.setTitle(rs.getString(5));
					p.setScope(rs.getString(6));
					p.setCountry(rs.getString(7));
					p.setApplication_no(rs.getString(8));
					p.setApplication_year(rs.getInt(9));
					p.setApplication_date(rs.getString(10));
					p.setAward_year(rs.getInt(11));
					p.setAward_date(rs.getString(12));
					p.setPatent_no(rs.getString(13));
					p.setPatent_file(rs.getString(14));
					p.setPlag_report(rs.getString(15));
					p.setRevision(rs.getInt(16));
					p.setStatus(rs.getString(17));
					p.setUsername(rs.getString(18));
					p.setComment(rs.getString(19));
					list.add(p);
					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static Patents getPatentById(int id){
    if(id <= 0){
        return null;
    }
    Patents p=new Patents();

    ResultSet rs = null;
    try{
    	connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from patents where id=?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
        	
			p.setId(rs.getInt(1));
			p.setPcn(rs.getString(2));
			p.setName(rs.getString(3));
			p.setDept(rs.getString(4));
			p.setTitle(rs.getString(5));
			p.setScope(rs.getString(6));
			p.setCountry(rs.getString(7));
			p.setApplication_no(rs.getString(8));
			p.setApplication_year(rs.getInt(9));
			p.setApplication_date(rs.getString(10));
			p.setAward_year(rs.getInt(11));
			p.setAward_date(rs.getString(12));
			p.setPatent_no(rs.getString(13));
			p.setPatent_file(rs.getString(14));
			p.setPlag_report(rs.getString(15));
			p.setRevision(rs.getInt(16));
			p.setStatus(rs.getString(17));
			p.setUsername(rs.getString(18));
			p.setComment(rs.getString(19));
			
            connection.close();
            return p;
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

	return p;
}


public static List<Patents> getPatentSearch2(String search){
	
	List<Patents> list=new ArrayList<Patents>();
			
			try{
				
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from patents where authors_name "
						+ "like ? or authors_name like ? or authors_name like ? or authors_name like ?");
				p1.setString(1, search+"%");
				p1.setString(2, "%"+search+"%");
				p1.setString(3, "%"+search);
				p1.setString(4, search);
				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					Patents p=new Patents();
					p.setId(rs.getInt(1));
					p.setPcn(rs.getString(2));
					p.setName(rs.getString(3));
					p.setDept(rs.getString(4));
					p.setTitle(rs.getString(5));
					p.setScope(rs.getString(6));
					p.setCountry(rs.getString(7));
					p.setApplication_no(rs.getString(8));
					p.setApplication_year(rs.getInt(9));
					p.setApplication_date(rs.getString(10));
					p.setAward_year(rs.getInt(11));
					p.setAward_date(rs.getString(12));
					p.setPatent_no(rs.getString(13));
					p.setPatent_file(rs.getString(14));
					p.setPlag_report(rs.getString(15));
					p.setRevision(rs.getInt(16));
					p.setStatus(rs.getString(17));
					p.setUsername(rs.getString(18));
					p.setComment(rs.getString(19));
					list.add(p);
					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}

	
}
