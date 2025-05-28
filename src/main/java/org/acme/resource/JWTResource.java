package org.acme.resource;


import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.User;

import java.time.Duration;
@Path("/auth")
public class JWTResource {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        String token = Jwt.issuer("http://localhost")
                .audience("exampleAudience")
                .upn(user.getEmail())
                .subject(user.getName())
                .groups(user.getRoles())
                .claim("phone", user.getPhone())
                .claim("address", user.getAddress())
                .claim("country", user.getCountry())
                .claim("dealer", user.getDealer())
                .expiresIn(Duration.ofMinutes(2))
                .sign();

        return Response.ok(token).build();
    }
}
