package com.healthmgmt.app.entity.v2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class ProductAllocationGroup {
	

	
	private int buildingNo;
	private String itemCode;
	private int issueQty;
	
	public ProductAllocationGroup()
	{}
	
//	public ProductAllocationGroup(int buildingNo, String itemCode, int issueQty) {
//		super();
//		BuildingNo = buildingNo;
//		ItemCode = itemCode;
//		IssueQty = issueQty;
//	}
	
	public ProductAllocationGroup(int buildingNo, String itemCode, int issueQty) {
		super();
		 this.buildingNo = buildingNo;
		 this.itemCode = itemCode;
		 this.issueQty = issueQty;
	}
	public int getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getIssueQty() {
		return issueQty;
	}
	public void setIssueQty(int issueQty) {
		this.issueQty = issueQty;
	}

}
