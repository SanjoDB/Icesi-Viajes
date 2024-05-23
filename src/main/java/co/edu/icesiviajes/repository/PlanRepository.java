package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query("SELECT p FROM Plan p WHERE p.name LIKE %?1% OR p.code LIKE %?1%")
    public List<Plan> listAll(String word);

    @Query("SELECT p FROM Plan p")
    List<Plan> findAllPlans();

}
