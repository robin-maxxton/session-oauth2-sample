package com.session.sample.controller;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Model used on the login page
 */
public class AuthenticationModel {

  @Pattern(regexp = "^/([^/].*)?$")
  @NotBlank
  private String redirect;

  @Pattern(regexp = "^[A-Za-z]+$")
  @NotBlank
  private String custom;

  public String getRedirect() {
    return redirect;
  }

  public void setRedirect(String redirect) {
    this.redirect = redirect;
  }

  public String getCustom() {
    return custom;
  }

  public void setCustom(String custom) {
    this.custom = custom;
  }
}
