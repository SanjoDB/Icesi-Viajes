package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DestinationTypeRepository extends JpaRepository<DestinationType, Integer> {



}
