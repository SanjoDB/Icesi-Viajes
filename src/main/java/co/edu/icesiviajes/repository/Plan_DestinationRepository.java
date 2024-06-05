package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Plan_Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface Plan_DestinationRepository extends JpaRepository<Plan_Destination, Integer> {

    List<Plan_Destination> findByPlanID(Integer id);

    List<Plan_Destination> findByDestinationID(Integer id);

    Plan_Destination findByPlanIDAndDestinatioID(Integer planId, Integer desId);

    void deleteByPlanID(Integer id);

    void deleteByDestinationID(Integer id);

}