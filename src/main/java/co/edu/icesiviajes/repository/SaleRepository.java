package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface SaleRepository extends JpaRepository<Sale, Integer> {


    @Query("SELECT s FROM Sale s WHERE s.client.id_client = :id")
    List<Sale> findByClientID(@Param("id") Integer id);

    @Query("SELECT s FROM Sale s WHERE s.plan.id_plan = :id")
    List<Sale> findByPlanID(@Param("id") Integer id);

    @Query("SELECT s FROM Sale s WHERE s.client.id_client = :clientId AND s.plan.id_plan = :planId")
    Sale findByClientIDAndPlanID(@Param("clientId") Integer clientId, @Param("planId") Integer planId);

    @Modifying
    @Query("DELETE FROM Sale s WHERE s.client.id_client = :id")
    void deleteByClientID(@Param("id") Integer id);

    @Modifying
    @Query("DELETE FROM Sale s WHERE s.plan.id_plan = :id")
    void deleteByPlanID(@Param("id") Integer id);

}