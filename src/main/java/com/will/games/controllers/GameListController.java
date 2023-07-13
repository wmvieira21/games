/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.will.games.controllers;

import com.will.games.dto.GameListDTO;
import com.will.games.dto.GameMinDTO;
import com.will.games.services.GameListService;
import com.will.games.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAllGameList() {
        return gameListService.findAllGameList();
    }

    @GetMapping(value = "/{idList}/games")
    public List<GameMinDTO> findGamesByList(@PathVariable Long idList) {
        return gameService.findGamesByList(idList);
    }
}
