package com.tylert.harmony.friends.steam.service;

import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tylert.harmony.error.CustomHarmonyException;
import com.tylert.harmony.friends.steam.model.SteamFriendsList;

/**
 * Aggregator service that calls the friends service, then gets the user
 * summaries for all users in that friends list
 * 
 * @author tyler
 *
 */
public interface SteamFriendsListAggregator {

	/**
	 * Get a user's Steam Friends List
	 * 
	 * @param steamId the Steam ID of the user
	 * @return the SteamFriendsList that represents the user's friends list
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public SteamFriendsList getSteamFriendsList(String steamId)
			throws InterruptedException, ExecutionException, CustomHarmonyException, JsonProcessingException;
}
