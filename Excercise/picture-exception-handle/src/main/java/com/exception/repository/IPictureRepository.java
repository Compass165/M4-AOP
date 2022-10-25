package com.exception.repository;

import com.exception.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import javax.transaction.Transactional;

@Transactional
public interface IPictureRepository extends PagingAndSortingRepository<Picture,Long> {
    Page<Picture> findAllByFeedbackContaining(String feedback, Pageable pageable);
}