package com.github.savvyer.keycloak.requiredactions;

import org.keycloak.Config;
import org.keycloak.authentication.RequiredActionFactory;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.authentication.RequiredActionContext;


public class Redirect implements RequiredActionProvider, RequiredActionFactory {
  private String redirectUrl;
  public static final String CONFIG_REDIRECT_URL = "redirect-url";
  public static final String DEFAULT_REDIRECT_URL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";

  @Override
  public RequiredActionProvider create(KeycloakSession session) {
    return this;
  }

  @Override
  public String getId() {
    return "REDIRECT";
  }

  @Override
  public String getDisplayText() {
      return "Redirect";
  }

  @Override
  public void init(Config.Scope config) {
    redirectUrl = config.get(CONFIG_REDIRECT_URL, DEFAULT_REDIRECT_URL);
  }

  @Override
  public void postInit(KeycloakSessionFactory factory) {}

  @Override
  public void close() {}


  @Override
  public void evaluateTriggers(RequiredActionContext context) {
  }

  @Override
  public void requiredActionChallenge(RequiredActionContext context) {
    context
      .getAuthenticationSession()
      .setRedirectUri(redirectUrl);

    // To trigger the redirect only once after the first login,  
    // mark this required action as executed and remove it from the user's required actions list.  
    // Uncomment the line below to enable this behavior.  
    // context.success();
  }

  @Override
  public void processAction(RequiredActionContext context) {}
}