package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Plan_Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface Plan_DestinationRepository extends JpaRepository<Plan_Destination, Integer> {

    @Query("SELECT pd FROM Plan_Destination pd WHERE pd.plan.id_plan = :id")
    List<Plan_Destination> findByPlanID(@Param("id") Integer id);

    @Query("SELECT pd FROM Plan_Destination pd WHERE pd.destination.id_destination = :id")
    List<Plan_Destination> findByDestinationID(@Param("id") Integer id);

    @Query("SELECT pd FROM Plan_Destination pd WHERE pd.plan.id_plan = :planId AND pd.destination.id_destination = :desId")
    Plan_Destination findByPlanIDAndDestinatioID(@Param("planId") Integer planId, @Param("desId") Integer desId);

    @Modifying
    @Query("DELETE FROM Plan_Destination pd WHERE pd.plan.id_plan = :id")
    void deleteByPlanID(@Param("id") Integer id);

    @Modifying
    @Query("DELETE FROM Plan_Destination pd WHERE pd.destination.id_destination = :id")
    void deleteByDestinationID(@Param("id") Integer id);

}