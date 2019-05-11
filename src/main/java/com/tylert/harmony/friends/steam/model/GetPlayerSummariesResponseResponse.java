package com.tylert.harmony.friends.steam.model;

import java.util.List;

/**
 * Helper Model for the GetPlayerSummaries response so the JSON to POJO mapping is done properly
 * 
 * @author tyler
 *
 */
public class GetPlayerSummariesResponseResponse {

	/** List of players in the response */
	List<GetPlayerSummariesPlayer> players;
	
	public GetPlayerSummariesResponseResponse() {}
	
	public GetPlayerSummariesResponseResponse(List<GetPlayerSummariesPlayer> players) {
		this.players = players;
	}

	public List<GetPlayerSummariesPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<GetPlayerSummariesPlayer> players) {
		this.players = players;
	}
}
