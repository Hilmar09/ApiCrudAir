package com.ApiCrudAir;

import com.ApiCrudAir.Repositories.IUserCommentRepository;
import com.ApiCrudAir.models.UserCommentModel;

import com.ApiCrudAir.service.UserCommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserCommentTest {

    @Mock
    private IUserCommentRepository userCommentRepository;

    @InjectMocks
    private UserCommentService userCommentService;

    private UserCommentModel userComment;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        userComment = new UserCommentModel();
        userComment.setId(1L);
        userComment.setUser(1L);
        userComment.setCiudad("Madrid");
        userComment.setCalidadAire(75L);
        userComment.setVive(true);
        userComment.setValoracion(5);
        userComment.setComentario("Good air quality");
    }

    @Test
    public void test_Get_Users_Comment_By_User() {
        ArrayList<UserCommentModel> userComments = new ArrayList<>();
        userComments.add(userComment);

        when(userCommentRepository.findByUser(1L)).thenReturn(userComments);

        ArrayList<UserCommentModel> result = userCommentService.getUsersCommentByUser(1L);

        assertEquals(1, result.size());
        assertEquals(userComment, result.get(0));
    }

    @Test
    public void test_Save_Comment_User() {
        when(userCommentRepository.save(userComment)).thenReturn(userComment);

        UserCommentModel result = userCommentService.saveCommentUser(userComment);

        assertEquals(userComment, result);
        verify(userCommentRepository).save(userComment);
    }

    @Test
    public void test_Get_Comment_Random() {
        ArrayList<UserCommentModel> userComments = new ArrayList<>();
        userComments.add(userComment);

        when(userCommentRepository.findAll()).thenReturn(userComments);

        ArrayList<UserCommentModel> result = userCommentService.getCommentRandom();

        assertEquals(1, result.size());
        assertEquals(userComment, result.get(0));
    }

    @Test
    public void test_Update_User_Commit_By_Id() {
        UserCommentModel updatedComment = new UserCommentModel();
        updatedComment.setId(1L);
        updatedComment.setCiudad("Barcelona");
        updatedComment.setCalidadAire(50L);
        updatedComment.setVive(false);
        updatedComment.setValoracion(3);
        updatedComment.setComentario("Average air quality");

        when(userCommentRepository.findById(1L)).thenReturn(Optional.of(userComment));
        when(userCommentRepository.save(userComment)).thenReturn(userComment);

        UserCommentModel result = userCommentService.updateUserCommitById(updatedComment);

        assertEquals("Barcelona", result.getCiudad());
        assertEquals(50L, result.getCalidadAire());
        assertEquals(false, result.getVive());
        assertEquals(3, result.getValoracion());
        assertEquals("Average air quality", result.getComentario());
    }

    @Test
    public void test_Delete_User_Comment() {
        doNothing().when(userCommentRepository).deleteById(1L);

        boolean result = userCommentService.deleteUserComment(1L);

        assertTrue(result);
        verify(userCommentRepository).deleteById(1L);
    }

    @Test
    public void test_Delete_User_Comment_Failure() {
        doThrow(new RuntimeException("Error deleting")).when(userCommentRepository).deleteById(1L);

        boolean result = userCommentService.deleteUserComment(1L);

        assertFalse(result);
        verify(userCommentRepository).deleteById(1L);
    }
}

