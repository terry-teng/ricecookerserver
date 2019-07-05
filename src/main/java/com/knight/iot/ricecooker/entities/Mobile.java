package com.knight.iot.ricecooker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Mobile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@Column(name="TOKEN")
	private String fcmToken;
	@OneToOne
	private RiceCooker riceCooker;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public RiceCooker getRiceCooker() {
		return riceCooker;
	}

	public void setRiceCooker(RiceCooker riceCooker) {
		this.riceCooker = riceCooker;
	}
	
	

	
}
