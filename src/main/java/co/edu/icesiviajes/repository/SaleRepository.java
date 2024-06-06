package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    List<Sale> findByClientID(Integer id);

    List<Sale> findByPlanID(Integer id);

    Sale findByClientIDAndPlanID(Integer clientId, Integer planId);

    void deleteByClientID(Integer id);

    void deleteByPlanID(Integer id);

}