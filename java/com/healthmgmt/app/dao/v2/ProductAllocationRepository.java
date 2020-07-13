package com.healthmgmt.app.dao.v2;

import java.util.List;



import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.entity.v2.ProductAllocation;
import com.healthmgmt.app.entity.v2.ProductAllocationGroup;
import com.healthmgmt.app.mapper.ProductAllocationRowMapper;

@Transactional
@Repository("productAllocationRepository")
public interface  ProductAllocationRepository extends CrudRepository<ProductAllocation, Long>{

//   @Autowired
//    private SessionFactory sessionFactory;
//	
//	 public List<ProductAllocation> getProductAllocationList(String orderId) {
//         String sql = "Select public. " + ProductAllocation.class.getName() //
//                 + "(d.ItemtransId, d.ItemCode, d.IssueQty , d.BuildingNo,d.IssueBy,d.ItemId) "//
//                 + " from " + ProductAllocation.class.getName() + " d "//
//                 + " where d.ItemtransId = :ItemtransId ";
//  
//         Session session = this.sessionFactory.getCurrentSession();
//         Query<ProductAllocation> query = session.createQuery(sql, ProductAllocation.class);
//         query.setParameter("ItemtransId", orderId);
//         
//         
//         
//         return query.getResultList();
//     }
	 
//	@Query(value = "SELECT c.year AS yearComment, COUNT(c.*) AS totalComment "
//			  + "FROM comment AS c GROUP BY c.year ORDER BY c.year DESC", nativeQuery = true)
	
//	public static  String  sql = "Select public. " + ProductAllocation.class.getName() //
//          + "( d.ItemCode, d.IssueQty , d.BuildingNo) "//
//          + " from " + ProductAllocation.class.getName() + " d "//
//          + " group by d.BuildingNo ";
//			
//	 @Query("select new com.demo.entities.CategoryGroup(p.category.id as categoryId, "
//				+ "min(p.price) as minPrice, "
//				+ "max(p.price) as maxPrice, "
//				+ "sum(p.quantity) as sumQuantity, "
//				+ "count(p.id) as countProduct, "
//				+ "avg(p.price) as avgPrice) "
//				+ "from Product p "
//				+ "group by p.category.id")	 
	
//	@Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
//    List<Article> fetchArticles(@Param("title") String title, @Param("category") String category);

	
	//@Query("select  \"BuildingNo\",\"ItemCode\",SUM (\"IssueQty\") from public.\"ProductAllocation\"   group by \"BuildingNo\",\"ItemCode\" ")
	
	//@Query("select new com.healthmgmt.app.entity.v2.ProductAllocationGroup('BuildingNo','ItemCode',SUM ('IssueQty') from ProductAllocation group by 'BuildingNo','ItemCode')")
	//@Query(sql)
	//@Query("select 'BuildingNo','ItemCode',SUM ('IssueQty') from ProductAllocation group by 'BuildingNo','ItemCode'")
	 
//	@Repository
//	public interface ExpenseRepo extends JpaRepository<Expense,Long> {
//	    List<Expense> findByCategoryId(Long categoryId);
//
//	    @Query(value = "select category.name,SUM(expense.amount) from expense JOIN category ON expense.category_id=category.id GROUP BY expense.category_id",nativeQuery = true)
//	    List<?> getAmountByCategory();
//
//	}
	
//	@Query("SELECT AVG(u.age) from User u")
//    int getAverageAge();
//
//    @Query(value = "SELECT max(age) from User where first_name <> ?1", nativeQuery = true)
//    int getMaxAgeMinus(String name);
	
//	 @Query(value = "select top 5 p.*, sum(po.quantity) as total_quantity from product p " +
//		        "inner join productorder po " +
//		            "on p.id = po.product_id " +
//		        "group by p.id, p.name " +
//		        "order by total_quantity desc", nativeQuery = true)
	 
		    //List<Product> findTopFiveBestSeller();
    
//	@Query(value="SELECT" + 
//	              " new com.healthmgmt.app.entity.v2.rbproductallocation(pag.buildingNo,pag.itemCode,pag.issueQty) " + 
//			     "FROM" + 
//	             " rbproductallocation pag "+
//	             "GROUP BY "+
//			     "  pag.buildingNo",nativeQuery = false)
//	
//	@Query(value="SELECT" + 
//    " pag.BuildingNo,pag.ItemCode,pag.IssueQty " + 
//   "FROM" + 
//   " public.\"rbproductallocation\" pag "+
//   "GROUP BY "+
//   "  pag.BuildingNo",nativeQuery = true)
	
	//public List<ProductAllocationGroup> groupBy();
	
	@Query(value="SELECT pag.\"BuildingNo\",pag.\"ItemCode\",pag.\"IssueQty\" FROM public.\"rbproductallocation\" pag GROUP BY  pag.\"BuildingNo\"",nativeQuery = true)
	public List<Object[]> groupBy();
	
	//(Long id, String name, String brand, String madein, float price)
	//@Query(value="select new com.healthmgmt.app.entity.Product(id,name,brand,madein,price) from product",nativeQuery = true)
	//public List<Product> groupBy();
	
		
}
