package com.healthmgmt.app.entity.v2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity 
@Table(name="ProductAllocation",schema="public")
public class ProductAllocation {

	
//	"ItemtransId" integer NOT NULL,
//    "ItemCode" text COLLATE pg_catalog."default",
//    "IssueQty" integer,
//    "BuildingNo" integer,
//    "IssueDate" date,
//    "IssueBy" integer,
//    "ItemId" integer,
    @Id
	@Column (name="ItemtransId")
	private Long itemtransId;
	
	
	@Column (name="ItemCode")
	private String itemCode;
	
	@Column (name="IssueQty") 
	private int issueQty;
	
	@Column (name="BuildingNo") 
	private int buildingNo;
	@Column (name="IssueDate")
	private Date issuDate;
	
	@Column (name="IssueBy")
	private int issueBy;
	
	@Column (name="ItemId")
    private int itemId;
    
	public Long getItemtransId() {
		return itemtransId;
	}

	public void setItemtransId(Long itemtransId) {
		this.itemtransId = itemtransId;
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

	public int getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	public Date getIssuDate() {
		return issuDate;
	}

	public void setIssuDate(Date issuDate) {
		this.issuDate = issuDate;
	}

	public int getIssueBy() {
		return issueBy;
	}

	public void setIssueBy(int issueBy) {
		this.issueBy = issueBy;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


}
