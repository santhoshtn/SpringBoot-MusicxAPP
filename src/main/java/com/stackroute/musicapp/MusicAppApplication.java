package com.stackroute.musicapp;

import com.stackroute.musicapp.domain.Track;
import com.stackroute.musicapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class MusicAppApplication implements ApplicationListener<ContextRefreshedEvent>,CommandLineRunner {
	@Autowired
	TrackRepository trackRepository;
	public static void main(String[] args) {
		SpringApplication.run(MusicAppApplication.class, args);
	}
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {

		// here your code ...
	trackRepository.save(new Track(1,"song1","awesome1"));

	}

	@Override
	public  void run(String... args) throws Exception {
		trackRepository.save(new Track(2,"song2","awesome2"));
	}
}

