package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Orders;
import com.icss.snacks.entity.Orders_detail;
import com.icss.snacks.entity.User;
import com.icss.snacks.util.DBfactory;

public class Orders_detailDao {

	public int addod(Orders_detail orders_detail) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "insert into tb_orders_detail(commodity_id,quantity,price,fid,brand_id,oid) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, orders_detail.getCommodity_id());
        ps.setInt(2, orders_detail.getQuantity());
        ps.setDouble(3, orders_detail.getPrice());
        ps.setInt(4, orders_detail.getFid());
        ps.setInt(5, orders_detail.getBrand_id());
        ps.setString(6, orders_detail.getOid());
        row = ps.executeUpdate();
        ps.close();
		return row;}
	
	public int deleteod(Orders_detail orders_detail) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "delete from tb_orders_detail where detail_id=?";
	    PreparedStatement ps = connection.prepareStatement(sql)	;
	    ps.setInt(1, orders_detail.getDetail_id());
	    row = ps.executeUpdate();
	    ps.close();		
	    return row;
		}
	
	public int updataod(Orders_detail orders_detail) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "update tb_orders_detail set commodity_id=?,quantity=?,price=?,fid=?,brand_id=?,oid=? where detail_id=?";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, orders_detail.getCommodity_id());
        ps.setInt(2, orders_detail.getQuantity());
        ps.setDouble(3, orders_detail.getPrice());
        ps.setInt(4, orders_detail.getFid());
        ps.setInt(5, orders_detail.getBrand_id());
        ps.setString(6, orders_detail.getOid());
        ps.setInt(7, orders_detail.getDetail_id());
        row = ps.executeUpdate();
        ps.close();
		return row;
	}
	
	
	public Orders_detail findOrders_detailByDetail_id(int detail_id) throws Exception{
		Orders_detail orders_detail = null;
		Connection connection = DBfactory.openConnection();
		String sql = "select * from tb_orders_detail where detail_id=?";
	        PreparedStatement ps = connection.prepareStatement(sql)	;
	        ps.setInt(1, orders_detail.getDetail_id());
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	orders_detail = new Orders_detail();
	        	orders_detail.setDetail_id(rs.getInt("detail_id"));
	        	orders_detail.setCommodity_id(rs.getInt("commodity_id"));
	        	orders_detail.setQuantity(rs.getInt("quantity"));
	        	orders_detail.setPrice(rs.getDouble("price"));
	        	orders_detail.setFid(rs.getInt("fid"));
	        	orders_detail.setBrand_id(rs.getInt("brand_id"));
	        	orders_detail.setOid(rs.getString("oid"));

	        }
	        ps.close();		
	        rs.close();	
	        return orders_detail;
		}
		
	public List<Orders_detail> findAllList() throws Exception{
		List<Orders_detail> orders_detailList =new ArrayList<Orders_detail>();
		Connection connection = DBfactory.openConnection();
		String sql = "select * from tb_orders_detail ";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
        	Orders_detail orders_detail = new Orders_detail();
        	orders_detail.setDetail_id(rs.getInt("detail_id"));
        	orders_detail.setCommodity_id(rs.getInt("commodity_id"));
        	orders_detail.setQuantity(rs.getInt("quantity"));
        	orders_detail.setPrice(rs.getDouble("price"));
        	orders_detail.setFid(rs.getInt("fid"));
        	orders_detail.setBrand_id(rs.getInt("brand_id"));
        	orders_detail.setOid(rs.getString("oid"));
        	orders_detailList.add(orders_detail);
        }
        ps.close();		
        rs.close();		
		return orders_detailList;
	}
	
	

	
}
