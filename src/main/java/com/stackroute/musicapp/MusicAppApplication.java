package com.stackroute.musicapp;

import com.stackroute.musicapp.domain.Track;
import com.stackroute.musicapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

//	MusicAppApplication class implements context refreshed and commandlineRunner
@SpringBootApplication
public class MusicAppApplication implements ApplicationListener<ContextRefreshedEvent>,CommandLineRunner {

	@Autowired
	TrackRepository trackRepository;

	@Autowired
	Environment environment;

	//Main method
	public static void main(String[] args) {
		SpringApplication.run(MusicAppApplication.class, args);
	}

	//Pre-fill data in database using onApplicationContext
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		trackRepository.save(new Track(Integer.parseInt(environment.getProperty(String.valueOf("trackId"))),
				environment.getProperty("trackName"),environment.getProperty("trackComment")));

	}

	//Pre-fill data in database using CommandLineRunner
	@Override
	public  void run(String... args) throws Exception {
		trackRepository.save(new Track(Integer.parseInt(environment.getProperty(String.valueOf("trackIdRun"))),
				environment.getProperty("trackNameRun"),environment.getProperty("trackCommentRun")));
	}

}

