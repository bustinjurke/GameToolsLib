package com.CST8411.gametools;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class ChanceTools {
	
	private static final Random random = new Random();
		
		//Flips a coin
		public static String flipCoin() {
			return random.nextBoolean() ? "Heads" : "Tails";
		}
		//Rolls a single dice that is 6,12 or 20 sided
		public static int rollDice(int sides) {
			if (sides !=6 && sides != 12 && sides !=20) {
				throw new IllegalArgumentException("Dice must be 6,12 or 20 sided");
			}
			return random.nextInt(sides) + 1;
		}
		//Rolls Multiple Dice and returns sum of numbers rolled
		public static int rollMultipleDice(int sides, int count) {
			if (count <=0) {
				throw new IllegalArgumentException("Must roll at least 1 die");
			}
			int total = 0;
			for (int i = 0; i < count; i++) {
				total += rollDice(sides);
			}
			return total;
		}
		//Rolls Multiple Dice and returns results of each dice
		public static List<Integer> getDiceRollResults(int sides, int count) {
			if (count <=0) {
				throw new IllegalArgumentException("Must roll at least 1 die");
			}
			List<Integer> results = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				results.add(rollDice(sides));
			}
			return results;
		}
		//Provides the results of a chance event
		public static boolean percentChance(int chance) {
			if (chance <0 || chance >100) {
				throw new IllegalArgumentException("Probably must be between 0-100%");
			}
			//Select a random number between 1-100
			int roll = random.nextInt(100) + 1;
			//if chance is higher than roll return true
			return roll <= chance;
		}

}
