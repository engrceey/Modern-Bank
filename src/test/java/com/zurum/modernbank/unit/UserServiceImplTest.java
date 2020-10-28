//package com.zurum.modernbank.unit;
//
//import com.zurum.modernbank.service.implementation.AccountServiceImpl;
//import com.zurum.modernbank.service.implementation.UserServiceImpl;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
////@ExtendWith(MockitoExtension.class)
////@RunWith(MockitoJUnitRunner.class)
//public class UserServiceImplTest {
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @Mock
//    private AccountServiceImpl accountService;
//
//    @Test
//    public void fullName() {
//        //Arrange & Act
//        String fullName = userService.fullName("John", "Doe");
//        //Action
//        assertEquals("John Doe", fullName);
//    }
//}
