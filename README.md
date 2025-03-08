# Keycloak Required Action Redirect

Redirects user to the specified URL after successful login

### Usage
Download latest `jar`\
Configure docker:

```
volumes:
      - ./keycloak-redirect-26.1.0.jar:/opt/keycloak/providers/keycloak-redirect-26.1.0.jar
```

You can change redirect url without rebuilding this project by adding following config to the docker run command:
```
--spi-required-action-REDIRECT-redirect-url=https://google.com
```

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



### Build
Github release workflow will build a new `jar` once triggered manually from the github actions tab


### Local Build
Run following commands\
```
docker build -t keycloak-redirect .
```
```
docker run --rm -v ./output:/app/output keycloak-redirect
```
You will find `jar` in the `output` folder
