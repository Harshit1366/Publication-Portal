package com.notify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.user.ConnectionFactory;

public class notifObjs {
		
		 static Connection connection = null;
		
		public static List<notification> getNotif(String user){
			List<notification> list=new ArrayList<notification>();
	       int dif,id,diff = 0;
	        ResultSet rs = null,rs1 = null;
	        try{
	        	connection = ConnectionFactory.getConnection();
	            PreparedStatement ps = connection.prepareStatement("select id,notification,timestampdiff(hour,creation,current_timestamp) from notify where viewed = ? and user_id=? order by id desc");
	            ps.setInt(1, 0);
	            ps.setString(2, user);
	            rs = ps.executeQuery();
	            while(rs.next()){
	            	notification n = new notification();
	            	id=rs.getInt(1);
	            	n.setId(rs.getInt(1));
	            	n.setNotification(rs.getString(2));
	            	dif=rs.getInt(3);
	            	if(dif == 0){
	            		System.out.println("INSIDE IF");
	            		PreparedStatement ps1 = connection.prepareStatement("select timestampdiff(minute,creation,current_timestamp) from notify where id = ?");
	            	    ps1.setInt(1, id);
	            	    rs1 = ps1.executeQuery();
	    	            while(rs1.next()){
	    	            	diff = rs1.getInt(1);
	    	            	if(diff<=1){
	    	            		n.setDiff(diff+" minute ago");
	    	            	}else{
	    	            		n.setDiff(diff+" minutes ago");
	    	            	}
	    	            	//System.out.println(diff);
	    	            }
	    	            //System.out.println(diff);
	            	}else if(dif>=24){
	            		PreparedStatement ps1 = connection.prepareStatement("select timestampdiff(day,creation,current_timestamp) from notify where id = ?");
	            	    ps1.setInt(1, id);
	            	    rs1 = ps1.executeQuery();
	    	            while(rs1.next()){
	    	            	diff = rs1.getInt(1);
	    	            
	    	            	if(diff<=1){
	    	            		n.setDiff(diff+" day ago");
	    	            	}else{
	    	            		n.setDiff(diff+" days ago");
	    	            	}
	    	            }
	            		//System.out.println("INSIDE else-IF");
	            	}
	            	else{
	            		//System.out.println("INSIDE ELSE");
	            		diff=dif;
	            		if(diff<=1){
    	            		n.setDiff(diff+" hour ago");
    	            	}else{
    	            		n.setDiff(diff+" hours ago");
    	            	}

	            	}
	            	//System.out.println(diff);
	            	
	            	list.add(n);
	            }
	            connection.close();
	        }catch (Exception e) {
				e.printStackTrace();
			}
	        return list;
	    }
		
		
		public static int count_notif(String user){
			int count = 0;
			try{
				connection = ConnectionFactory.getConnection();
				PreparedStatement ps=connection.prepareStatement("select count(id) from notify where viewed = ? and user_id=?");
				ps.setInt(1, 0);
				ps.setString(2, user);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					count=rs.getInt(1);
				}connection.close();
			}catch(Exception e){e.printStackTrace();}
			
			return count;
		}

}
