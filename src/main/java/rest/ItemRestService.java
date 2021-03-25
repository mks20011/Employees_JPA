package rest;


import model.Person;
import service.IPersonService;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/item")
public class ItemRestService {

    @Inject
    IPersonService iPersonService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPerson() {

        List<Person> personList = iPersonService.getAll();

        if (!personList.isEmpty()) {
            return Response.ok(personList).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        Person person = iPersonService.getById(id);
        if (person != null) {
            return Response.ok(person).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addPerson(@FormParam("name") String name,
                              @FormParam("surName") String surName,
                              @FormParam("skills") String skills) {
        if (iPersonService.add(name, surName, skills)) {
            return Response.ok().status(Response.Status.CREATED).build();
        } else {
            return Response.notModified().build();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updatePerson(@FormParam("name") String name,
                                 @FormParam("surName") String surName,
                                 @FormParam("skills") String skills,
                                 @PathParam("id") int id) {

        if (iPersonService.update(name, surName, skills, id)) {
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id) {
        if (iPersonService.delete(id)) {
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }

}
