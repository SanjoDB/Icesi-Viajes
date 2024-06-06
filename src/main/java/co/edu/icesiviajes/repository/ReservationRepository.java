package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Plan_PlanDetail;
import co.edu.icesiviajes.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByClientID(Integer id);

    List<Reservation> findByPlanID(Integer id);

    Reservation findByClientIDAndPlanID(Integer clientId, Integer planId);

    void deleteByClientID(Integer id);

    void deleteByPlanID(Integer id);

}