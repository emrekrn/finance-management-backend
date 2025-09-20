package com.emrecan.services.budget.model.core;

public enum TransactionTypeEnum {
  INCOME("INCOME"),

  OUTCOME("OUTCOME"),

  INCOME_OUTCOME("INCOME/OUTCOME");

  private final String value;

  TransactionTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
