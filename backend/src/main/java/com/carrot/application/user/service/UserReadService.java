package com.carrot.application.user.service;

import com.carrot.application.user.repository.UserRegionRepository;
import com.carrot.application.user.repository.UserRepository;
import com.carrot.presentation.response.UserRegionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserReadService {

    private final UserRepository userRepository;
    private final UserRegionRepository userRegionRepository;


    public List<UserRegionResponse> findRegion(Long userId){
        return userRegionRepository.findByIdAndFetchRegion(userId)
                .stream().map(UserRegionResponse::of)
                .collect(Collectors.toList());
    }


}
