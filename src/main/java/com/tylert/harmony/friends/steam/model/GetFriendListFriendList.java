package com.tylert.harmony.friends.steam.model;

import java.util.List;

/**
 * Helper Model for the GetFriendList response so the JSON to POJO mapping is
 * done properly
 * 
 * @author tyler
 *
 */
public class GetFriendListFriendList {

	/** List of friends */
	private List<GetFriendListFriend> friends;

	public GetFriendListFriendList() {
	}

	public GetFriendListFriendList(List<GetFriendListFriend> friends) {
		this.friends = friends;
	}

	public List<GetFriendListFriend> getFriends() {
		return friends;
	}

	public void setFriends(List<GetFriendListFriend> friends) {
		this.friends = friends;
	}
}
