package com.stackroute.musicapp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "tracks")//orm with database
@Data//provides getter and setter at runtime
@NoArgsConstructor//provides constructor without arguments at runtime
@AllArgsConstructor//provides parameterized constructor at runtime
public class Track {
    @Id
    int trackId;//placeholder for trackID
    String trackName;//placeholder for trackName
    String trackComment;//placeholder for trackComment

}
