package com.pack.SpringBootRoleBasedSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pack.SpringBootRoleBasedSecurity.model.Product;
@Repository
public interface ProductRepsitory extends JpaRepository<Product, Long> {

	@Modifying
	@Query("UPDATE Product p set p.status=:status WHERE p.id=:prod_id")
	void update(@Param("prod_id") long prod_id,@Param("status") String status);

	@Modifying
	@Query("UPDATE Product p set p.Payment=:string WHERE p.id=:prod_id")
	void updatePayment(@Param("prod_id") long prod_id, @Param("string") String string);

}
