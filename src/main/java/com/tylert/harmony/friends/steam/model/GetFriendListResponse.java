package com.tylert.harmony.friends.steam.model;

/**
 * Model for the /GetFriendList response
 * 
 * @author tyler
 *
 */
public class GetFriendListResponse {

	/** List of friends */
	private GetFriendListFriendList friendslist;
	
	public GetFriendListResponse() {}
	
	public GetFriendListResponse(GetFriendListFriendList friendslist) {
		this.friendslist = friendslist;
	}
	
	public GetFriendListFriendList getFriendslist() {
		return friendslist;
	}
	
	public void setFriendslist(GetFriendListFriendList friendslist) {
		this.friendslist = friendslist;
	}
}
