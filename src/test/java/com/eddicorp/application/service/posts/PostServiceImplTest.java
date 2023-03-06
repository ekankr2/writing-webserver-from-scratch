package com.eddicorp.application.service.posts;

import com.eddicorp.application.repository.posts.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PostServiceImplTest {
    @DisplayName("뭔가 테스트 함")
    @Test
    void test() {
        final PostRepository mockPostRepository = mock(PostRepository.class);
        when(mockPostRepository.findAll()).thenReturn(Collections.emptyList());

        // given
        final PostServiceImpl sut = new PostServiceImpl(mockPostRepository);

        // when
        final List<Post> allPosts = sut.getAllPosts();

        // then
        assertTrue(allPosts.isEmpty());
    }
}