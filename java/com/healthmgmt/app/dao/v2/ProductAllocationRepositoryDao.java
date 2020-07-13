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


@Repository
public class  ProductAllocationRepositoryDao {

	NamedParameterJdbcTemplate template; 
	
	public ProductAllocationRepositoryDao(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	 

	
	public List<ProductAllocationGroup> fetchProductAllocationGroupReport() {
		//return template.query("SELECT pag.\"BuildingNo\",pag.\"ItemCode\",pag.\"IssueQty\" FROM public.\"ProductAllocation\" pag GROUP BY  pag.\"BuildingNo\"", new ProductAllocationRowMapper());
		
		return template.query("SELECT pag.\"BuildingNo\",pag.\"ItemCode\", SUM(pag.\"IssueQty\") as \"IssueQty\"  FROM public.\"ProductAllocation\" pag GROUP BY  pag.\"BuildingNo\",pag.\"ItemCode\"" , new ProductAllocationRowMapper());
		
		//return template.query("SELECT pag.\"BuildingNo\",pag.\"ItemCode\", pag.\"IssueQty\"  FROM public.\"ProductAllocation\" pag ORDER BY pag.\"BuildingNo\"", new ProductAllocationRowMapper());
	}
		
}

/*
 * 
 * Group by using having 
 SELECT c.currency, SUM(c.population)
FROM Country c
WHERE 'Europe' MEMBER OF c.continents
GROUP BY c.currency
HAVING COUNT(c) > 1



-----------------


JPQL supports the five aggregate functions of SQL:

    COUNT - returns a long value representing the number of elements.
    SUM - returns the sum of numeric values.
    AVG - returns the average of numeric values as a double value.
    MIN - returns the minimum of comparable values (numeric, strings, dates).
    MAX - returns the maximum of comparable values (numeric, strings, dates).


------------------------------------------


@Entity
@Data
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    private long id;
    private String firstName;
    private int age;

    public User(String first, int age) {
        this.firstName = first;
        this.age = age;
    }

}
=======
import com.therealdanvega.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT AVG(u.age) from User u")
    int getAverageAge();

    @Query(value = "SELECT max(age) from User where first_name <> ?1", nativeQuery = true)
    int getMaxAgeMinus(String name);

}
 */
