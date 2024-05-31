package com.projet_paris_sportif.dto.user;

import com.projet_paris_sportif.model.BetKey;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserBetDTO {
    private BetKey id;
    private UserBetGameDto game;
    private Integer sum;
}
