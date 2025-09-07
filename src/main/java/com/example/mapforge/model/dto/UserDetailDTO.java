package com.example.mapforge.model.dto;

import com.example.mapforge.model.entity.Character;
import com.example.mapforge.model.entity.User;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record UserDetailDTO(
        Integer id,
        String username,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String email,
        Set<CharacterSummaryDTO> characters
      //  Set<CampaignSummaryDTO> campaigns
) {
    public static UserDetailDTO fromEntity(User user) {
        return new UserDetailDTO(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getDateOfBirth(),
                user.getEmail(),
                user.getCharacters().stream().map(CharacterSummaryDTO::fromEnity).collect(Collectors.toSet())
        );
    }
}
