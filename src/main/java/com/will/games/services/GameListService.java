package com.will.games.services;

import com.will.games.dto.GameListDTO;
import com.will.games.repositories.GameListRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllGameList() {
        return gameListRepository.findAll().stream()
                .map(GameListDTO::new)
                .collect(Collectors.toList());
    }
}
