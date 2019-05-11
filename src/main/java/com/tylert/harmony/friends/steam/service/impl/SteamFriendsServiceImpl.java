package com.tylert.harmony.friends.steam.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tylert.harmony.friends.steam.model.GetFriendListFriend;
import com.tylert.harmony.friends.steam.model.GetFriendListResponse;
import com.tylert.harmony.friends.steam.service.SteamFriendsService;

/**
 * Implementation of the Steam Friends Service interface
 * 
 * @author tyler
 *
 */
@Service
public class SteamFriendsServiceImpl implements SteamFriendsService {

	/** The logger */
	private static final Logger log = LoggerFactory.getLogger(SteamFriendsServiceImpl.class);

	/** API key */
	@Value("${steam.apikey}")
	private String apiKey;

	/** The base url for all Steam API calls */
	@Value("${steam.baseurl}")
	private String baseUrl;

	/** GetFriendsList endpoint */
	@Value("${steam.friends.endpoint}")
	private String getFriendsListEndpoint;

	/** The rest template for making rest calls */
	@Autowired
	private RestTemplate restTemplate;

	/** the object mapper from Jackson to convert to and from JSON and POJOs */
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Get the Friends List Response from the Steam API
	 * 
	 * @param steamId the steam ID of the user we are getting the friends list of
	 * @return the list of the user's friends in a GetFriendListResponse object
	 * @throws JsonProcessingException
	 */
	public List<GetFriendListFriend> getFriendList(String steamId) throws JsonProcessingException {

		// get the url
		String url = String.format("%s%s?key=%s&steamid=%s&relationship=friend", baseUrl, getFriendsListEndpoint,
				apiKey, steamId);

		// logging
		log.info("sending request to {}", url);

		// get the response
		GetFriendListResponse response = restTemplate.getForObject(url, GetFriendListResponse.class);

		// logging
		if (log.isInfoEnabled()) {
			log.info("retrieved friends list response: {}", objectMapper.writeValueAsString(response));
		}

		// return the response
		List<GetFriendListFriend> friendsList = response.getFriendslist().getFriends();
		if (log.isInfoEnabled()) {
			log.info("returned friends list: {}", objectMapper.writeValueAsString(friendsList));
		}
		return friendsList;
	}
}
