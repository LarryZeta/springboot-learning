package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Orders;
import com.icss.snacks.entity.User;
import com.icss.snacks.util.DBfactory;

public class UserDao {
	public int register(User user) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "insert into tb_user(username,password,regtime) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setTimestamp(3, user.getRegtime());
        row = ps.executeUpdate();
        ps.close();
		return row;
		
	}
	
	public int updata(User user) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "update tb_user set username=?,password=?,phone=?,sex=?,email=? where uid=?";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getPhone());
        ps.setString(4, user.getSex());
        ps.setString(5, user.getEmail());
        ps.setInt(6, user.getUid());
        row = ps.executeUpdate();
        ps.close();
		return row;
		
	}
	
	public int delete(User user) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "delete from tb_user where uid=?";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, user.getUid());
        row = ps.executeUpdate();
        ps.close();		
        return row;
	}
	
	public User findUserByUid(int uid) throws Exception{
		User user = null;
		Connection connection = DBfactory.openConnection();
		String sql = "select * from tb_user where uid=?";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, user.getUid());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
        	user = new User();
        	user.setEmail(rs.getString("email"));
        	user.setAccount_id(rs.getInt("account_id"));
        	user.setPassword(rs.getString("password"));
        	user.setPhone(rs.getString("phone"));
        	user.setRegtime(rs.getTimestamp("regtime"));
        	user.setSex(rs.getString("sex"));
        	user.setUid(rs.getInt("uid"));
        	user.setUsername(rs.getString("username"));
        }
        ps.close();		
        rs.close();	
        return user;
	}
	
	public List<User> findAllUserList() throws Exception{
		List<User> userList =new ArrayList<User>();
		Connection connection = DBfactory.openConnection();
		String sql = "select * from tb_user";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
        	User user = new User();
        	user.setEmail(rs.getString("email"));
        	user.setAccount_id(rs.getInt("account_id"));
        	user.setPassword(rs.getString("password"));
        	user.setPhone(rs.getString("phone"));
        	user.setRegtime(rs.getTimestamp("regtime"));
        	user.setSex(rs.getString("sex"));
        	user.setUid(rs.getInt("uid"));
        	user.setUsername(rs.getString("username"));
        	userList.add(user);
        }
        ps.close();		
        rs.close();		
		return userList;
	}
	
	public int findUserCount() throws Exception{
		int count = 0;
		List<User> userList =new ArrayList<User>();
		Connection connection = DBfactory.openConnection();
		String sql = "select count(*) from tb_user";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	count = rs.getInt(1);
        }
        ps.close();		
        rs.close();		
		return count;
	}
	
	

}
