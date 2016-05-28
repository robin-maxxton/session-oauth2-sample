package com.session.sample.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Entry point for building up the redirect
 */
public class AuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

  public AuthenticationEntryPoint(String loginFormUrl) {
    super(loginFormUrl);
  }

  @Override
  protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
    String redirectParamValue = UrlUtils.buildRequestUrl(request);
    String redirect = super.determineUrlToUseForThisRequest(request, response, exception);
    return UriComponentsBuilder.fromPath(redirect).queryParam("redirect", redirectParamValue).toUriString();
  }
}
