package com.exception.service.impl;

import com.exception.model.Picture;
import com.exception.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PictureService implements IPictureService {
    @Autowired
    IPictureRepository pictureRepository;

    @Override
    public Iterable<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(Long id) {
        return pictureRepository.findOne(id);
    }

    @Override
    public void save(Picture model) throws Exception {
        PictureService pictureService = new PictureService();
        if (pictureService.checkFeedback(model.getFeedback())) {
            pictureRepository.save(model);
        } else {
            throw new Exception("Can't add this feedback: "+model.getAuthor()+", "+model.getFeedback()+", "+ LocalDateTime.now());
        }
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Picture> findAll(Pageable pageable) {
        return null;
    }

    public boolean checkFeedback(String feedback) {
        ArrayList<String > myString = null;
        String[] myString2 = {"fuck","damned","Uppy","dirty pig","Fuck you","ass","cunt","porn"};
        for (String str : myString2) {
            if (feedback.contains(str)) {
                return false;
            }
        }
                return true;
    }

}
