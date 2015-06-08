package com.xai.oopTest;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Main class that starts the game
 */
public class Engine {

	public GameManager GM;

	public Engine() {
		initGame();
	}

	public void initGame() {

		GM = new GameManager(); // create game manager to store data

		// initCustomPlanet();
		initRandomPlanets(15);
		GM.printPlanets();

		System.exit(0);
	}

	public static void main(String[] args) {

		Engine engine = new Engine();

	}

	private void initCustomPlanet() {

		Scanner scanner = new Scanner(System.in);

		// name
		System.out.println("What is the planet name?");
		String name = scanner.nextLine(); // get string input

		IWorld w1 = new PlanetX2(name);
		System.out.println(w1);

		// energy level
		boolean canMoveOn = false;
		boolean canSetEnergyLvl = false;

		while (!canMoveOn) {
			System.out
					.println("Would you like the plane's default energy level? Y/N");
			String ans = scanner.nextLine();

			ans.toLowerCase(); // prepare comparison
			System.out.println(ans.substring(0, 1));
			if (ans.substring(0, 1).equals("y")) {
				canSetEnergyLvl = true;
				canMoveOn = true;
			} else if (ans.substring(0, 1).equals("n")) {
				canSetEnergyLvl = false;
				canMoveOn = true;
			}
		}

		if (canSetEnergyLvl) {
			System.out.println("What level would you set to set?");
			int ans = scanner.nextInt();
			((PlanetX2) w1).setEnergyLvl(ans);
		}

		System.out.println(((PlanetX2) w1).getEnergyLvl()); // how to down cast
															// the short version
	}

	/*
	 * Create random planets
	 */
	private void initRandomPlanets(int planetQty) {
		int MIN = 0;
		int MAX = GM.nameGenerator.names.size(); // iterate through random names
													// hasmap

		for (int i = 0; i < planetQty; i++) {

			int randomNum = MIN + (int) (Math.random() * (MAX - MIN));

			Planet temp = createPlanet(randomNum);
			GM.addPlanet(temp); // update GM

		}

	}

	/*
	 * Factory for creating planets
	 */
	private Planet createPlanet(int randomNum) {
		// get random name from hasmap
		String randStr = GM.nameGenerator.names.get(randomNum);
		// create planet with random name
		return new PlanetX(randStr);
	}
}
