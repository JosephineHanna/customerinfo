package com.jumia.enums;

import lombok.Getter;

@Getter
public enum CountryCodeRegex {
  CAMEROON("\\(237\\)\\ ?[2368]\\d{7,8}$"), ETHIOPIA("\\(251\\)\\ ?[1-59]\\d{8}$"), MOROCCO("\\(212\\)\\ ?[5-9]\\d{8}$"), MOZAMBIQUE(
      "\\(258\\)\\ ?[28]\\d{7,8}$"), UGANDA("\\(256\\)\\ ?\\d{9}$");

  private String regex;

  CountryCodeRegex(String regex) {
    this.regex = regex;
  }
}
