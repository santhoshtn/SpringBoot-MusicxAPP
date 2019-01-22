package com.stackroute.musicapp.service;

import com.stackroute.musicapp.domain.Track;
import com.stackroute.musicapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public Track saveTrack(Track track){
    Track savedTrack= trackRepository.save(track);
    return savedTrack;
    }
    @Override
    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }
    @Override
    public boolean removeTrack(int id){
    trackRepository.deleteById(id);
    return true;
    }
    @Override
    public Track updateTrackComment(Track track){
        Track updateTrack=trackRepository.save(track);
        return updateTrack;
    }
    @Override
    public Track getTrack(int trackId){
        Optional<Track> track= trackRepository.findById(trackId);
        return track.get();
    }
}