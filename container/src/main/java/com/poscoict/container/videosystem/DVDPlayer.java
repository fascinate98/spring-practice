package com.poscoict.container.videosystem;

public class DVDPlayer {

	private DigitalVideoDisc dvd;
	
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}

	public DVDPlayer() {
	}

	public void play() {
		dvd.play();
	}

	public void setDigitalVideoDisc(DigitalVideoDisc dvd2) {
		
		
	}

	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	

}
