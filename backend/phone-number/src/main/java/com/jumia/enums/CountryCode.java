package com.jumia.enums;

import lombok.Getter;

@Getter
public enum CountryCode {
  CAMEROON("237"), ETHIOPIA("251"), MOROCCO("212"), MOZAMBIQUE("258"), UGANDA("256");

  private String code;

  CountryCode(String code) {
    this.code = code;
  }

  public static CountryCode getEnumByValue(String code) {
    for (CountryCode countryCode : CountryCode.values()) {
      if (countryCode.code.equals(code)) {
        return countryCode;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return code;
  }

}
