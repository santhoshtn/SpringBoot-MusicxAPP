package com.stackroute.musicapp.repository;

import com.stackroute.musicapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository  extends JpaRepository<Track,Integer> {
}
