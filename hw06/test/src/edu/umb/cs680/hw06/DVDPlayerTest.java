package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DVDPlayerTest {
	
	@Test
	public void DrawerClosedNotPlaying_When_StopButtonIsPushed_While_DVDIsPlaying() {
		DVDPlayer dvdPlayer = DVDPlayer.getInstance();
		dvdPlayer.playButtonPushed();
		dvdPlayer.stopButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), dvdPlayer.getCurrentState());
	}
	
	@Test
	public void DrawerClosedPlaying_When_PlayButtonIsPushed() {
		DVDPlayer dvdPlayer = DVDPlayer.getInstance();
		dvdPlayer.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), dvdPlayer.getCurrentState());
	}

	@Test
	public void DrawerOpen_When_OpenCloseButtonIsPushed_While_DVDIsPlaying() {
		DVDPlayer dvdPlayer = DVDPlayer.getInstance();
		dvdPlayer.playButtonPushed();
		dvdPlayer.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), dvdPlayer.getCurrentState());
	}
}

