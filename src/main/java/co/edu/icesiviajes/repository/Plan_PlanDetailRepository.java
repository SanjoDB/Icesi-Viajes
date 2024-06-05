package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Plan_PlanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface Plan_PlanDetailRepository extends JpaRepository<Plan_PlanDetail, Integer> {

    List<Plan_PlanDetail> findByPlanID(Integer id);

    List<Plan_PlanDetail> findByPlanDetailID(Integer id);

    Plan_PlanDetail findByPlanIDAndPlanDetailID(Integer planId, Integer planDeId);

    void deleteByPlanID(Integer id);

    void deleteByPlanDetailID(Integer id);

}