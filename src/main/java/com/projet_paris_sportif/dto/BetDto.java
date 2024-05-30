package com.projet_paris_sportif.dto;

import com.projet_paris_sportif.model.BetKey;
import com.projet_paris_sportif.model.Game;
import com.projet_paris_sportif.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BetDto {
    private BetKey id;
    private User user;
    private GameDto game;
    private Integer sum;
}
