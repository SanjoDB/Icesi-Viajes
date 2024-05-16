package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {



}