package com.stackroute.musicapp.service;

import com.stackroute.musicapp.domain.Track;
import com.stackroute.musicapp.exceptions.TrackDoesNotExistException;
import com.stackroute.musicapp.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws UserAlreadyExistsException;
    public List<Track> getAllTracks();
    public Track getTrack(int trackId)throws TrackDoesNotExistException;
    public boolean removeTrack(int trackId);
    public Track updateTrackComment(Track track);
    public List<Track> getTrackByName(String trackName);

}
