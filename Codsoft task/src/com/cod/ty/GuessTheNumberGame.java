package com.cod.ty;


	import java.util.Scanner;

	public class GuessTheNumberGame {

	    public static int generateRandomNumber(int minRange, int maxRange) {
	        return (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
	    }

	    public static int getUserGuess() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter your guess: ");
	        try {
	            return scanner.nextInt();
	        } catch (java.util.InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	            return getUserGuess();
	        }
	    }

	    public static String compareGuess(int randomNumber, int userGuess) {
	        if (userGuess == randomNumber) {
	            return "Correct";
	        } else if (userGuess < randomNumber) {
	            return "Too low";
	        } else {
	            return "Too high";
	        }
	    }

	    public static void main(String[] args) {
	        int minRange = 1;
	        int maxRange = 100;
	        int maxAttempts = 5;
	        int score = 0;

	        Scanner scanner = new Scanner(System.in);
	        boolean playAgain = true;

	        while (playAgain) {
	            int randomNumber = generateRandomNumber(minRange, maxRange);
	            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

	            for (int attempt = 0; attempt < maxAttempts; attempt++) {
	                int userGuess = getUserGuess();
	                String result = compareGuess(randomNumber, userGuess);
	                System.out.println(result);

	                if (result.equals("Correct")) {
	                    score++;
	                    break;
	                } else if (attempt == maxAttempts - 1) {
	                    System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
	                }
	            }

	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgainStr = scanner.next().toLowerCase();
	            if (!playAgainStr.equals("yes")) {
	                playAgain = false;
	            }
	        }

	        System.out.println("\nGame over. Your final score: " + score + ".");
	    }
	}


