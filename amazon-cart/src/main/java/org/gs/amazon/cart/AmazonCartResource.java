package org.gs.amazon.cart;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Path("/api/cart")
@ApplicationScoped
public class AmazonCartResource {
    List<AmazonItem> items = new ArrayList<>();

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
        return Response.ok(items).build();
    }

    @POST
    @RolesAllowed({"admin", "writer"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItem(AmazonItem newItem) {
        items.add(newItem);
        return Response.ok(items).build();
    }

    @DELETE
    @RolesAllowed({"admin"})
    @Path("{id}")
    public Response deleteItem(@PathParam("id") Long id) {
        items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .ifPresent(item -> items.remove(item));
        return Response.noContent().build();
    }

}
