package com.ApiCrudAir;

import com.ApiCrudAir.Repositories.IUserRepository;
import com.ApiCrudAir.models.UserModel;
import com.ApiCrudAir.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteByIdTest {
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;
    private UserModel user1;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private UserModel user1;
    private UserModel user2;

    @BeforeEach
    public void setUp() {
        user1 = new UserModel();
        user1.setId(1L);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("john.doe@example.com");

        user2 = new UserModel();
        user2.setId(2L);
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.com");
    }
    @Test
    public void deleteUserTest() {
        when(userRepository.existsById(1L)).thenReturn(true);

        Boolean result = userService.deleteUser(1L);

        assertEquals(true, result);
        verify(userRepository).deleteById(1L);
    }


}

