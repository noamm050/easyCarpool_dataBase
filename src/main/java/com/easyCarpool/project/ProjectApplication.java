package com.easyCarpool.project;

import com.easyCarpool.project.trip.Trip;
import com.easyCarpool.project.trip.TripRepository;
import com.easyCarpool.project.user.User;
import com.easyCarpool.project.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

/***
 * ride share project
 * 04/04/2023
 * @author Gil Shtein
 */
@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args) ;
	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository/*,TripRepository tripRepository*/)
	{
		return args -> {

			User maria= new User(
					"maria", "jones","maria.jones@gmail.com","maria123");


			userRepository.save(maria);

			/*
			LocalDate localDate= LocalDate.now();
			LocalTime localTime= LocalTime.of(9,0);
			Trip trip =new Trip("tel aviv", " keisarya", localTime,localDate,50);
			tripRepository.save(trip);
*/

		};
	}

}
