package com.infotech.book.ticket.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotech.book.ticket.app.entities.Character;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {

	@Query("SELECT c FROM Character c WHERE c.characterId = :characterId")
	Character findByCharaterId(Character character);


}
