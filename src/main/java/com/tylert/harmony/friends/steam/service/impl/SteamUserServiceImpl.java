package com.tylert.harmony.friends.steam.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tylert.harmony.friends.steam.model.GetPlayerSummariesResponse;
import com.tylert.harmony.friends.steam.service.SteamUserService;

/**
 * Implementation of the Steam User Service
 * 
 * @author tyler
 *
 */
@Service
public class SteamUserServiceImpl implements SteamUserService {

	/** The logger */
	private static final Logger log = LoggerFactory.getLogger(SteamUserServiceImpl.class);

	/** API key */
	@Value("${steam.apikey}")
	private String apiKey;

	/** The base url for all Steam API calls */
	@Value("${steam.baseurl}")
	private String baseUrl;

	@Value("${steam.user.endpoint}")
	private String getUserEndpoint;

	/** The rest template for making rest calls */
	@Autowired
	private RestTemplate restTemplate;

	/** the object mapper from Jackson to convert to and from JSON and POJOs */
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Get the Steam profile for a user by Steam ID
	 * 
	 * @param steamId the Steam ID of the user
	 * @return the player object for the user with the matching Steam ID
	 * @throws JsonProcessingException
	 */
	public GetPlayerSummariesResponse getUser(String steamId) throws JsonProcessingException {

		// get the url
		String url = String.format("%s%s?key=%s&steamids=%s", baseUrl, getUserEndpoint, apiKey, steamId);

		// logging
		log.info("sending request to {}", url);

		// get the response
		GetPlayerSummariesResponse response = restTemplate.getForObject(url, GetPlayerSummariesResponse.class);

		// logging
		if (log.isInfoEnabled()) {
			log.info("retrieved user summary response: {}", objectMapper.writeValueAsString(response));
		}

		// return the only player in the list of players in the response
		return response;
	}
}
