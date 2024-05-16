package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
