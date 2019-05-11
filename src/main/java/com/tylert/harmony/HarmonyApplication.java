package com.tylert.harmony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tylert.harmony.friends.steam.service.SteamFriendsService;
import com.tylert.harmony.friends.steam.service.SteamUserService;

/**
 * HarmonyLauncher: this is where the program starts
 * 
 * @author tyler
 *
 */
@SpringBootApplication
@PropertySource("classpath:/steam/steam.properties")
public class HarmonyApplication {

	/**
	 * main method, start of execution
	 * 
	 * @param args command line arguments
	 * @throws JsonProcessingException 
	 */
	public static void main(String[] args) throws JsonProcessingException {
		
		// start the spring application and get the context
		ConfigurableApplicationContext context = SpringApplication.run(HarmonyApplication.class, args);
		
		// set my steam id
		String mySteamID = "76561198034305173";
		
		// test the friends service
		SteamFriendsService friendsService = context.getBean(SteamFriendsService.class);
		friendsService.getFriendList(mySteamID);
		
		// test the user service
		SteamUserService userService = context.getBean(SteamUserService.class);
		userService.getUser(mySteamID);

	}
}
