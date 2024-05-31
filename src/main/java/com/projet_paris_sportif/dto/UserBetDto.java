package com.projet_paris_sportif.dto;

import com.projet_paris_sportif.model.BetKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBetDto {
    private BetKey id;
    private UserBetGameDto game;
    private Integer sum;
}
