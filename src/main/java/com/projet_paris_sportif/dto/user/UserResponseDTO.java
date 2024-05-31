package com.projet_paris_sportif.dto.user;

import com.projet_paris_sportif.model.Bet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserResponseDTO extends UserRequestDTO{
    private Integer id;
}
