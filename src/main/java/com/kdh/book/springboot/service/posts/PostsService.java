package com.kdh.book.springboot.service.posts;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kdh.book.springboot.domain.posts.Posts;
import com.kdh.book.springboot.domain.posts.PostsRepository;
import com.kdh.book.springboot.web.dto.PostsListResponseDto;
import com.kdh.book.springboot.web.dto.PostsResponseDto;
import com.kdh.book.springboot.web.dto.PostsSaveRequestDto;
import com.kdh.book.springboot.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestsDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() ->
			new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

		posts.update(requestsDto.getTitle(), requestsDto.getContent());

		return id;
	}

	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(() ->
			new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

		return new PostsResponseDto(entity);
	}

	@Transactional
	public List<PostsListResponseDto> findAllDesc() {
		return postsRepository.findAllDesc().stream()
			.map(PostsListResponseDto::new)
			.collect(Collectors.toList());
	}

	@Transactional
	public void delete(Long id) {
		Posts posts = postsRepository.findById(id).orElseThrow(() ->
			new IllegalArgumentException("해당 게시글이 없습니다 id = " + id));

		postsRepository.delete(posts);
	}
}
