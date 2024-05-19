package co.edu.icesiviajes;

import co.edu.icesiviajes.domain.User;
import co.edu.icesiviajes.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IcesiViajesApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	void contextLoads() {

	}

}
