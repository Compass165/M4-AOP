package com.exception.controller;

import com.exception.model.Picture;
import com.exception.service.impl.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private IPictureService pictureService;

    @GetMapping
    public ModelAndView showPicture(@PageableDefault(size = 3,direction = Sort.Direction.ASC,sort = "id") Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("daysPicture");
//        modelAndView.addObject("comment",timeConvert());
        modelAndView.addObject("comment",pictureService.findAll(pageable));
        modelAndView.addObject("picture",new Picture());
        return modelAndView;
    }


    @PostMapping("/save")
    public String savePicture(Picture picture, RedirectAttributes redirectAttributes) {
        try {
            pictureService.save(picture);
            redirectAttributes.addFlashAttribute("success", "Add comment successfully");
            return "redirect:/pictures";
        } catch (Exception e) {
            return "error-404";
        }
    }
    @GetMapping("/like/{id}")
    public String likePicture(@PathVariable Long id) throws Exception {
        Picture picture = pictureService.findById(id);
        try {
            pictureService.save(setLikePicture(picture));
            return "redirect:/pictures";
        }catch (Exception e){
            return "error-404";
        }
    }

    public Picture setLikePicture(Picture picture){
        picture.setLikes(picture.getLikes()+1);
        return picture;
    }
}
