package com.session.sample.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * Used to redirect the user back to the original URL
 */
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Override
  protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
    return request.getSession().getAttribute("redirect").toString();
  }

}
