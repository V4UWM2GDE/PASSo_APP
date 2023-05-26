package com.passo.controller;

import com.passo.model.UserModel;
import com.passo.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class UserControllerTest {
    @Mock
    UserService userService;

    @Mock
    UserModel userModel;
    @Mock
    HttpServletResponse httpServletResponse;
    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testTudastar() {
        when(userService.authenticate(anyString(), anyString())).thenReturn(new UserModel());

        String result = userController.tudastar(new UserModel(), null);
        Assertions.assertEquals("tudastar", result);
    }


    @Test
    void testNyitooldal() {
        when(userService.authenticate(anyString(), anyString())).thenReturn(new UserModel());

        String result = userController.nyitooldal(new UserModel(), null);
        Assertions.assertEquals("personal_page", result);
    }

    @Test
    void testRegister() {
        when(userService.registerUser(anyString(), anyString(), anyString())).thenReturn(new UserModel());

        String result = userController.register(new UserModel());
        Assertions.assertEquals("error_page", result);
    }

    @Test
    void testLogin() {
        when(userService.authenticate(anyString(), anyString())).thenReturn(new UserModel());

        String result = userController.login(new UserModel(), null, httpServletResponse);
        Assertions.assertEquals("error_page", result);
    }

    @Test
    void testLogin2() {
        when(userService.authenticate(anyString(), anyString())).thenReturn(new UserModel());

        String result = userController.login(new UserModel(), null, httpServletResponse);
        Assertions.assertEquals("personal_page", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme