package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE c.first_name LIKE %?1% OR c.last_name LIKE %?1% OR c.id_number LIKE %?1%")
    public List<Client> listAll(String word);

}