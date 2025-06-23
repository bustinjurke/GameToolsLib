package com.CST8411.gametools;

public class GameManager {
	// Return the index of the player whose turn it is
	public static int getNextPlayerNo(String[] players, int currentIndex) {
		return (currentIndex + 1) % players.length;
	}
	//Returns name of the player whose turn it is
	public static String getNextPlayerName(String[] players, int currentIndex) {
		int nextIndex = getNextPlayerNo(players, currentIndex);
		return players[nextIndex];
	}
	//Performs a delay in seconds
	public static void waitSeconds(int seconds) {
		try { Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	//Performs a countdown and triggers action when finished 
	public static void startCountdown(int seconds, Runnable onFinish) {
		for (int i = seconds; i > 0; i--) {
			waitSeconds(1);
		}
		onFinish.run();
	}
	// Determines the current round number
	public static int getCurrentRound(int turnNumber, int playersCount) {
		return (turnNumber / playersCount) + 1;
	}
}
