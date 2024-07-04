package com.ApiCrudAir;


import com.ApiCrudAir.Repositories.IUserRepository;
import com.ApiCrudAir.models.UserModel;
import com.ApiCrudAir.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UpdateByIdTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void updateUserTest() {
        UserModel user = new UserModel();
        user.setId(1L);
        user.setFirstName("Cristina");
        user.setLastName("Gonzalez");
        user.setEmail("cris.gonz@example.com");
        user.setAllergic(true);
        user.setPassword("Password");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        UserModel updatedUser = new UserModel();

        updatedUser.setFirstName("Julia");
        updatedUser.setLastName("Perez");
        updatedUser.setEmail("julia.p@example.com");
        updatedUser.setAllergic(true);
        updatedUser.setPassword("Password2");

        userService.updateById(updatedUser, user.getId());

        assertEquals("Julia", updatedUser.getFirstName());
        assertEquals("Perez", updatedUser.getLastName());
        assertEquals("julia.p@example.com", updatedUser.getEmail());
        assertEquals(true, updatedUser.getAllergic());
        assertEquals("Password2", updatedUser.getPassword());
    }
}

