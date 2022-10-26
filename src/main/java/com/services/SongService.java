package com.services;

import com.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {
    Page<Song> findAll(Pageable pageable);

    Song findById(Long id);

    void save(Song user);

    void remove(Song user);
}
