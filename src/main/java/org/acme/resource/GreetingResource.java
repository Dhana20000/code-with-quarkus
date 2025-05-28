package org.acme.resource;

import io.quarkus.security.Authenticated;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.acme.model.User;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.Set;

@Path("/user")
@Authenticated
public class GreetingResource {
    @Inject
    JWTParser jwtParser;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserInfo(@Context SecurityContext securityContext) throws ParseException {
        // Get the JWT principal directly from the SecurityContext
        JsonWebToken jwt = (JsonWebToken) securityContext.getUserPrincipal();

        String name = jwt.getSubject();
        String email = jwt.getClaim("upn");
        String phone = jwt.getClaim("phone");
        String address = jwt.getClaim("address");
        String country = jwt.getClaim("country");
        String dealer = jwt.getClaim("dealer");
        Set<String> roles = jwt.getGroups();

        return new User(name, phone, address, email, country, dealer, roles);
    }


}
