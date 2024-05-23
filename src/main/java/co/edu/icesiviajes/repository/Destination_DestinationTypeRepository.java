package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Destination_DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface Destination_DestinationTypeRepository extends JpaRepository<Destination_DestinationType, Integer> {



}
