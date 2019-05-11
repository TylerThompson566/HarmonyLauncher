package com.tylert.harmony;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tylert.harmony.error.CustomHarmonyException;
import com.tylert.harmony.friends.steam.service.SteamFriendsListAggregator;

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
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @throws CustomHarmonyException 
	 */
	public static void main(String[] args) throws JsonProcessingException, InterruptedException, ExecutionException, CustomHarmonyException {

		// start the spring application and get the context
		ConfigurableApplicationContext context = SpringApplication.run(HarmonyApplication.class, args);

		// set my steam id
		String mySteamID = "76561198034305173";

		// test the friends list aggregator service
		SteamFriendsListAggregator agg = context.getBean(SteamFriendsListAggregator.class);
		agg.getSteamFriendsList(mySteamID);

	}
}
