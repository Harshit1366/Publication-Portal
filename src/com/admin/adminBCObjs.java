package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.book_chap.Book_chapter;
import com.books.Books;
import com.user.ConnectionFactory;

public class adminBCObjs {
	
static Connection connection = null;
	

	public static List<Book_chapter> getAllBook_Chap(){
		List<Book_chapter> list=new ArrayList<Book_chapter>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from book_chap");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Book_chapter bc=new Book_chapter();
				bc.setId(rs.getInt(1));
				bc.setPcn(rs.getString(2));
				bc.setName(rs.getString(3));
				bc.setDept(rs.getString(4));
				bc.setChap_no(rs.getString(5));
				bc.setChap_title(rs.getString(6));
				bc.setBook_title(rs.getString(7));
				bc.setPublisher(rs.getString(8));
				bc.setScope(rs.getString(9));
				bc.setYear(rs.getInt(10));
				bc.setMonth_pub(rs.getString(11));
				bc.setMonth_pcn(rs.getString(12));
				bc.setPages(rs.getString(13));
				bc.setBook_isbn_no(rs.getString(14));
				bc.setHyperlink(rs.getString(15));
				bc.setP_index(rs.getString(16));
				bc.setLink_index(rs.getString(17));
				bc.setChap_file(rs.getString(18));
				bc.setPlag_report(rs.getString(19));
				bc.setRevision(rs.getInt(20));
				bc.setStatus(rs.getString(21));
				bc.setUsername(rs.getString(22));
				bc.setComment(rs.getString(23));
				list.add(bc);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static List<Book_chapter> getBook_chapById(String id){
		List<Book_chapter> list=new ArrayList<Book_chapter>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from book_chap where username=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Book_chapter bc=new Book_chapter();
				bc.setId(rs.getInt(1));
				bc.setPcn(rs.getString(2));
				bc.setName(rs.getString(3));
				bc.setDept(rs.getString(4));
				bc.setChap_no(rs.getString(5));
				bc.setChap_title(rs.getString(6));
				bc.setBook_title(rs.getString(7));
				bc.setPublisher(rs.getString(8));
				bc.setScope(rs.getString(9));
				bc.setYear(rs.getInt(10));
				bc.setMonth_pub(rs.getString(11));
				bc.setMonth_pcn(rs.getString(12));
				bc.setPages(rs.getString(13));
				bc.setBook_isbn_no(rs.getString(14));
				bc.setHyperlink(rs.getString(15));
				bc.setP_index(rs.getString(16));
				bc.setLink_index(rs.getString(17));
				bc.setChap_file(rs.getString(18));
				bc.setPlag_report(rs.getString(19));
				bc.setRevision(rs.getInt(20));
				bc.setStatus(rs.getString(21));
				//bc.setUsername(rs.getString(22));
				bc.setComment(rs.getString(23));
				list.add(bc);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	
	public static List<Book_chapter> getBook_chapSearch(String search){
		
		List<Book_chapter> list=new ArrayList<Book_chapter>();
				
				try{
					
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from book_chap where authors_name "
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
						Book_chapter bc=new Book_chapter();
						bc.setId(rs.getInt(1));
						bc.setPcn(rs.getString(2));
						bc.setName(rs.getString(3));
						bc.setDept(rs.getString(4));
						bc.setChap_no(rs.getString(5));
						bc.setChap_title(rs.getString(6));
						bc.setBook_title(rs.getString(7));
						bc.setPublisher(rs.getString(8));
						bc.setScope(rs.getString(9));
						bc.setYear(rs.getInt(10));
						bc.setMonth_pub(rs.getString(11));
						bc.setMonth_pcn(rs.getString(12));
						bc.setPages(rs.getString(13));
						bc.setBook_isbn_no(rs.getString(14));
						bc.setHyperlink(rs.getString(15));
						bc.setP_index(rs.getString(16));
						bc.setLink_index(rs.getString(17));
						bc.setChap_file(rs.getString(18));
						bc.setPlag_report(rs.getString(19));
						bc.setRevision(rs.getInt(20));
						bc.setStatus(rs.getString(21));
						bc.setUsername(rs.getString(22));
						bc.setComment(rs.getString(23));
						list.add(bc);
						}

					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}
	
	
	public static int AllBC(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from book_chap");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}
	
	public static int AllNewBC(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from book_chap where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev1BC(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from book_chap where revision=? and pcn is ? and status is ?");
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
	
	
	public static int AllRev2BC(){
		int count = 0;
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select count(id) from book_chap where revision=? and pcn is ? and status is ?");
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
	
	
	
public static List<Book_chapter> getNewBook_chap(){
		
		List<Book_chapter> list=new ArrayList<Book_chapter>();
		
		try{
			connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from book_chap where revision=? and pcn is ? and status is ?");
			ps.setInt(1, 0);
			ps.setNull(2, Types.VARCHAR);
			ps.setNull(3, Types.VARCHAR);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Book_chapter bc=new Book_chapter();
				bc.setId(rs.getInt(1));
				bc.setPcn(rs.getString(2));
				bc.setName(rs.getString(3));
				bc.setDept(rs.getString(4));
				bc.setChap_no(rs.getString(5));
				bc.setChap_title(rs.getString(6));
				bc.setBook_title(rs.getString(7));
				bc.setPublisher(rs.getString(8));
				bc.setScope(rs.getString(9));
				bc.setYear(rs.getInt(10));
				bc.setMonth_pub(rs.getString(11));
				bc.setMonth_pcn(rs.getString(12));
				bc.setPages(rs.getString(13));
				bc.setBook_isbn_no(rs.getString(14));
				bc.setHyperlink(rs.getString(15));
				bc.setP_index(rs.getString(16));
				bc.setLink_index(rs.getString(17));
				bc.setChap_file(rs.getString(18));
				bc.setPlag_report(rs.getString(19));
				bc.setRevision(rs.getInt(20));
				bc.setStatus(rs.getString(21));
				bc.setUsername(rs.getString(22));
				bc.setComment(rs.getString(23));
				list.add(bc);
			}
			connection.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
public static List<Book_chapter> getNewBook_chapSearch(String search){
	
	List<Book_chapter> list=new ArrayList<Book_chapter>();
				
				try{
					connection = ConnectionFactory.getConnection();
					PreparedStatement p1 = connection.prepareStatement("select * from book_chap where authors_name "
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
						Book_chapter bc=new Book_chapter();
						bc.setId(rs.getInt(1));
						bc.setPcn(rs.getString(2));
						bc.setName(rs.getString(3));
						bc.setDept(rs.getString(4));
						bc.setChap_no(rs.getString(5));
						bc.setChap_title(rs.getString(6));
						bc.setBook_title(rs.getString(7));
						bc.setPublisher(rs.getString(8));
						bc.setScope(rs.getString(9));
						bc.setYear(rs.getInt(10));
						bc.setMonth_pub(rs.getString(11));
						bc.setMonth_pcn(rs.getString(12));
						bc.setPages(rs.getString(13));
						bc.setBook_isbn_no(rs.getString(14));
						bc.setHyperlink(rs.getString(15));
						bc.setP_index(rs.getString(16));
						bc.setLink_index(rs.getString(17));
						bc.setChap_file(rs.getString(18));
						bc.setPlag_report(rs.getString(19));
						bc.setRevision(rs.getInt(20));
						bc.setStatus(rs.getString(21));
						bc.setUsername(rs.getString(22));
						bc.setComment(rs.getString(23));
						list.add(bc);
						}	
					}
					connection.close();
				}catch(Exception e){e.printStackTrace();}
				
				return list;
				
			}


public static List<Book_chapter> getRev1Book_chap(){
	
	List<Book_chapter> list=new ArrayList<Book_chapter>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from book_chap where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 1);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Book_chapter bc=new Book_chapter();
			bc.setId(rs.getInt(1));
			bc.setPcn(rs.getString(2));
			bc.setName(rs.getString(3));
			bc.setDept(rs.getString(4));
			bc.setChap_no(rs.getString(5));
			bc.setChap_title(rs.getString(6));
			bc.setBook_title(rs.getString(7));
			bc.setPublisher(rs.getString(8));
			bc.setScope(rs.getString(9));
			bc.setYear(rs.getInt(10));
			bc.setMonth_pub(rs.getString(11));
			bc.setMonth_pcn(rs.getString(12));
			bc.setPages(rs.getString(13));
			bc.setBook_isbn_no(rs.getString(14));
			bc.setHyperlink(rs.getString(15));
			bc.setP_index(rs.getString(16));
			bc.setLink_index(rs.getString(17));
			bc.setChap_file(rs.getString(18));
			bc.setPlag_report(rs.getString(19));
			bc.setRevision(rs.getInt(20));
			bc.setStatus(rs.getString(21));
			bc.setUsername(rs.getString(22));
			bc.setComment(rs.getString(23));
			list.add(bc);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}

public static List<Book_chapter> getRev2Book_chap(){
	
	List<Book_chapter> list=new ArrayList<Book_chapter>();
	
	try{
		connection = ConnectionFactory.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from book_chap where revision=? and pcn is ? and status is ?");
		ps.setInt(1, 2);
		ps.setNull(2, Types.VARCHAR);
		ps.setNull(3, Types.VARCHAR);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Book_chapter bc=new Book_chapter();
			bc.setId(rs.getInt(1));
			bc.setPcn(rs.getString(2));
			bc.setName(rs.getString(3));
			bc.setDept(rs.getString(4));
			bc.setChap_no(rs.getString(5));
			bc.setChap_title(rs.getString(6));
			bc.setBook_title(rs.getString(7));
			bc.setPublisher(rs.getString(8));
			bc.setScope(rs.getString(9));
			bc.setYear(rs.getInt(10));
			bc.setMonth_pub(rs.getString(11));
			bc.setMonth_pcn(rs.getString(12));
			bc.setPages(rs.getString(13));
			bc.setBook_isbn_no(rs.getString(14));
			bc.setHyperlink(rs.getString(15));
			bc.setP_index(rs.getString(16));
			bc.setLink_index(rs.getString(17));
			bc.setChap_file(rs.getString(18));
			bc.setPlag_report(rs.getString(19));
			bc.setRevision(rs.getInt(20));
			bc.setStatus(rs.getString(21));
			bc.setUsername(rs.getString(22));
			bc.setComment(rs.getString(23));
			list.add(bc);
		}
		connection.close();
	}catch(Exception e){e.printStackTrace();}
	
	return list;
}



public static List<Book_chapter> getRev1Book_chapSearch(String search){
	
	List<Book_chapter> list=new ArrayList<Book_chapter>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from book_chap where authors_name "
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
					Book_chapter bc=new Book_chapter();
					bc.setId(rs.getInt(1));
					bc.setPcn(rs.getString(2));
					bc.setName(rs.getString(3));
					bc.setDept(rs.getString(4));
					bc.setChap_no(rs.getString(5));
					bc.setChap_title(rs.getString(6));
					bc.setBook_title(rs.getString(7));
					bc.setPublisher(rs.getString(8));
					bc.setScope(rs.getString(9));
					bc.setYear(rs.getInt(10));
					bc.setMonth_pub(rs.getString(11));
					bc.setMonth_pcn(rs.getString(12));
					bc.setPages(rs.getString(13));
					bc.setBook_isbn_no(rs.getString(14));
					bc.setHyperlink(rs.getString(15));
					bc.setP_index(rs.getString(16));
					bc.setLink_index(rs.getString(17));
					bc.setChap_file(rs.getString(18));
					bc.setPlag_report(rs.getString(19));
					bc.setRevision(rs.getInt(20));
					bc.setStatus(rs.getString(21));
					bc.setUsername(rs.getString(22));
					bc.setComment(rs.getString(23));
					list.add(bc);
					}
				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static List<Book_chapter> getRev2Book_chapSearch(String search){
	
	List<Book_chapter> list=new ArrayList<Book_chapter>();
			
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from book_chap where authors_name "
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
					Book_chapter bc=new Book_chapter();
					bc.setId(rs.getInt(1));
					bc.setPcn(rs.getString(2));
					bc.setName(rs.getString(3));
					bc.setDept(rs.getString(4));
					bc.setChap_no(rs.getString(5));
					bc.setChap_title(rs.getString(6));
					bc.setBook_title(rs.getString(7));
					bc.setPublisher(rs.getString(8));
					bc.setScope(rs.getString(9));
					bc.setYear(rs.getInt(10));
					bc.setMonth_pub(rs.getString(11));
					bc.setMonth_pcn(rs.getString(12));
					bc.setPages(rs.getString(13));
					bc.setBook_isbn_no(rs.getString(14));
					bc.setHyperlink(rs.getString(15));
					bc.setP_index(rs.getString(16));
					bc.setLink_index(rs.getString(17));
					bc.setChap_file(rs.getString(18));
					bc.setPlag_report(rs.getString(19));
					bc.setRevision(rs.getInt(20));
					bc.setStatus(rs.getString(21));
					bc.setUsername(rs.getString(22));
					bc.setComment(rs.getString(23));
					list.add(bc);					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


public static Book_chapter getUserById(int id){
    if(id <= 0){
        return null;
    }
    Book_chapter bc= new Book_chapter();

    ResultSet rs = null;
    try{
    	connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from book_chap where id=?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
        	//Book_chapter bc=new Book_chapter();
			bc.setId(rs.getInt(1));
			bc.setPcn(rs.getString(2));
			bc.setName(rs.getString(3));
			bc.setDept(rs.getString(4));
			bc.setChap_no(rs.getString(5));
			bc.setChap_title(rs.getString(6));
			bc.setBook_title(rs.getString(7));
			bc.setPublisher(rs.getString(8));
			bc.setScope(rs.getString(9));
			bc.setYear(rs.getInt(10));
			bc.setMonth_pub(rs.getString(11));
			bc.setMonth_pcn(rs.getString(12));
			bc.setPages(rs.getString(13));
			bc.setBook_isbn_no(rs.getString(14));
			bc.setHyperlink(rs.getString(15));
			bc.setP_index(rs.getString(16));
			bc.setLink_index(rs.getString(17));
			bc.setChap_file(rs.getString(18));
			bc.setPlag_report(rs.getString(19));
			bc.setRevision(rs.getInt(20));
			bc.setStatus(rs.getString(21));
			bc.setUsername(rs.getString(22));
			bc.setComment(rs.getString(23));
			//list.add(bc);
			
            connection.close();
            return bc;
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

	return bc;
}


public static List<Book_chapter> getSearch2(String search){
	
	List<Book_chapter> list=new ArrayList<Book_chapter>();
	PreparedStatement p1=null;
			
			try{
				connection = ConnectionFactory.getConnection();
				if(search.equals("p")){
					p1 = connection.prepareStatement("select * from book_chap where pwsgte = ?");
				}
				
				p1.setString(1, "Yes");
				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					Book_chapter bc=new Book_chapter();
					bc.setId(rs.getInt(1));
					bc.setPcn(rs.getString(2));
					bc.setName(rs.getString(3));
					bc.setDept(rs.getString(4));
					bc.setChap_no(rs.getString(5));
					bc.setChap_title(rs.getString(6));
					bc.setBook_title(rs.getString(7));
					bc.setPublisher(rs.getString(8));
					bc.setScope(rs.getString(9));
					bc.setYear(rs.getInt(10));
					bc.setMonth_pub(rs.getString(11));
					bc.setMonth_pcn(rs.getString(12));
					bc.setPages(rs.getString(13));
					bc.setBook_isbn_no(rs.getString(14));
					bc.setHyperlink(rs.getString(15));
					bc.setP_index(rs.getString(16));
					bc.setLink_index(rs.getString(17));
					bc.setChap_file(rs.getString(18));
					bc.setPlag_report(rs.getString(19));
					bc.setRevision(rs.getInt(20));
					bc.setStatus(rs.getString(21));
					bc.setUsername(rs.getString(22));
					bc.setComment(rs.getString(23));
					list.add(bc);	
					}	
				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}

public static List<Book_chapter> getBook_chapSearch2(String search){
	
	List<Book_chapter> list=new ArrayList<Book_chapter>();
			
			try{
				
				connection = ConnectionFactory.getConnection();
				PreparedStatement p1 = connection.prepareStatement("select * from book_chap where authors_name "
						+ "like ? or authors_name like ? or authors_name like ? or authors_name like ?");
				p1.setString(1, search+"%");
				p1.setString(2, "%"+search+"%");
				p1.setString(3, "%"+search);
				p1.setString(4, search);
				ResultSet rs=p1.executeQuery();
				if(rs.next()){
					rs.previous();
				while(rs.next()){
					Book_chapter bc=new Book_chapter();
					bc.setId(rs.getInt(1));
					bc.setPcn(rs.getString(2));
					bc.setName(rs.getString(3));
					bc.setDept(rs.getString(4));
					bc.setChap_no(rs.getString(5));
					bc.setChap_title(rs.getString(6));
					bc.setBook_title(rs.getString(7));
					bc.setPublisher(rs.getString(8));
					bc.setScope(rs.getString(9));
					bc.setYear(rs.getInt(10));
					bc.setMonth_pub(rs.getString(11));
					bc.setMonth_pcn(rs.getString(12));
					bc.setPages(rs.getString(13));
					bc.setBook_isbn_no(rs.getString(14));
					bc.setHyperlink(rs.getString(15));
					bc.setP_index(rs.getString(16));
					bc.setLink_index(rs.getString(17));
					bc.setChap_file(rs.getString(18));
					bc.setPlag_report(rs.getString(19));
					bc.setRevision(rs.getInt(20));
					bc.setStatus(rs.getString(21));
					bc.setUsername(rs.getString(22));
					bc.setComment(rs.getString(23));
					list.add(bc);
					}

				}
				connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return list;
			
		}


}
