package com.casinoromania;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Casino {

  private final Map<Integer, CasinoBettor> casinoBettors;

  private final CasinoConfig casinoConfig;

  public Casino(CasinoConfig casinoConfig) {
    this.casinoBettors = prepareGame(casinoConfig.numberOfBettors());
    this.casinoConfig = casinoConfig;
  }

  private static Map<Integer, CasinoBettor> prepareGame(Integer numberOffBettors) {
    return IntStream.rangeClosed(1, numberOffBettors)
        .mapToObj(CasinoBettor::new)
        .collect(Collectors.toMap(CasinoBettor::getId, casinoBettor -> casinoBettor));
  }

  private static Boolean isGameEnded(Map<Integer, CasinoBettor> bettors) {
    return bettors.values().stream().allMatch(CasinoBettor::isExcludedFromTheGame);
  }

  public void playGame() {
    int currentKPosition = 1;
    int currentMPosition = this.casinoConfig.numberOfBettors();
    StringBuilder result = new StringBuilder();
    while (!isGameEnded(this.casinoBettors)) {
      currentKPosition = findNextToExcludeClockwise(currentKPosition);
      currentMPosition = findNextToExcludeAnticlockwise(currentMPosition);
      CasinoBettor excludedKBettor = this.casinoBettors.get(currentKPosition);
      CasinoBettor excludedMBettor = this.casinoBettors.get(currentMPosition);
      excludedKBettor.excludedFromTheGame();
      excludedMBettor.excludedFromTheGame();
      currentKPosition++;
      currentMPosition--;
      result.append(printResult(excludedKBettor, excludedMBettor));
    }
    System.out.println(result.substring(0, result.length() - 1));
  }

  private String printResult(CasinoBettor excludedKCasinoBettor, CasinoBettor excludedMBettor) {
    StringBuilder casinoResult = new StringBuilder();
    if (excludedKCasinoBettor.getId().equals(excludedMBettor.getId())) {
      casinoResult.append("  ").append(excludedKCasinoBettor.getId());
    } else {
      casinoResult.append("  ").append(excludedKCasinoBettor.getId()).append("  ").append(excludedMBettor.getId());
    }
    casinoResult.append(",");
    return casinoResult.toString();
  }

  private int findNextToExcludeAnticlockwise(int startPosition) {
    int countKPosition = 0;
    int currentMPosition = startPosition;

    while (countKPosition < this.casinoConfig.numberMPositions()) {
      if (currentMPosition < 1) {
        currentMPosition = this.casinoConfig.numberOfBettors();
      }

      if (!this.casinoBettors.get(currentMPosition).isExcludedFromTheGame()) {
        countKPosition++;
      }

      if (countKPosition < this.casinoConfig.numberMPositions()) {
        currentMPosition--;
      }
    }
    return currentMPosition;
  }

  private int findNextToExcludeClockwise(int currentKPosition) {
    int countKPosition = 0;
    while (countKPosition < this.casinoConfig.numberKPositions()) {
      if (currentKPosition > this.casinoConfig.numberOfBettors()) {
        currentKPosition = 1;
      }
      if (!this.casinoBettors.get(currentKPosition).isExcludedFromTheGame()) {
        countKPosition++;
      }
      if (countKPosition < this.casinoConfig.numberKPositions()) {
        currentKPosition++;
      }
    }
    return currentKPosition;
  }
}
