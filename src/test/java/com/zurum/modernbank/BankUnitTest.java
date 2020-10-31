package com.zurum.modernbank;


import com.zurum.modernbank.dto.UserRegistrationDto;
import com.zurum.modernbank.entity.User;
import com.zurum.modernbank.repository.AccountRepository;
import com.zurum.modernbank.repository.UserRepository;
import com.zurum.modernbank.service.implementation.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BankUnitTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountRepository accountRepository;

    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    User userResponse = new User();

    @Before
    public void setUp() {
        userRegistrationDto.setUsername("guy");
        userRegistrationDto.setLastName("ladies");
        userRegistrationDto.setFirstName("flourish");
        userRegistrationDto.setEmail("ceey@gmail");
        userRegistrationDto.setPassword("password");
        userRegistrationDto.setRetypePassword("password");
        userRegistrationDto.setDob(new Date());

        userResponse.setUsername("guy");
        userResponse.setLastName("ladies");
        userResponse.setFirstName("flourish");
        userResponse.setEmail("ceey@gmail");
        userResponse.setPassword("password");
        userResponse.setDob(new Date());
    }

    @Test
    public void registerUser() {
        when(userRepository.save(any(User.class))).thenReturn(userResponse);

        User user = userService.registerUser(userRegistrationDto);
        assertEquals("guy", user.getUsername());
        assertEquals("ladies", user.getLastName());
        assertEquals("ceey@gmail", user.getEmail());
        assertEquals("flourish", user.getFirstName());
        assertNotNull(user);
    }
}
