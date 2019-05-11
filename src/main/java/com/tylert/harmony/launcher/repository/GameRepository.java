package com.tylert.harmony.launcher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tylert.harmony.launcher.model.GameModel;

/**
 * Our Game Repository that uses Spring JPA to maintain our local database for games
 * 
 * @author tyler
 *
 */
public interface GameRepository extends JpaRepository<GameModel, Long> {

}
