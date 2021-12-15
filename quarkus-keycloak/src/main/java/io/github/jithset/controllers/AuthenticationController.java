package io.github.jithset.controllers;

import io.github.jithset.dto.LoginDTO;
import io.github.jithset.dto.TokenDTO;
import io.github.jithset.services.AuthenticationService;
import io.quarkus.security.UnauthorizedException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @POST
    @Path("/login")
    public Response login(@Valid LoginDTO loginDto) {
        try {
            String token = authenticationService.authenticate(loginDto.getUsername(), loginDto.getPassword());
            return Response.ok().entity(new TokenDTO(token)).build();
        } catch (SecurityException e) {
            throw new UnauthorizedException("Wrong username or password");
        }
    }
}
