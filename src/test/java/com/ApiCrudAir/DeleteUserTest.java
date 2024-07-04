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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DeleteUserTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void delete_User_Success() {

        Long userId = 1L;
        UserModel user = new UserModel();
        user.setId(userId);
        user.setFirstName("Cristina");
        user.setLastName("Gonzalez");
        user.setEmail("cris.gonz@example.com");


        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        boolean result = userService.deleteUser(userId);

        verify(userRepository).deleteById(userId);

        assertTrue(result, "the elimination was successful");
    }
}


