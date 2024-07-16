package com.casinoromania;

import java.util.StringJoiner;

public class CasinoBettor {

  private final Integer id;

  private boolean excludedFromTheGame;

  public CasinoBettor(Integer id) {
    this.id = id;
  }

  public void excludedFromTheGame() {
    this.excludedFromTheGame = true;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", CasinoBettor.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .toString();
  }

  public Boolean isExcludedFromTheGame() {
    return excludedFromTheGame;
  }

  public Integer getId() {
    return id;
  }

}
