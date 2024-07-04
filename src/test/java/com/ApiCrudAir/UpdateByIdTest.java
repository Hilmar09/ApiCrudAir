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
    public void update_User_Test() {
        UserModel user = new UserModel();
        user.setId(1L);
        user.setFirstName("Cristina");
        user.setLastName("Gonzalez");
        user.setEmail("cris.gonz@example.com");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        UserModel updatedUser = new UserModel();
        updatedUser.setFirstName("Julia");
        updatedUser.setLastName("Perez");
        updatedUser.setEmail("julia.p@example.com");

        userService.updateById(updatedUser, user.getId());

        assertEquals("Julia", user.getFirstName());
        assertEquals("Perez", user.getLastName());
        assertEquals("julia.p@example.com", user.getEmail());
    }
}

