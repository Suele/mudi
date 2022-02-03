package com.world.mudi.repository;

import com.world.mudi.model.ProductModel;
import com.world.mudi.model.StateDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Suele Guimaraes
 * Como está interface extende outra interface que tem diversos metodos para consultar e persistir dados
 * alguns metodos não são necessarios serem implementados.
 */

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
	@Query(value = "SELECT p FROM ProductEntity p JOIN p.user u WHERE u.username = :username")
	public List<ProductModel> findAllByUser(@Param("username") String username);

	@Query(value = " SELECT * FROM product p WHERE p.state_delivery = :stateDelivery ", nativeQuery = true)
	public List<ProductModel> findAllStateDelivery(@Param("stateDelivery") String stateDelivery);

	@Query(value = "SELECT p FROM ProductEntity p JOIN p.user u WHERE u.username = :username AND p.stateDelivery = :statusRequest")
	public List<ProductModel> findAllStatusRequestAndUser(@Param("statusRequest") StateDelivery statusRequest, @Param("username") String username);
}