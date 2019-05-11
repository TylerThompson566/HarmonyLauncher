package com.tylert.harmony.friends.steam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tylert.harmony.error.CustomHarmonyException;
import com.tylert.harmony.friends.steam.model.GetFriendListFriend;
import com.tylert.harmony.friends.steam.model.SteamFriendsList;
import com.tylert.harmony.friends.steam.service.SteamFriendsListAggregator;
import com.tylert.harmony.friends.steam.service.SteamFriendsService;
import com.tylert.harmony.friends.steam.service.SteamUserService;

/**
 * Implementation of the Aggregator service that calls the friends service, then
 * gets the user summaries for all users in that friends list
 * 
 * @author tyler
 *
 */
@Service
public class SteamFriendsListAggregatorImpl implements SteamFriendsListAggregator {

	/** The logger */
	private static final Logger log = LoggerFactory.getLogger(SteamFriendsListAggregatorImpl.class);

	/** The Friends Service */
	@Autowired
	private SteamFriendsService friendsService;

	/** The User Service */
	@Autowired
	private SteamUserService userService;

	/** the object mapper from Jackson to convert to and from JSON and POJOs */
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Get a user's Steam Friends List
	 * 
	 * @param steamId the Steam ID of the user
	 * @return the SteamFriendsList that represents the user's friends list
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws CustomHarmonyException
	 * @throws JsonProcessingException
	 */
	public SteamFriendsList getSteamFriendsList(String steamId)
			throws InterruptedException, ExecutionException, CustomHarmonyException, JsonProcessingException {

		// get the friends list from the Friends List response asynchronously
		CompletableFuture<List<GetFriendListFriend>> friendsServiceResponseFuture = CompletableFuture
				.supplyAsync(() -> {
					try {
						return friendsService.getFriendList(steamId);
					} catch (JsonProcessingException e) {
						return null;
					}
				});

		// initialize the steam friends list
		SteamFriendsList friendsList = new SteamFriendsList(new ArrayList<>());

		// get the response of the friends service
		ArrayList<GetFriendListFriend> friendsServiceResponse = (ArrayList<GetFriendListFriend>) friendsServiceResponseFuture
				.get();

		// check if the service call failed by returning null
		if (friendsServiceResponse == null) {
			throw new CustomHarmonyException(
					String.format("Exception while processing friends list for steam user %s", steamId));
		}

		// make the API call for each friend in the friends list
		friendsServiceResponse.stream().forEach(friend -> {
			try {
				friendsList.addFriend(userService.getUser(friend.getSteamid()));
			} catch (JsonProcessingException e) {
				log.warn("JsonProcessingException while getting user summary for user {}, ignoring this user...",
						friend.getSteamid());
			}
		});

		// return the friends list
		if (log.isInfoEnabled()) {
			log.info("Aggregated Friends List: {}", objectMapper.writeValueAsString(friendsList));
		}
		return friendsList;
	}
}
