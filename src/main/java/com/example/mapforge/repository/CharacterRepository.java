package com.example.mapforge.repository;

import com.example.mapforge.model.Character;
import com.example.mapforge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
