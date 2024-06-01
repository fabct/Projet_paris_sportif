package com.projet_paris_sportif.dto.user;

import com.projet_paris_sportif.model.Bet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserRequestDTO {
    private String name;
    private String surname;
    private String password;
    private String birthyear;
    private String role;
    private Integer solde;
}
