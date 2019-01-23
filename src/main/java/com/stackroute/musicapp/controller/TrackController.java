package com.stackroute.musicapp.controller;

import com.stackroute.musicapp.domain.Track;
import com.stackroute.musicapp.exceptions.TrackDoesNotExistException;
import com.stackroute.musicapp.exceptions.UserAlreadyExistsException;
import com.stackroute.musicapp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController//specifies this class is a controller
@RequestMapping(value="api/v1")//provides root mapping path
public class TrackController {
    //trackService instance

    private TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

    // maps with post request with endpoint /api/v1/track
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws UserAlreadyExistsException {
        return new ResponseEntity<Track>(trackService.saveTrack(track), HttpStatus.OK);
    }

    //maps with get request with endpoint /api/v1/tracks
    @GetMapping("tracks")
    public ResponseEntity getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    //maps with get request with endpoint /api/v1/track/{id}
    @GetMapping("track/{id}")
    public ResponseEntity getTrack(@PathVariable int id) throws TrackDoesNotExistException {
        return new ResponseEntity<Optional<Track>>(trackService.getTrack(id),HttpStatus.OK);
    }

//    //maps with get request with endpoint /api/v1/tracks/{string}
//    @GetMapping("tracks/{string}")
//    public ResponseEntity getTrackByName(@PathVariable String string){
//        return new ResponseEntity<List<Track>>(trackService.getTrackByName(string),HttpStatus.OK);
//    }

    //maps with delete request with endpoint /api/v1/track/{id}
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

    //maps with put request with endpoint /api/v1/track
    @PutMapping("update")
    public ResponseEntity updateTrack(@RequestParam("id") int id,@RequestParam("comment") String comment) throws TrackDoesNotExistException{
        return new ResponseEntity<Track>(trackService.updateTrackComment(id,comment),HttpStatus.OK);
    }
}

