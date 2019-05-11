package com.tylert.harmony.friends.steam.model;

/**
 * Friend object in the GetFriendList response
 * 
 * @author tyler
 *
 */
public class GetFriendListFriend {

	/** 64 bit Steam ID of the friend. */
	private String steamid;

	/** Relationship qualifier */
	private String relationship;

	/** Unix timestamp of the time when the relationship was created. */
	private int friend_since;
	
	public GetFriendListFriend() {}

	public GetFriendListFriend(String steamid, String relationship, int friend_since) {
		this.steamid = steamid;
		this.relationship = relationship;
		this.friend_since = friend_since;
	}

	public String getSteamid() {
		return steamid;
	}

	public String getRelationship() {
		return relationship;
	}

	public int getFriend_since() {
		return friend_since;
	}

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public void setFriend_since(int friend_since) {
		this.friend_since = friend_since;
	}
}
