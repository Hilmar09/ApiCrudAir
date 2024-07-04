package com.ApiCrudAir;


import com.ApiCrudAir.Repositories.IUserRepository;
import com.ApiCrudAir.models.UserModel;
import com.ApiCrudAir.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GetUserByIdTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;
    private UserModel user1;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user1 = new UserModel();
        user1.setId(1L);
        user1.setFirstName("Cristina");
        user1.setLastName("Gonzalez");
        user1.setEmail("Cris.Gonz@example.com");
    }
    @Test
    public void getByIdTest() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        Optional<UserModel> result = userService.getById(1L);

        assertEquals(user1, result.get());
        verify(userRepository).findById(1L);
    }

}
