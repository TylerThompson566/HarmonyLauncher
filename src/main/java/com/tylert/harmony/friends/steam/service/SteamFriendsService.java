package com.tylert.harmony.friends.steam.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tylert.harmony.friends.steam.model.GetFriendListFriend;

/**
 * Steam Friends List Service Interface
 * 
 * @author tyler
 *
 */
public interface SteamFriendsService {

	/**
	 * Get the Friends List Response from the Steam API
	 * 
	 * @param steamId the steam ID of the user we are getting the friends list of
	 * @return the list of the user's friends in a GetFriendListResponse object
	 * @throws JsonProcessingException
	 */
	public List<GetFriendListFriend> getFriendList(String steamId) throws JsonProcessingException;
}
