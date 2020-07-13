package com.healthmgmt.app.service.v2;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.healthmgmt.app.dao.v2.PatientRepository;
import com.healthmgmt.app.dao.v2.ProductAllocationRepository;
import com.healthmgmt.app.dao.v2.ProductAllocationRepositoryDao;
import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.entity.v2.Patient;
import com.healthmgmt.app.entity.v2.ProductAllocation;
import com.healthmgmt.app.entity.v2.ProductAllocationGroup;
import com.healthmgmt.app.mapper.ProductAllocationRowMapper;

@Transactional
@Service("ProductAllocationGroupService")
public class ProductAllocationServiceGroupImpl implements ProductAllocationGroupService {

	@Autowired
	ProductAllocationRepository productAllocationRepository;
	@Autowired
	ProductAllocationRepositoryDao productAllocationRepositoryDao;
	public List<Object[]> groupBy()
	
	{
		return productAllocationRepository.groupBy();
		
	}
	@Override
	public List<ProductAllocationGroup> fetchProductAllocationGroupReport() {
		return productAllocationRepositoryDao.fetchProductAllocationGroupReport();
	
	}
	


	
}
