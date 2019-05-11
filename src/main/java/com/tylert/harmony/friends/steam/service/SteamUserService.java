package com.tylert.harmony.friends.steam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tylert.harmony.friends.steam.model.GetPlayerSummariesPlayer;

public interface SteamUserService {

	/**
	 * Get the Steam profile for a user by Steam ID
	 * 
	 * @param steamId the Steam ID of the user
	 * @return the player object for the user with the matching Steam ID
	 * @throws JsonProcessingException
	 */
	public GetPlayerSummariesPlayer getUser(String steamId) throws JsonProcessingException;
}
