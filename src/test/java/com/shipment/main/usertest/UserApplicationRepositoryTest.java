package com.shipment.main.usertest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shipment.main.entity.User;
import com.shipment.main.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserApplicationRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserId("0746");
		user.setName("Rana");
		user.setPassword("0746");
		
		User saveUser = userRepository.save(user);
		User existUser= testEntityManager.find(User.class, saveUser.getId());
		
		assertThat(existUser.getUserId()).isEqualTo(user.getUserId());
	}
	
	@Test
	public void testFindUserByUserId() {
		String userId = "1429";
		User user = userRepository.findByUserId(userId);
		assertThat(user).isNotNull();
	}

}
