package com.tylert.harmony.friends.steam.model;

/**
 * Friend object in the GetFriendList response
 * 
 * @author tyler
 *
 */
public class GetFriendListFriend {
	
	/** the SteamID of the friend */
	private String steamid;
	
	/** the relationship this friend has to the user */
	private String relationship;
	
	/** int representing how long the user has been friends with this user */
	private int friend_since;
}
