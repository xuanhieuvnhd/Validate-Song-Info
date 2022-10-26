package com.controller;

import com.model.Song;
import com.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/index")
    public ModelAndView index(Pageable pageable) {
        Page<Song> songs = songService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/song/index");
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        return new ModelAndView("/song/list", "song", new Song());
    }

    @PostMapping("/song")
    public ModelAndView showResult(@Validated @ModelAttribute Song song, BindingResult result) {
        if (result.hasFieldErrors()) {
            ModelAndView model = new ModelAndView("/song/list");
            model.addAllObjects(result.getModel());
            return model;
        } else {
            songService.save(song);
            ModelAndView model = new ModelAndView("/song/result", "song", song);
            return model;
        }
    }

}
