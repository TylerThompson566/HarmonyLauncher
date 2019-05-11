package com.tylert.harmony.friends.steam.model;

/**
 * Model for the GetPlayerSummaries response from the Steam API
 * 
 * @author tyler
 *
 */
public class GetPlayerSummariesResponse {

	/** List of players in the response */
	GetPlayerSummariesResponseResponse response;

	public GetPlayerSummariesResponse() {
	}

	public GetPlayerSummariesResponse(GetPlayerSummariesResponseResponse response) {
		this.response = response;
	}

	public GetPlayerSummariesResponseResponse getResponse() {
		return response;
	}

	public void setResponse(GetPlayerSummariesResponseResponse response) {
		this.response = response;
	}
}
