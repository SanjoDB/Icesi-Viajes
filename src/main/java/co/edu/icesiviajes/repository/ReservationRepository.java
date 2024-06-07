package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Plan_PlanDetail;
import co.edu.icesiviajes.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r FROM Reservation r WHERE r.client.id_client = :id")
    List<Reservation> findByClientID(@Param("id") Integer id);

    @Query("SELECT r FROM Reservation r WHERE r.plan.id_plan = :id")
    List<Reservation> findByPlanID(@Param("id") Integer id);

    @Query("SELECT r FROM Reservation r WHERE r.client.id_client = :clientId AND r.plan.id_plan = :planId")
    Reservation findByClientIDAndPlanID(@Param("clientId") Integer clientId, @Param("planId") Integer planId);

    @Modifying
    @Query("DELETE FROM Reservation r WHERE r.client.id_client = :id")
    void deleteByClientID(@Param("id") Integer id);

    @Modifying
    @Query("DELETE FROM Reservation r WHERE r.plan.id_plan = :id")
    void deleteByPlanID(@Param("id") Integer id);

    @Query("SELECT r.reserved, r.plan.price FROM Reservation r WHERE r.reserved >= :startOfWeek AND r.reserved <= :endOfWeek GROUP BY r.reserved, r.plan.price")
    List<Object> findWeeklyReservations(@Param("startOfWeek") LocalDateTime startOfWeek, @Param("endOfWeek") LocalDateTime endOfWeek);

    @Query("SELECT r.client.first_name, r.plan.name, r.reserved FROM Reservation r ORDER BY r.reserved DESC LIMIT 5")
    List<Object[]> findLatestReservations();

}