package com.ApiCrudAir;

import com.ApiCrudAir.Repositories.IUserRepository;
import com.ApiCrudAir.models.UserModel;
import com.ApiCrudAir.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GetUserTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private UserModel user1;
    private UserModel user2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        user1 = new UserModel();
        user1.setId(1L);
        user1.setFirstName("Cristina");
        user1.setLastName("Gonzalez");
        user1.setEmail("Cris.Gonz@example.com");

        user2 = new UserModel();
        user2.setId(2L);
        user2.setFirstName("Julia");
        user2.setLastName("Perez");
        user2.setEmail("julia.P@example.com");
    }
    @Test
    public void get_Users_Test() {
        List<UserModel> userList = new ArrayList<>(Arrays.asList(user1, user2));

        when(userRepository.findAll()).thenReturn(userList);

        List<UserModel> result = userService.getUsers();

        assertEquals(2, result.size());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
        verify(userRepository).findAll();
    }
}


