package com.session.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @RequestMapping(value = "/login")
  public String loginPage(HttpServletRequest request, @Valid @ModelAttribute AuthenticationModel model, BindingResult result) {
    if (!result.hasErrors()) {
      request.getSession().setAttribute("redirect", model.getRedirect());
      request.getSession().setAttribute("custom", model.getCustom());
      return "login";
    }
    throw new InvalidRequestException("Invalid values for query parameters 'redirect' or 'custom'");
  }

  @RequestMapping(value = "/oauth/confirm_access")
  public String authorizePage() {
    return "authorize";
  }

}
