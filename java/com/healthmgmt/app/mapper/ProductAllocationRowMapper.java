package com.healthmgmt.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Column;

import org.springframework.jdbc.core.RowMapper;

import com.healthmgmt.app.entity.v2.ProductAllocation;
import com.healthmgmt.app.entity.v2.ProductAllocationGroup;

public class ProductAllocationRowMapper implements RowMapper<ProductAllocationGroup> {

	@Override
	public ProductAllocationGroup mapRow(ResultSet rs, int arg1) throws SQLException {
		ProductAllocationGroup productAllocationGroup = new ProductAllocationGroup();
		productAllocationGroup.setBuildingNo(rs.getInt("BuildingNo"));
	  productAllocationGroup.setIssueQty(rs.getInt("IssueQty"));
	  productAllocationGroup.setItemCode(rs.getString("ItemCode"));
 
        return productAllocationGroup;
	}

	
}