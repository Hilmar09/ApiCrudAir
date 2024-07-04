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

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


public class SaveUserTest {

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
    public void saveUserTest() {
        when(userRepository.save(user1)).thenReturn(user1);

        UserModel result = userService.saveUser(user1);

        assertEquals(user1, result);
        verify(userRepository).save(user1);
    }


}
