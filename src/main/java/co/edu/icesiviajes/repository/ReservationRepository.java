package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {



}
