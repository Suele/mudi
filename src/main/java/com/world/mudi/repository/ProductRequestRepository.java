package com.world.mudi.repository;

import com.world.mudi.model.ProductRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Suele Guimaraes
 * Como está interface extende outra interface que tem diversos metodos para consultar e persistir dados
 * alguns metodos não são necessarios serem implementados.
 */

@Repository
public interface ProductRequestRepository extends JpaRepository<ProductRequestModel, Long> {
}