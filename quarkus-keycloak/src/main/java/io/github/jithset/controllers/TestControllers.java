package io.github.jithset.controllers;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("test")
public class TestControllers {


    @RolesAllowed(value = {"ROLE_ADMIN", "ROLE_USER", "ROLE_SUPER_ADMIN"})
    @GET
    @Path("/superadmin")
    public Response superadminRes() {
        return Response.ok("SuperAdmin").build();
    }

    @GET
    @Path("/admin")

    @RolesAllowed(value = {"ROLE_SUPER_ADMIN"})
    public Response adminRes() {
        return Response.ok("SuperAdmin").build();
    }

    @GET
    @Path("/users")
    @RolesAllowed(value = {"ROLE_USER"})
    public Response usersRes() {
        return Response.ok("Users").build();
    }
}
