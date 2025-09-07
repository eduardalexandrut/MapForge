package com.example.mapforge.model.dto;

import com.example.mapforge.model.entity.User;
import com.example.mapforge.service.UserService;

import java.time.LocalDate;
import java.util.Set;

public record UserSummaryDTO(
        Integer id,
        String username
) {
    public static UserSummaryDTO fromEntity(User user) {
        return new UserSummaryDTO(user.getId(), user.getUsername());
    }
}
