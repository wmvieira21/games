package com.will.games.services;

import com.will.games.dto.GameListDTO;
import com.will.games.projections.GameMinProjection;
import com.will.games.repositories.GameListRepository;
import com.will.games.repositories.GameRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllGameList() {
        return gameListRepository.findAll().stream()
                .map(GameListDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        
        GameMinProjection remove = list.remove(sourceIndex);
        list.add(destIndex, remove);
        
        int min = sourceIndex < destIndex ? sourceIndex : destIndex;
        int max = sourceIndex < destIndex ? destIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
