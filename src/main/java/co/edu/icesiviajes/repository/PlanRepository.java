package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query("SELECT p FROM Plan p")
    List<Plan> findAllPlans();


}
