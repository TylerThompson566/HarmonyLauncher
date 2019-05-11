package com.tylert.harmony.friends.steam.model;

/**
 * Player object in the GetPlayeySummaries response from the Steam API
 * 
 * @author tyler
 *
 */
public class GetPlayerSummariesPlayer {

	/** 64bit SteamID of the user */
	private String steamid;

	/**
	 * This represents whether the profile is visible or not, and if it is visible,
	 * why you are allowed to see it. Note that because this WebAPI does not use
	 * authentication, there are only two possible values returned: 1 - the profile
	 * is not visible to you (Private, Friends Only, etc), 3 - the profile is
	 * "Public", and the data is visible. Mike Blaszczak's post on Steam forums
	 * says, "The community visibility state this API returns is different than the
	 * privacy state. It's the effective visibility state from the account making
	 * the request to the account being viewed given the requesting account's
	 * relationship to the viewed account."
	 */
	private int communityvisibilitystate;

	/**
	 * If set, indicates the user has a community profile configured (will be set to
	 * '1')
	 */
	private int profilestate;

	/** The player's persona name (display name) */
	private String personaname;

	/** The last time the user was online, in unix time. */
	private int lastlogoff;

	/** If set, indicates the profile allows public comments. */
	private int commentpermission;

	/** The full URL of the player's Steam Community profile. */
	private String profileurl;

	/**
	 * The full URL of the player's 32x32px avatar. If the user hasn't configured an
	 * avatar, this will be the default ? avatar.
	 */
	private String avatar;

	/**
	 * The full URL of the player's 64x64px avatar. If the user hasn't configured an
	 * avatar, this will be the default ? avatar.
	 */
	private String avatarmedium;

	/**
	 * The full URL of the player's 184x184px avatar. If the user hasn't configured
	 * an avatar, this will be the default ? avatar.
	 */
	private String avatarfull;

	/**
	 * The user's current status. 0 - Offline, 1 - Online, 2 - Busy, 3 - Away, 4 -
	 * Snooze, 5 - looking to trade, 6 - looking to play. If the player's profile is
	 * private, this will always be "0", except if the user has set their status to
	 * looking to trade or looking to play, because a bug makes those status appear
	 * even if the profile is private.
	 */
	private int personastate;

	/** The player's "Real Name", if they have set it. */
	private String realname;

	/**
	 * The player's primary group, as configured in their Steam Community profile.
	 */
	private String primaryclanid;

	/** The time the player's account was created. */
	private int timecreated;

	/** persona state flags */
	private int personastateflags;

	/**
	 * If set on the user's Steam Community profile, The user's country of
	 * residence, 2-character ISO country code
	 */
	private String loccountrycode;
	
	public GetPlayerSummariesPlayer() {}

	public GetPlayerSummariesPlayer(String steamid, int communityvisibilitystate, int profilestate, String personaname,
			int lastlogoff, int commentpermission, String profileurl, String avatar, String avatarmedium,
			String avatarfull, int personastate, String realname, String primaryclanid, int timecreated,
			int personastateflags, String loccountrycode) {
		this.steamid = steamid;
		this.communityvisibilitystate = communityvisibilitystate;
		this.profilestate = profilestate;
		this.personaname = personaname;
		this.lastlogoff = lastlogoff;
		this.commentpermission = commentpermission;
		this.profileurl = profileurl;
		this.avatar = avatar;
		this.avatarmedium = avatarmedium;
		this.avatarfull = avatarfull;
		this.personastate = personastate;
		this.realname = realname;
		this.primaryclanid = primaryclanid;
		this.timecreated = timecreated;
		this.personastateflags = personastateflags;
		this.loccountrycode = loccountrycode;
	}

	public String getSteamid() {
		return steamid;
	}

	public int getCommunityvisibilitystate() {
		return communityvisibilitystate;
	}

	public int getProfilestate() {
		return profilestate;
	}

	public String getPersonaname() {
		return personaname;
	}

	public int getLastlogoff() {
		return lastlogoff;
	}

	public int getCommentpermission() {
		return commentpermission;
	}

	public String getProfileurl() {
		return profileurl;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getAvatarmedium() {
		return avatarmedium;
	}

	public String getAvatarfull() {
		return avatarfull;
	}

	public int getPersonastate() {
		return personastate;
	}

	public String getRealname() {
		return realname;
	}

	public String getPrimaryclanid() {
		return primaryclanid;
	}

	public int getTimecreated() {
		return timecreated;
	}

	public int getPersonastateflags() {
		return personastateflags;
	}

	public String getLoccountrycode() {
		return loccountrycode;
	}

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}

	public void setCommunityvisibilitystate(int communityvisibilitystate) {
		this.communityvisibilitystate = communityvisibilitystate;
	}

	public void setProfilestate(int profilestate) {
		this.profilestate = profilestate;
	}

	public void setPersonaname(String personaname) {
		this.personaname = personaname;
	}

	public void setLastlogoff(int lastlogoff) {
		this.lastlogoff = lastlogoff;
	}

	public void setCommentpermission(int commentpermission) {
		this.commentpermission = commentpermission;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setAvatarmedium(String avatarmedium) {
		this.avatarmedium = avatarmedium;
	}

	public void setAvatarfull(String avatarfull) {
		this.avatarfull = avatarfull;
	}

	public void setPersonastate(int personastate) {
		this.personastate = personastate;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setPrimaryclanid(String primaryclanid) {
		this.primaryclanid = primaryclanid;
	}

	public void setTimecreated(int timecreated) {
		this.timecreated = timecreated;
	}

	public void setPersonastateflags(int personastateflags) {
		this.personastateflags = personastateflags;
	}

	public void setLoccountrycode(String loccountrycode) {
		this.loccountrycode = loccountrycode;
	}
}
