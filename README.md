# Keycloak Required Action Redirect
This is a simple keycloak extension which implements the keycloak required action SPI. This extension allows you to redirect users to the specified URL after successful login.

![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/savvyer/keycloak-required-action-redirect?sort=semver)
![GitHub Release Date](https://img.shields.io/github/release-date-pre/savvyer/keycloak-required-action-redirect)
![Github Last Commit](https://img.shields.io/github/last-commit/savvyer/keycloak-required-action-redirect)

## What is it good for?
Keycloak does not provide built-in support for differentiating between a first-time login (registration) and a regular login when handling redirect URLs. By default, both scenarios follow the same authentication flow, making it difficult to direct new users to a specific onboarding page while allowing returning users to proceed normally.
This keycloak extenstion solves described limitaton by assigning required action to all new registered users.
After that you can follow two paths:
* Redirect user once on the first login, required action is marked as executed and all other logins will follow default redirect.
* Redirect user for each login, until you manually remove required action for the user either using keycloak API or keycloak admin interface.

## How to install?

Download a release (*.jar file) that works with your Keycloak version from the [list of releases](https://github.com/savvyer/keycloak-required-action-redirect/releases).
Follow the below instructions depending on your distribution and runtime environment.

### Standalone (without container)

Copy the jar to the `providers` folder and execute the following command:

```shell
${kc.home.dir}/bin/kc.sh build
```

### Container image (Docker)

For Docker-based setups mount or copy the jar to `/opt/keycloak/providers`.

If you are using RedHat SSO instead of Keycloak open source, mount or copy the jar to `/opt/eap/providers/`.

```
volumes:
      - ./keycloak-redirect-26.1.0.jar:/opt/keycloak/providers/keycloak-redirect-26.1.0.jar
```

## How to configure?

```properties
spi-required-action-REDIRECT-redirect-url=https://google.com
```

For details on SPI and provider configuration, please refer to [Configuring providers](https://www.keycloak.org/server/configuration-provider) guide.

To enable this extension:
* Go to your realm
* On the left navigation block click `Authentication`
* Select `Required actions` tab
* Find and enable `Redirect` action
* Set as default action

Every new user will have this required action assigned to them.

To assign this required action to specific user:
* Go to your realm
* On the left navigation block click `Users`
* Find and select a user
* On the `Details` tab of the selected user find `Required user actions` input
* Find and add `Redirect` action

## How to build locally?
Run following commands\
```
docker build -t keycloak-redirect .
```
```
docker run --rm -v ./output:/app/output keycloak-redirect
```
You will find `jar` in the `output` folder
