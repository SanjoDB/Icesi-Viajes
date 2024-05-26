package co.edu.icesiviajes.repository;

import co.edu.icesiviajes.domain.User;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLoginAndPassword(String login, String password);

    User findByLogin(String login);

    @Query("SELECT u FROM User u WHERE u.first_name LIKE %?1% OR u.last_name LIKE %?1% OR u.login LIKE %?1%")
    public List<User> listAll(String word);

}
