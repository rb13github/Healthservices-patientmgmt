package com.healthmgmt.app.service.v2;

import java.util.List;

import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.entity.v2.Patient;
import com.healthmgmt.app.entity.v2.ProductAllocation;
import com.healthmgmt.app.entity.v2.ProductAllocationGroup;


public interface ProductAllocationGroupService {

	//public List<ProductAllocationGroup> groupBy();
	
	public List<ProductAllocationGroup> fetchProductAllocationGroupReport();
	public List<Object[]> groupBy();
	
}
