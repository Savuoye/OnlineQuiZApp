package com.infotech.book.ticket.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "characterId")
	private Long characterId;

	@Column(name = "characterName")
	private String characterName;

	@Column(name = "imageUrl")
	private String imageUrl;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] imageData;

	public Long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

}
