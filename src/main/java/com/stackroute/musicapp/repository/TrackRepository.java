package com.stackroute.musicapp.repository;

import com.stackroute.musicapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository  extends JpaRepository<Track,Integer> {
    @Query(value = "SELECT u FROM Track u WHERE u.trackName=?1")
    List<Track> findTrackByName(String name);
}
