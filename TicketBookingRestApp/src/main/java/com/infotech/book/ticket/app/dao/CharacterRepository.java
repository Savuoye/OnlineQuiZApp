package com.infotech.book.ticket.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotech.book.ticket.app.entities.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

}
