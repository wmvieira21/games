package com.will.games.dto;

import com.will.games.entities.GameList;
import org.springframework.beans.BeanUtils;

public class GameListDTO {
    
    private Long id;
    private String name;
    
    public GameListDTO() {
    }
    
    public GameListDTO(GameList gameList) {
        BeanUtils.copyProperties(gameList, this);
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
