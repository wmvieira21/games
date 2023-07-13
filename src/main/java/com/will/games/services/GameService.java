package com.will.games.services;

import com.will.games.dto.GameDTO;
import com.will.games.dto.GameMinDTO;
import com.will.games.entities.Game;
import com.will.games.projections.GameMinProjection;
import com.will.games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAllGames() {
        List<Game> gameList = gameRepository.findAll();

        return gameList.stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findGamesByList(Long idList) {
        List<GameMinProjection> gameList = gameRepository.searchByList(idList);

        return gameList.stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameDTO findGameByID(Long id) {
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }
}
