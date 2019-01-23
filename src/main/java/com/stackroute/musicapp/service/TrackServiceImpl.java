package com.stackroute.musicapp.service;

import com.stackroute.musicapp.domain.Track;
import com.stackroute.musicapp.exceptions.TrackDoesNotExistException;
import com.stackroute.musicapp.exceptions.UserAlreadyExistsException;
import com.stackroute.musicapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//specifies this class as service class
@Service
public class TrackServiceImpl implements TrackService{

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    //implementation of save track
    @Override
    public Track saveTrack(Track track) throws UserAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new UserAlreadyExistsException("Track "+track.getTrackId()+" already exists");
        }
        Track savedTrack= trackRepository.save(track);
        return savedTrack;
    }

    //implementation of get all tracks
    @Override
    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }

    //implementation of remove a track from list
    @Override
    public boolean removeTrack(int id){
        trackRepository.deleteById(id);
        return true;
    }

    //implementation of update track comment
    @Override
    public Track updateTrackComment(int trackId,String trackComment) throws TrackDoesNotExistException{
        Optional<Track> fetchedTrack= trackRepository.findById(trackId);
        if(!trackRepository.existsById(trackId)){
            throw new TrackDoesNotExistException("Track "+trackId+" does not exist!");
        }
        fetchedTrack.get().setTrackComment(trackComment);
        Track updateTrack=trackRepository.save(fetchedTrack.get());
        return updateTrack;
    }

    //implementation of get track
    @Override
    public Optional<Track> getTrack(int trackId)throws TrackDoesNotExistException {

        Optional<Track> track= trackRepository.findById(trackId);
        if(!trackRepository.existsById(trackId)){
            throw new TrackDoesNotExistException("Track "+trackId+" does not exsit!");
        }
        //    Optional<Track> track= trackRepository.findById(trackId);
        return track;
    }

//    @Override
//    public List<Track>  getTrackByName(String trackName){
//        return trackRepository.findTrackByName(trackName);
//    }
}