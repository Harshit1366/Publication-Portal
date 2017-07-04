package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.user.ConnectionFactory;
import com.books.Books;
import com.journal.Journal;


public class adminObjs {
	
	 static Connection connection = null;
	
	public static Journal getUserById(int id){
        if(id <= 0){
            return null;
        }
        Journal j= new Journal();

        ResultSet rs = null;
        try{
        	connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from journal where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	j.setName(rs.getString(1));
				j.setDept(rs.getString(2));
				j.setTitle(rs.getString(3));
				j.setJourn(rs.getString(4));
				j.setScope(rs.getString(5));
				j.setYear(rs.getString(6));
				j.setMonth_pub(rs.getString(7));
				j.setMonth_pcn(rs.getString(8));
				j.setVol(rs.getString(9));
				j.setIssue(rs.getString(10));
				j.setPages(rs.getString(11));
				j.setIfs(rs.getString(12));
				j.setSwif(rs.getString(13));
				j.setLfif(rs.getString(14));
				j.setPay(rs.getString(15));
				j.setPdon(rs.getString(16));
				j.setPw(rs.getString(17));
				j.setPs(rs.getString(18));
				j.setPg(rs.getString(19));
				j.setPi(rs.getString(20));
				j.setPcn(rs.getString(22));
				j.setJournal_file(rs.getString(21));
				j.setPlag_report(rs.getString(23));
				//j.setId(rs.getInt(26));
                connection.close();
                return j;
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
      //  return null;
		return j;
    }
	
	
	public static List<Journal> getUserById(String id){
		List<Journal> list=new ArrayList<Journal>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from journal where username=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Journal j=new Journal();
				j.setName(rs.getString(1));
				j.setDept(rs.getString(2));
				j.setTitle(rs.getString(3));
				j.setJourn(rs.getString(4));
				j.setScope(rs.getString(5));
				j.setYear(rs.getString(6));
				j.setMonth_pub(rs.getString(7));
				j.setMonth_pcn(rs.getString(8));
				j.setVol(rs.getString(9));
				j.setIssue(rs.getString(10));
				j.setPages(rs.getString(11));
				j.setIfs(rs.getString(12));
				j.setSwif(rs.getString(13));
				j.setLfif(rs.getString(14));
				j.setPay(rs.getString(15));
				j.setPdon(rs.getString(16));
				j.setPw(rs.getString(17));
				j.setPs(rs.getString(18));
				j.setPg(rs.getString(19));
				j.setPi(rs.getString(20));
				j.setPcn(rs.getString(22));
				j.setRevision(rs.getInt(24));
				j.setStatus(rs.getString(25));
				j.setId(rs.getInt(27));
				j.setComment(rs.getString(28));
				list.add(j);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	
	public static List<Journal> getAllEmployees(){
		List<Journal> list=new ArrayList<Journal>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from journal");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Journal j=new Journal();
				j.setName(rs.getString(1));
				j.setDept(rs.getString(2));
				j.setTitle(rs.getString(3));
				j.setJourn(rs.getString(4));
				j.setScope(rs.getString(5));
				j.setYear(rs.getString(6));
				j.setMonth_pub(rs.getString(7));
				j.setMonth_pcn(rs.getString(8));
				j.setVol(rs.getString(9));
				j.setIssue(rs.getString(10));
				j.setPages(rs.getString(11));
				j.setIfs(rs.getString(12));
				j.setSwif(rs.getString(13));
				j.setLfif(rs.getString(14));
				j.setPay(rs.getString(15));
				j.setPdon(rs.getString(16));
				j.setPw(rs.getString(17));
				j.setPs(rs.getString(18));
				j.setPg(rs.getString(19));
				j.setPi(rs.getString(20));
				j.setPcn(rs.getString(22));
				j.setRevision(rs.getInt(24));
				j.setStatus(rs.getString(25));
				j.setId(rs.getInt(27));
				j.setComment(rs.getString(28));
				list.add(j);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static List<Journal> getNewEmployees(){
		List<Journal> list=new ArrayList<Journal>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from journal where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 0);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Journal j=new Journal();
				j.setName(rs.getString(1));
				j.setDept(rs.getString(2));
				j.setTitle(rs.getString(3));
				j.setJourn(rs.getString(4));
				j.setScope(rs.getString(5));
				j.setYear(rs.getString(6));
				j.setMonth_pub(rs.getString(7));
				j.setMonth_pcn(rs.getString(8));
				j.setVol(rs.getString(9));
				j.setIssue(rs.getString(10));
				j.setPages(rs.getString(11));
				j.setIfs(rs.getString(12));
				j.setSwif(rs.getString(13));
				j.setLfif(rs.getString(14));
				j.setPay(rs.getString(15));
				j.setPdon(rs.getString(16));
				j.setPw(rs.getString(17));
				j.setPs(rs.getString(18));
				j.setPg(rs.getString(19));
				j.setPi(rs.getString(20));
				j.setPcn(rs.getString(22));
				j.setRevision(rs.getInt(24));
				j.setId(rs.getInt(27));
				list.add(j);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	public static List<Journal> getSearch(String search){
		
List<Journal> list=new ArrayList<Journal>();
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			connection = ConnectionFactory.getConnection();
			PreparedStatement p1 = connection.prepareStatement("select * from journal where authors_name "
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
				//Pattern p=Pattern.compile(""+search+"+");
				//Matcher m=p.matcher(rs.getString(1));
				//if(m.matches()){
				
					Journal j=new Journal();
					j.setName(rs.getString(1));
					j.setDept(rs.getString(2));
					j.setTitle(rs.getString(3));
					j.setJourn(rs.getString(4));
					j.setScope(rs.getString(5));
					j.setYear(rs.getString(6));
					j.setMonth_pub(rs.getString(7));
					j.setMonth_pcn(rs.getString(8));
					j.setVol(rs.getString(9));
					j.setIssue(rs.getString(10));
					j.setPages(rs.getString(11));
					j.setIfs(rs.getString(12));
					j.setSwif(rs.getString(13));
					j.setLfif(rs.getString(14));
					j.setPay(rs.getString(15));
					j.setPdon(rs.getString(16));
					j.setPw(rs.getString(17));
					j.setPs(rs.getString(18));
					j.setPg(rs.getString(19));
					j.setPi(rs.getString(20));
					j.setPcn(rs.getString(22));
					j.setStatus(rs.getString(25));
					j.setId(rs.getInt(27));
					list.add(j);
				}
			
			//}	
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
		
	}
	
	
	public static List<Journal> getNewSearch(String search){
		
		List<Journal> list=new ArrayList<Journal>();
				
				try{
					//Class.forName("com.mysql.jdbc.Driver");                                       
					//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from journal where authors_name "
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
						//Pattern p=Pattern.compile(""+search+"+");
						//Matcher m=p.matcher(rs.getString(1));
						//if(m.matches()){
						
							Journal j=new Journal();
							j.setName(rs.getString(1));
							j.setDept(rs.getString(2));
							j.setTitle(rs.getString(3));
							j.setJourn(rs.getString(4));
							j.setScope(rs.getString(5));
							j.setYear(rs.getString(6));
							j.setMonth_pub(rs.getString(7));
							j.setMonth_pcn(rs.getString(8));
							j.setVol(rs.getString(9));
							j.setIssue(rs.getString(10));
							j.setPages(rs.getString(11));
							j.setIfs(rs.getString(12));
							j.setSwif(rs.getString(13));
							j.setLfif(rs.getString(14));
							j.setPay(rs.getString(15));
							j.setPdon(rs.getString(16));
							j.setPw(rs.getString(17));
							j.setPs(rs.getString(18));
							j.setPg(rs.getString(19));
							j.setPi(rs.getString(20));
							j.setPcn(rs.getString(22));
							j.setId(rs.getInt(27));
							list.add(j);
						}
					
					//}	
					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}
	
	
	public static List<Journal> getRev1Employees(){
		List<Journal> list=new ArrayList<Journal>();
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from journal where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 1);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Journal j=new Journal();
				j.setName(rs.getString(1));
				j.setDept(rs.getString(2));
				j.setTitle(rs.getString(3));
				j.setJourn(rs.getString(4));
				j.setScope(rs.getString(5));
				j.setYear(rs.getString(6));
				j.setMonth_pub(rs.getString(7));
				j.setMonth_pcn(rs.getString(8));
				j.setVol(rs.getString(9));
				j.setIssue(rs.getString(10));
				j.setPages(rs.getString(11));
				j.setIfs(rs.getString(12));
				j.setSwif(rs.getString(13));
				j.setLfif(rs.getString(14));
				j.setPay(rs.getString(15));
				j.setPdon(rs.getString(16));
				j.setPw(rs.getString(17));
				j.setPs(rs.getString(18));
				j.setPg(rs.getString(19));
				j.setPi(rs.getString(20));
				j.setPcn(rs.getString(22));
				j.setRevision(rs.getInt(24));
				j.setStatus(rs.getString(25));
				j.setId(rs.getInt(27));
				list.add(j);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	public static List<Journal> getRev2Employees(){
		List<Journal> list=new ArrayList<Journal>();
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from journal where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 2);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Journal j=new Journal();
				j.setName(rs.getString(1));
				j.setDept(rs.getString(2));
				j.setTitle(rs.getString(3));
				j.setJourn(rs.getString(4));
				j.setScope(rs.getString(5));
				j.setYear(rs.getString(6));
				j.setMonth_pub(rs.getString(7));
				j.setMonth_pcn(rs.getString(8));
				j.setVol(rs.getString(9));
				j.setIssue(rs.getString(10));
				j.setPages(rs.getString(11));
				j.setIfs(rs.getString(12));
				j.setSwif(rs.getString(13));
				j.setLfif(rs.getString(14));
				j.setPay(rs.getString(15));
				j.setPdon(rs.getString(16));
				j.setPw(rs.getString(17));
				j.setPs(rs.getString(18));
				j.setPg(rs.getString(19));
				j.setPi(rs.getString(20));
				j.setPcn(rs.getString(22));
				j.setRevision(rs.getInt(24));
				j.setId(rs.getInt(27));
				list.add(j);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	
	public static List<Journal> getRev1Search(String search){
		
		List<Journal> list=new ArrayList<Journal>();
				
				try{
					//Class.forName("com.mysql.jdbc.Driver");                                       
					//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from journal where authors_name "
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
						//Pattern p=Pattern.compile(""+search+"+");
						//Matcher m=p.matcher(rs.getString(1));
						//if(m.matches()){
						
							Journal j=new Journal();
							j.setName(rs.getString(1));
							j.setDept(rs.getString(2));
							j.setTitle(rs.getString(3));
							j.setJourn(rs.getString(4));
							j.setScope(rs.getString(5));
							j.setYear(rs.getString(6));
							j.setMonth_pub(rs.getString(7));
							j.setMonth_pcn(rs.getString(8));
							j.setVol(rs.getString(9));
							j.setIssue(rs.getString(10));
							j.setPages(rs.getString(11));
							j.setIfs(rs.getString(12));
							j.setSwif(rs.getString(13));
							j.setLfif(rs.getString(14));
							j.setPay(rs.getString(15));
							j.setPdon(rs.getString(16));
							j.setPw(rs.getString(17));
							j.setPs(rs.getString(18));
							j.setPg(rs.getString(19));
							j.setPi(rs.getString(20));
							j.setPcn(rs.getString(22));
							j.setId(rs.getInt(27));
							list.add(j);
						}
					
					//}	
					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}
	
	
	public static List<Journal> getRev2Search(String search){
		
		List<Journal> list=new ArrayList<Journal>();
				
				try{
					//Class.forName("com.mysql.jdbc.Driver");                                       
					//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from journal where authors_name "
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
						//Pattern p=Pattern.compile(""+search+"+");
						//Matcher m=p.matcher(rs.getString(1));
						//if(m.matches()){
						
							Journal j=new Journal();
							j.setName(rs.getString(1));
							j.setDept(rs.getString(2));
							j.setTitle(rs.getString(3));
							j.setJourn(rs.getString(4));
							j.setScope(rs.getString(5));
							j.setYear(rs.getString(6));
							j.setMonth_pub(rs.getString(7));
							j.setMonth_pcn(rs.getString(8));
							j.setVol(rs.getString(9));
							j.setIssue(rs.getString(10));
							j.setPages(rs.getString(11));
							j.setIfs(rs.getString(12));
							j.setSwif(rs.getString(13));
							j.setLfif(rs.getString(14));
							j.setPay(rs.getString(15));
							j.setPdon(rs.getString(16));
							j.setPw(rs.getString(17));
							j.setPs(rs.getString(18));
							j.setPg(rs.getString(19));
							j.setPi(rs.getString(20));
							j.setPcn(rs.getString(22));
							j.setId(rs.getInt(27));
							list.add(j);
						}
					
					//}	
					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}
	
	
	public static List<Books> getAllBooks(){
		List<Books> list=new ArrayList<Books>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from books");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Books b=new Books();
				b.setId(rs.getInt(1));
				b.setPcn(rs.getString(2));
				b.setName(rs.getString(3));
				b.setDept(rs.getString(4));
				b.setTitle(rs.getString(5));
				b.setPublisher(rs.getString(6));
				b.setScope(rs.getString(7));
				//String y=rs.getString(8);
				//int year=Integer.valueOf(y);
				b.setYear(rs.getInt(8));
				//b.setYear(year);
				b.setMonth_pub(rs.getString(9));
				b.setMonth_pcn(rs.getString(10));
				b.setPages(rs.getString(11));
				b.setIsbn_no(rs.getString(12));
				b.setP_index(rs.getString(13));
				b.setLink_index(rs.getString(14));
				b.setBook_file(rs.getString(15));
				b.setPlag_report(rs.getString(16));
				b.setRevision(rs.getInt(17));
				b.setStatus(rs.getString(18));
				b.setComment(rs.getString(20));
				b.setHyperlink(rs.getString(21));
				
				list.add(b);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static List<Books> getBookById(String id){
		List<Books> list=new ArrayList<Books>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from books where username=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Books b=new Books();
				b.setId(rs.getInt(1));
				b.setPcn(rs.getString(2));
				b.setName(rs.getString(3));
				b.setDept(rs.getString(4));
				b.setTitle(rs.getString(5));
				b.setPublisher(rs.getString(6));
				b.setScope(rs.getString(7));
				//String y=rs.getString(8);
				//int year=Integer.valueOf(y);
				b.setYear(rs.getInt(8));
				//b.setYear(year);
				b.setMonth_pub(rs.getString(9));
				b.setMonth_pcn(rs.getString(10));
				b.setPages(rs.getString(11));
				b.setIsbn_no(rs.getString(12));
				b.setP_index(rs.getString(13));
				b.setLink_index(rs.getString(14));
				b.setBook_file(rs.getString(15));
				b.setPlag_report(rs.getString(16));
				b.setRevision(rs.getInt(17));
				b.setStatus(rs.getString(18));
				b.setComment(rs.getString(20));
				b.setHyperlink(rs.getString(21));
				
				list.add(b);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	
	public static List<Books> getBooksSearch(String search){
		
		List<Books> list=new ArrayList<Books>();
				
				try{
					
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from books where authors_name "
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
							Books b=new Books();
							b.setId(rs.getInt(1));
							b.setPcn(rs.getString(2));
							b.setName(rs.getString(3));
							b.setDept(rs.getString(4));
							b.setTitle(rs.getString(5));
							b.setPublisher(rs.getString(6));
							b.setScope(rs.getString(7));
							//String y=rs.getString(8);
							//int year=Integer.valueOf(y);
							b.setYear(rs.getInt(8));
							//b.setYear(year);
							b.setMonth_pub(rs.getString(9));
							b.setMonth_pcn(rs.getString(10));
							b.setPages(rs.getString(11));
							b.setIsbn_no(rs.getString(12));
							b.setP_index(rs.getString(13));
							b.setLink_index(rs.getString(14));
							b.setBook_file(rs.getString(15));
							b.setPlag_report(rs.getString(16));
							b.setRevision(rs.getInt(17));
							b.setStatus(rs.getString(18));
							b.setComment(rs.getString(20));
							b.setHyperlink(rs.getString(21));
							
							list.add(b);
						}

					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}

}
