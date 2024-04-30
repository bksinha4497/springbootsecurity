Create an Account in Okta
Login / Register to https://developer.okta.com/signup/

Okta is our - Authorization server. It will provide us Access token to access our secured APIs.

Okta internally uses Oauth2.0 as underlying protocol for security implementation.

Okta provides a pre-configured custom authorization server called default.

You can register or login with Google / Github etc.

After successful registration , Next you need to create an application

Click on 3 lines in top left corner there u can see application dropdown

Click on applications


Then click on Create App Integration and  choose the type of authorization method you want to use.

We need API Services
Interact with Okta APIs using the scoped OAuth 2.0 access tokens for machine-to-machine authentication.

Name your application

After that remember to save imp information - such as client credentials, client secrets, and Okta domain id that will be used later for our application



Client Id = Our public identifier to the OAuth flows.

Secret Id = Password for the client ID.

Okta Domain ID = The ID of the organization where our application is located.

Next Go to the Security tab and click on the API section

Here we have the following properties: authorization server name, audience, and issuer URI.

Audience = the claim aud to identify the recipient that the JWT is intended for.

Authorization server name = the name of the authorization server. In this case, I’m using the default one, but you can also create your own authorization server with the proper policies, scope, and claims.

Issuer URL is a unique identifier and a point to provide important metadata about the server, including a request for a token by adding the /v1/token path.

Create Spring Boot Application
Create a Spring boot project

Add Okta starter dependency - okta-spring-boot-starter -  This will add all required classes for securing Spring application

Now we need to configure the API, adding some properties to our application.yml.

Now if you try to run Application - it will create error - Your Okta Issuer URL is missing. You can copy your domain from the Okta Developer Console

okta:
oauth2:
issuer: https://${yourDomainId}/oauth2/default

Now after Securing the Application. Create any controller and rest endpoint.

Secure your Spring Boot Application

You will not be able to access the Get request also with okta implemented

To Test your application now - Try hitting through postman and u can see 401  -  unauthorised

Create Custom scope as “ custom “ in okta.

use it to get token and use that token in apis.

In order for someone to make a request to your API, they need an access token. How an access token is obtained depends on the client making the request