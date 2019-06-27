package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Orders;
import com.icss.snacks.entity.Orders_detail;
import com.icss.snacks.entity.User;
import com.icss.snacks.entity.Flavor_commodity;
import com.icss.snacks.util.DBfactory;

public class Flavor_commodityDao {

	public int addfc(Flavor_commodity flavor_commodity) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "insert into tb_flavor_commodity(fid,commodity_id,stock) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, flavor_commodity.getFid());
        ps.setInt(2, flavor_commodity.getCommodity_id());
        ps.setInt(3, flavor_commodity.getStock());
        row = ps.executeUpdate();
        ps.close();
		return row;}
		
	public int deletefc(Flavor_commodity flavor_commodity) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "delete from tb_flavor_commodity where id=?";
	    PreparedStatement ps = connection.prepareStatement(sql)	;
	    ps.setInt(1, flavor_commodity.getId());
	    row = ps.executeUpdate();
	    ps.close();		
	    return row;
		}
		
	public int updatefc(Flavor_commodity flavor_commodity) throws Exception{
		int row = 0;
		Connection connection = DBfactory.openConnection();
		String sql = "update tb_flavor_commodity set fid=?,commodity_id=?,stock=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, flavor_commodity.getFid());
        ps.setInt(2, flavor_commodity.getCommodity_id());
        ps.setInt(3, flavor_commodity.getStock());
        ps.setInt(4, flavor_commodity.getId());
        row = ps.executeUpdate();
        ps.close();
		return row;
	}
		
	public Flavor_commodity findflavor_commodityById(int oid) throws Exception{
		Flavor_commodity flavor_commodity = null;
		Connection connection = DBfactory.openConnection();
		String sql = "select * from tb_flavor_commodity where oid=?";
	        PreparedStatement ps = connection.prepareStatement(sql)	;
	        ps.setInt(1, flavor_commodity.getId());
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	flavor_commodity = new Flavor_commodity();
	        	flavor_commodity.setId(rs.getInt("id"));
	        	flavor_commodity.setFid(rs.getInt("fid"));
	        	flavor_commodity.setCommodity_id(rs.getInt("commodity_id"));
	        	flavor_commodity.setStock(rs.getInt("stock"));

	        }
	        ps.close();		
	        rs.close();	
	        return flavor_commodity;
		}
		

	public List<Flavor_commodity> findAllList() throws Exception{
		List<Flavor_commodity> flavor_commodityList =new ArrayList<Flavor_commodity>();
		Connection connection = DBfactory.openConnection();
		String sql = "select * from tb_flavor_commodity";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
        	Flavor_commodity flavor_commodity = new Flavor_commodity();
        	flavor_commodity.setId(rs.getInt("id"));
        	flavor_commodity.setFid(rs.getInt("fid"));
        	flavor_commodity.setCommodity_id(rs.getInt("commodity_id"));
        	flavor_commodity.setStock(rs.getInt("stock"));
        	flavor_commodityList.add(flavor_commodity);
        }
        ps.close();		
        rs.close();		
		return flavor_commodityList;
	}
	

	
}
