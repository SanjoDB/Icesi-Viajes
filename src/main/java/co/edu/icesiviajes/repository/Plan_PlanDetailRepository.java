package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Plan_PlanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Plan_PlanDetailRepository extends JpaRepository<Plan_PlanDetail, Integer> {

    @Query("SELECT p FROM Plan_PlanDetail p WHERE p.plan.id_plan = :id")
    List<Plan_PlanDetail> findByPlan_Id(@Param("id") Integer id);

    @Query("SELECT p FROM Plan_PlanDetail p WHERE p.planDetail.id_planDetail = :id")
    List<Plan_PlanDetail> findByPlanDetail_Id(@Param("id") Integer id);

    @Query("SELECT p FROM Plan_PlanDetail p WHERE p.plan.id_plan = :planId AND p.planDetail.id_planDetail = :planDetailId")
    Plan_PlanDetail findByPlan_IdAndPlanDetail_Id(@Param("planId") Integer planId, @Param("planDetailId") Integer planDetailId);

    @Modifying
    @Query("DELETE FROM Plan_PlanDetail p WHERE p.planDetail.id_planDetail = :id")
    void deleteByPlanDetail_Id(@Param("id") Integer id);

    @Modifying
    @Query("DELETE FROM Plan_PlanDetail p WHERE p.plan.id_plan = :id")
    void deleteByPlan_Id(@Param("id") Integer id);
}