package com.stackroute.musicapp.repository;

import com.stackroute.musicapp.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//specifies that this class as repository which has CRUD methods
@Repository
public interface TrackRepository  extends MongoRepository<Track,Integer> {
}
