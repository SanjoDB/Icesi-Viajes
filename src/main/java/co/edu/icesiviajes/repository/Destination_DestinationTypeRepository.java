package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Destination_DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface Destination_DestinationTypeRepository extends JpaRepository<Destination_DestinationType, Integer> {

    @Query("SELECT ddt FROM Destination_DestinationType ddt WHERE ddt.destination.id_destination = :id")
    List<Destination_DestinationType> findByDestinationID(@Param("id") Integer id);

    @Query("SELECT ddt FROM Destination_DestinationType ddt WHERE ddt.destinationType.idDesType = :id")
    List<Destination_DestinationType> findByDestinationTypeID(@Param("id") Integer id);

    @Query("SELECT ddt FROM Destination_DestinationType ddt WHERE ddt.destination.id_destination = :desId AND ddt.destinationType.idDesType = :desTyId")
    Destination_DestinationType findByDestinationIDAndDestinatioTypeID(@Param("desId") Integer desId, @Param("desTyId") Integer desTyId);

    @Modifying
    @Query("DELETE FROM Destination_DestinationType ddt WHERE ddt.destination.id_destination = :id")
    void deleteByDestinationID(@Param("id") Integer id);

    @Modifying
    @Query("DELETE FROM Destination_DestinationType ddt WHERE ddt.destinationType.idDesType = :id")
    void deleteByDestinationTypeID(@Param("id") Integer id);

}