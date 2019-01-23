package com.stackroute.musicapp.domain;

import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    int trackId;
    String trackName;
    String trackComment;





}
