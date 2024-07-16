package com.casinoromania;

import java.util.Scanner;

public class CasinoRomaniaApplication {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Enter number of bettors, K positions, and M positions (0 0 0 to exit): ");
      String input = scanner.nextLine();
      String[] parts = input.split(" ");
      int numberOfBettors = Integer.parseInt(parts[0]);
      int countKPositions = Integer.parseInt(parts[1]);
      int countMPositions = Integer.parseInt(parts[2]);
      if (numberOfBettors == 0 && countKPositions == 0 && countMPositions == 0) {
        System.out.println("Finishing data entry.");
        break;
      }
      CasinoConfig casinoConfig = new CasinoConfig(numberOfBettors, countKPositions, countMPositions);
      Casino casino = new Casino(casinoConfig);
      casino.playGame();
    }
  }
}