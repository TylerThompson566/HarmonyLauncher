package com.tylert.harmony.friends.steam.model;

import java.util.List;

/**
 * Model of a User's Steam Friends List
 * 
 * @author tyler
 *
 */
public class SteamFriendsList {

	/** List of Steam friends */
	private List<GetPlayerSummariesPlayer> friends;

	public SteamFriendsList(List<GetPlayerSummariesPlayer> friends) {
		this.friends = friends;
	}

	public List<GetPlayerSummariesPlayer> getFriends() {
		return friends;
	}

	public void setFriends(List<GetPlayerSummariesPlayer> friends) {
		this.friends = friends;
	}
	
	/**
	 * Add a friend to the friends list
	 * 
	 * @param friend friend to add to the friends list
	 */
	public void addFriend(GetPlayerSummariesPlayer friend) {
		friends.add(friend);
	}
}
