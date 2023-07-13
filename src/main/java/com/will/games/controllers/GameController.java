package com.will.games.controllers;

import com.will.games.dto.GameDTO;
import com.will.games.dto.GameMinDTO;
import com.will.games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAllGames() {
        return gameService.findAllGames();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findByID(@PathVariable Long id) {
        return gameService.findGameByID(id);
    }
}
