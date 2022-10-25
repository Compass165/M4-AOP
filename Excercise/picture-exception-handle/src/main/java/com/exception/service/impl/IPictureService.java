package com.exception.service.impl;

import com.exception.model.Picture;
import com.exception.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPictureService extends IGeneralService<Picture> {
    //    void updateLike(Long id);
    Page<Picture> findAll(Pageable pageable);
}
