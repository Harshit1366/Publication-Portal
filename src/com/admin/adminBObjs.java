package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.books.Books;
import com.conf_proceedings.conf_proceedings;
import com.journal.Journal;
import com.user.ConnectionFactory;

public class adminBObjs {
	
	static Connection connection = null;
	

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
				b.setYear(rs.getInt(8));
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
							b.setYear(rs.getInt(8));
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
	
	
	
	public static int AllB(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from books");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	public static int AllNewB(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from books where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev1B(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from books where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev2B(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from books where revision=? and pcn is ? and status is ?");
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
	
	

	public static List<Books> getNewBooks(){
		List<Books> list=new ArrayList<Books>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from books where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 0);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
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
				b.setYear(rs.getInt(8));
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
	
	
public static List<Books> getNewBooksSearch(String search){
		
		List<Books> list=new ArrayList<Books>();
				
				try{
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from books where authors_name "
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
						Books b=new Books();
						b.setId(rs.getInt(1));
						b.setPcn(rs.getString(2));
						b.setName(rs.getString(3));
						b.setDept(rs.getString(4));
						b.setTitle(rs.getString(5));
						b.setPublisher(rs.getString(6));
						b.setScope(rs.getString(7));
						b.setYear(rs.getInt(8));
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


public static List<Books> getRev1Books(){
	List<Books> list=new ArrayList<Books>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from books where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 1);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
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
			b.setYear(rs.getInt(8));
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

public static List<Books> getRev2Books(){
	List<Books> list=new ArrayList<Books>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from books where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 2);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
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
			b.setYear(rs.getInt(8));
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



public static List<Books> getRev1BooksSearch(String search){
	
	List<Books> list=new ArrayList<Books>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from books where authors_name "
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
					Books b=new Books();
					b.setId(rs.getInt(1));
					b.setPcn(rs.getString(2));
					b.setName(rs.getString(3));
					b.setDept(rs.getString(4));
					b.setTitle(rs.getString(5));
					b.setPublisher(rs.getString(6));
					b.setScope(rs.getString(7));
					b.setYear(rs.getInt(8));
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


public static List<Books> getRev2BooksSearch(String search){
	
	List<Books> list=new ArrayList<Books>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from books where authors_name "
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
					Books b=new Books();
					b.setId(rs.getInt(1));
					b.setPcn(rs.getString(2));
					b.setName(rs.getString(3));
					b.setDept(rs.getString(4));
					b.setTitle(rs.getString(5));
					b.setPublisher(rs.getString(6));
					b.setScope(rs.getString(7));
					b.setYear(rs.getInt(8));
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


public static Books getUserById(int id){
    if(id <= 0){
        return null;
    }
    Books b= new Books();

    ResultSet rs = null;
    try{
    	connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from books where id=?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
        	b.setId(rs.getInt(1));
			b.setPcn(rs.getString(2));
			b.setName(rs.getString(3));
			b.setDept(rs.getString(4));
			b.setTitle(rs.getString(5));
			b.setPublisher(rs.getString(6));
			b.setScope(rs.getString(7));
			b.setYear(rs.getInt(8));
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
			
            connection.close();
            return b;
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

	return b;
}


public static List<Books> getSearch2(String search){
	
	List<Books> list=new ArrayList<Books>();
	PreparedStatement p1=null;
			
			try{
				connection = ConnectionFactory.getConnection();
				if(search.equals("p")){
					p1 = connection.prepareStatement("select * from books where pwsgte = ?");
				}
				
				p1.setString(1, "Yes");
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
					b.setYear(rs.getInt(8));
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


public static List<Books> getBooksSearch2(String search){
	
	List<Books> list=new ArrayList<Books>();
			
			try{
				
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from books where authors_name "
						+ "like ? or authors_name like ? or authors_name like ? or authors_name like ?");
				p1.setString(1, search+"%");
				p1.setString(2, "%"+search+"%");
				p1.setString(3, "%"+search);
				p1.setString(4, search);
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
						b.setYear(rs.getInt(8));
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
