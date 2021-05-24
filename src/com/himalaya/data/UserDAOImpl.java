package com.himalaya.data;
import java.io.InputStream;
import java.sql.*;
import com.himlaya.model.User;

public class UserDAOImpl implements UserDAO
{

	@Override
	public void addUser(User user) throws Exception {

		Connection con=null;
		PreparedStatement ps=null;
		
		try {
		   con=ConnectionFactory.getCon();	
		   ps=con.prepareStatement("insert users values(?,?,?,?,?,?,?)");
		   ps.setString(1, user.getUserId());
		   ps.setString(2, user.getPassword());
		   ps.setString(3, user.getFirstName());
		   ps.setString(4, user.getLastName());
		   ps.setString(5, user.getAddress());
		   ps.setString(6, user.getCity());
		   
		   ps.setBlob(7,user.getInputStream());
		   
		   ps.executeUpdate();
		}
		finally {
			con.close();
		}
	}

	@Override
	public User getUser(String userId) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		User user=null;
		//it only used to select query
		ResultSet rs=null;
		try
		{
			con=ConnectionFactory.getCon();	
			ps=con.prepareStatement("select * from users where user_id=?");
			ps.setString(1,userId);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				user=new User();
				
				user.setUserId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setCity(rs.getString(6));
				// do in previous method
				//String password=rs.getString(2);
				//String firstName=rs.getString(3);
				//String lastName=rs.getString(4);
				//String address=rs.getString(5);
				//String city=rs.getString(6);
				
				 
				Blob photo=rs.getBlob(7); 
				user.setPhoto(photo.getBytes(1,(int)photo.length()));
			//	user= new User(userId, password, firstName, lastName, address, city,);
				
			}
			else {
				throw new Exception("Invalid User Id");
			}
		}
		finally
		{
			con.close();
		}
		return user;
	}

	@Override
	public void updatePhoto(String userId, InputStream inputStream) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("update users set photo=? where user_id=?");
			ps.setBlob(1, inputStream);
			ps.setString(2, userId);
			
			ps.executeUpdate();
		}
		finally {
			con.close();
		}
		
		
	}
     
}
