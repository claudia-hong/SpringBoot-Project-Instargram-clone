package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.likes.LikesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LikesService {

	private final LikesRepository likesRepository;
	
	@Transactional
	public void likesImage(int imageId, int principalId) {
		likesRepository.mLikesImage(imageId, principalId);
	}
	
	@Transactional
	public void unLikesImage(int imageId, int principalId) {
		likesRepository.mUnLikesImage(imageId, principalId);
	}

}