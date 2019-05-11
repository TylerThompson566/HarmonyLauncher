package com.tylert.harmony.launcher.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tylert.harmony.launcher.model.GameModel;
import com.tylert.harmony.launcher.repository.GameRepository;

/**
 * Controller for the games that the user wants to launch from the program
 * 
 * @author tyler
 *
 */
@Component
public class GameController {

	/** Logger */
	private static final Logger log = LoggerFactory.getLogger(GameController.class);

	/** Jackson ObjectMapper */
	@Autowired
	ObjectMapper objectMapper;
	
	/** Game Repository */
	@Autowired
	GameRepository repo;

	/**
	 * Save the game
	 * 
	 * @param game the game to be saved
	 * @param repo the Game Repository
	 * @return the saved game
	 * @throws JsonProcessingException
	 */
	public GameModel addGame(GameModel game) throws JsonProcessingException {

		// logging
		if (log.isInfoEnabled()) {
			log.info(String.format("saving game %s", objectMapper.writeValueAsString(game)));
		}

		// return the GameModel that is saved
		return repo.save(game);
	}
	
	/**
	 * Save the game
	 * 
	 * @param game the game to be saved
	 * @param repo the Game Repository
	 * @return the saved game
	 * @throws JsonProcessingException
	 */
	public GameModel updateGame(GameModel game) throws JsonProcessingException {

		// logging
		if (log.isInfoEnabled()) {
			log.info(String.format("updating game %s", objectMapper.writeValueAsString(game)));
		}

		// return the GameModel that is updated
		return repo.save(game);
	}

	/**
	 * Get all games in the game repository
	 * 
	 * @param repo the Game Repository
	 * @return a list of all of the games in the repository
	 * @throws JsonProcessingException
	 */
	public List<GameModel> getAllGames() {
		
		log.debug("finding all games...");
		return repo.findAll();
	}

	/**
	 * Delete a game from the repository
	 * 
	 * @param game the game to be deleted
	 * @param repo the Game Repository
	 * @throws JsonProcessingException
	 */
	public void deleteGame(GameModel game) throws JsonProcessingException {

		// logging
		if (log.isInfoEnabled()) {
			log.info(String.format("deleting game %s", objectMapper.writeValueAsString(game)));
		}

		// delete the game from the repository
		repo.deleteById(game.getId());
	}
}
