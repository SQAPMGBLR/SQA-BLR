package com.nttdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nttdata.beans.LibrarianBean;

public class LibrarianDao {

	static Connection con;
	public static int save(LibrarianBean bean) throws SQLException{
		int status = 0;
		try{
			
			/*FileOutputStream file = new FileOutputStream(new File("E://Surendra/RND/ELibrary.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(file);
			
			System.out.println("Record is added sucessfully");
			oos.writeObject(bean);
			oos.close();
			*/
			
			con = DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Library(name,email,password,Mob_num) values(?,?,?,?)");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setLong(4,bean.getMobile());
			status=ps.executeUpdate();
			
			
			
		}catch(Exception e) {
//			status = 1;
			System.out.println(e);
		}
		finally {
			con.close();
		}
		
		return status;
	}
	public static int update(LibrarianBean bean) throws SQLException{
		int status=0;
		try{
			/*FileInputStream file = new FileInputStream(new File("E://Surendra/RND/ELibrary.txt"));
			ObjectInputStream oi = new ObjectInputStream(file);
			LibrarianBean pr1 = (LibrarianBean) oi.readObject();
			oi.close();
			file.close();*/
			
			con = DB.getCon();
			PreparedStatement ps=con.prepareStatement("update Library set name=?,email=?,password=?,Mob_num=? where id=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setLong(4,bean.getMobile());
			ps.setInt(5,bean.getId());
			status=ps.executeUpdate();

		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			con.close();
		}
		return status;
	}
	public static List<LibrarianBean> view() throws SQLException{
		List<LibrarianBean> list=new ArrayList<LibrarianBean>();
		try{
			con = DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Library");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				LibrarianBean bean=new LibrarianBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("Mob_num"));
				list.add(bean);
			}
						
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			con.close();
		}
		return list;
	}
	public static LibrarianBean viewById(int id) throws SQLException{
		LibrarianBean bean=new LibrarianBean();
		try{
			con = DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Library where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getLong(5));
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			con.close();
		}
		
		return bean;
	}
	public static int delete(int id) throws SQLException{
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from Library where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			con.close();
		}
		
		return status;
	}

	public static boolean authenticate(String email,String password) throws SQLException{
		boolean status=false;
		try{
			con = DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Library where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			con.close();
		}
		
		return status;
	}
}
