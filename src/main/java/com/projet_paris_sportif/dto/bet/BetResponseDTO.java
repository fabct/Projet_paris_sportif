package com.projet_paris_sportif.dto.bet;

import com.projet_paris_sportif.dto.game.GameResponseDTO;
import com.projet_paris_sportif.model.BetKey;
import com.projet_paris_sportif.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BetResponseDTO {
    private BetKey id;
    private GameResponseDTO game;
    private Integer sum;
}
