package com.will.games.services;

import com.will.games.dto.GameMinDTO;
import com.will.games.entities.Game;
import com.will.games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAllGames() {
        List<Game> gameList = gameRepository.findAll();

        return gameList.stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }
}
