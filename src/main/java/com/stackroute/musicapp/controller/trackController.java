package com.stackroute.musicapp.controller;

import com.stackroute.musicapp.domain.Track;
import com.stackroute.musicapp.exceptions.TrackDoesNotExistException;
import com.stackroute.musicapp.exceptions.UserAlreadyExistsException;
import com.stackroute.musicapp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="api/v1")
public class trackController {
    TrackService trackService;
    @Autowired
    public trackController(TrackService trackService){
        this.trackService=trackService;
    }


    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws UserAlreadyExistsException {
        return new ResponseEntity<Track>(trackService.saveTrack(track), HttpStatus.OK);
//        ResponseEntity responseEntity;
//        try{
//            trackService.saveTrack(track);
//            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
//        }catch(Exception e){
//            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        }
//        return responseEntity;
    }


    @GetMapping("tracks")
    public ResponseEntity getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }


    @GetMapping("track/{id}")
    public ResponseEntity getTrack(@PathVariable int id) throws TrackDoesNotExistException {
        return new ResponseEntity<Optional<Track>>(trackService.getTrack(id),HttpStatus.OK);
    }


    @GetMapping("tracks/{string}")
    public ResponseEntity getTrackByName(@PathVariable String string){
        return new ResponseEntity<List<Track>>(trackService.getTrackByName(string),HttpStatus.OK);
    }


    @DeleteMapping("track/{id}")
    public ResponseEntity deleteTrack(@PathVariable int id){
        ResponseEntity responseEntity;
        try{
            trackService.removeTrack(id);
            responseEntity=new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @PutMapping("track")
    public ResponseEntity updateTrack(@RequestBody Track track){
        return new ResponseEntity<Track>(trackService.updateTrackComment(track),HttpStatus.OK);
    }
}

