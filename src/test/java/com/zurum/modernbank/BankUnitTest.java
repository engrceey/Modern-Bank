package com.zurum.modernbank;


import com.zurum.modernbank.controller.UserController;
import com.zurum.modernbank.dto.UserRegistrationDto;
import com.zurum.modernbank.dto.UserUpdateDto;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BankUnitTest {

    @InjectMocks
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountRepository accountRepository;

    MockMvc mockMvc;

    UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
    User userRegistrationResponse = new User();
    UserUpdateDto userUpdateDto = new UserUpdateDto();
    User updateResponse = new User();
    User dbUser = new User();


    @Before
    public void setUp() {
        setUserRegistrationDto(userRegistrationDto);
        setUserRegistrationResponse(userRegistrationDto);
        mockUser(dbUser);
        setUserUpdateRequestDto(userUpdateDto);
        setUserUpdateResponseDto(updateResponse);

        mockMvc = standaloneSetup(userController).build();
    }

    @Test
    public void registerUser() throws Exception {
        when(userRepository.save(any(User.class))).thenReturn(userRegistrationResponse);

//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/user/registration"))
//                .andExpect(status().isOk());

        User user = userService.registerUser(userRegistrationDto);
        assertEquals("guy", user.getUsername());
        assertEquals("ladies", user.getLastName());
        assertEquals("ceey@gmail", user.getEmail());
        assertEquals("flourish", user.getFirstName());
        assertNotNull(user);
    }

    @Test
    public void updateUser() throws Exception {
       Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.of(dbUser));
        when(userRepository.save(any(User.class))).thenReturn(updateResponse);

//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/update/user/{id}"))
//                .andExpect(status().isOk());

        User user = userService.updateUser(dbUser.getUser_id(), userUpdateDto);
        assertEquals("onGod", user.getFirstName());
    }

    private void setUserRegistrationDto(UserRegistrationDto userRegistrationDto) {
        userRegistrationDto.setUsername("guy");
        userRegistrationDto.setLastName("ladies");
        userRegistrationDto.setFirstName("flourish");
        userRegistrationDto.setEmail("ceey@gmail");
        userRegistrationDto.setPassword("password");
        userRegistrationDto.setRetypePassword("password");
        userRegistrationDto.setDob(new Date());
    }

    private void setUserRegistrationResponse(UserRegistrationDto userRegistrationDto) {
        userRegistrationResponse.setUsername(userRegistrationDto.getUsername());
        userRegistrationResponse.setLastName(userRegistrationDto.getLastName());
        userRegistrationResponse.setFirstName(userRegistrationDto.getFirstName());
        userRegistrationResponse.setEmail(userRegistrationDto.getEmail());
        userRegistrationResponse.setDob(new Date());
    }

    private void mockUser(User dbUser) {
        dbUser.setFirstName("onGod");
        dbUser.setUser_id(2L);
        dbUser.setLastName("zurum");
        dbUser.setPassword(passwordEncoder.encode("password"));
        dbUser.setUsername("chi");
        dbUser.setDob(new Date());
    }

    private void setUserUpdateRequestDto(UserUpdateDto userUpdateDto) {
        userUpdateDto.setFirstName("onGod");
        userUpdateDto.setLastName("zurum");
        userUpdateDto.setUsername("chi");
    }

    private void setUserUpdateResponseDto(User updateResponse) {
        updateResponse.setFirstName("onGod");
        updateResponse.setLastName("zurum");
        updateResponse.setUsername("chi");
    }
}
