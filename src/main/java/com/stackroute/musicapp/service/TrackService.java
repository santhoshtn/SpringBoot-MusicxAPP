package com.stackroute.musicapp.service;

import com.stackroute.musicapp.domain.Track;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track);
    public List<Track> getAllTracks();
    public Track getTrack(int trackId);
    public boolean removeTrack(int trackId);
    public Track updateTrackComment(Track track);

}
