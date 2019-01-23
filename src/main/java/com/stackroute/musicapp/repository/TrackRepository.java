package com.stackroute.musicapp.repository;

import com.stackroute.musicapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

//specifies that this class as repository which has CRUD methods
@Repository
public interface TrackRepository  extends JpaRepository<Track,Integer> {
    //custom query
    @Query(value = "SELECT u FROM Track u WHERE u.trackName=?1")
    List<Track> findTrackByName(String name);
}
