package com.infotech.book.ticket.app.entities;

import javax.persistence.Column;
import javax.persistence.Lob;

public class Character {

	@Column(name = "characterId")
	private String characterId;

	@Column(name = "characterName")
	private String characterName;

	@Column(name = "imageUrl")
	private String imageUrl;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] imageData;

	public String getCharacterId() {
		return characterId;
	}

	public void setCharacterId(String characterId) {
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
