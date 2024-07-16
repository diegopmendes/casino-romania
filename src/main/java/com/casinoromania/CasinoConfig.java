package com.casinoromania;

public record CasinoConfig(int numberOfBettors, int numberKPositions, int numberMPositions) {

  public CasinoConfig(int numberOfBettors, int numberKPositions, int numberMPositions) {
    this.numberOfBettors = numberOfBettors;
    this.numberKPositions = numberKPositions;
    this.numberMPositions = numberMPositions;
    validateFields();
  }

  private void validateFields() {
    if (numberKPositions < 0) {
      throw new IllegalArgumentException("O valor de 'K' deve ser maior que 0.");
    }
    if (numberMPositions < 0) {
      throw new IllegalArgumentException("O valor de 'M' deve ser maior que 0.");
    }
    if (numberOfBettors < 0 || numberOfBettors >= 20) {
      throw new IllegalArgumentException("O valor de 'N' deve ser maior que 0 e menor que 20");
    }
  }

}
