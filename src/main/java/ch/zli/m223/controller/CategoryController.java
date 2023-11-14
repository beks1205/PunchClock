// package ch.zli.m223.controller;

// import java.util.List;

// import javax.inject.Inject;
// import javax.ws.rs.Consumes;
// import javax.ws.rs.DELETE;
// import javax.ws.rs.GET;
// import javax.ws.rs.PATCH;
// import javax.ws.rs.POST;
// import javax.ws.rs.Path;
// import javax.ws.rs.core.Response.Status;
// import javax.ws.rs.PathParam;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response;

// import org.eclipse.microprofile.openapi.annotations.Operation;
// import org.eclipse.microprofile.openapi.annotations.tags.Tag;

// import ch.zli.m223.model.Entry;
// import ch.zli.m223.service.EntryService;

// @Path("/entries")
// @Tag(name = "Entries", description = "Handling of entries")
// public class CategoryController {

// @Inject
// EntryService entryService;

// @GET
// @Produces(MediaType.APPLICATION_JSON)
// @Operation(summary = "Index all Entries.", description = "Returns a list of
// all entries.")
// public List<Entry> index() {
// return entryService.findAll();
// }

// @POST
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// @Operation(summary = "Creates a new entry.", description = "Creates a new
// entry and returns the newly added entry.")
// public Entry create(Entry entry) {
// var responseEntry = entryService.createEntry(entry);
// if (responseEntry == null) {
// Response.status(Status.BAD_REQUEST).build();
// }
// return responseEntry;
// }

// @DELETE
// @Path("{id}")
// @Produces(MediaType.APPLICATION_JSON)
// public Entry delete(@PathParam("id") Long id) {
// return entryService.deleteEntry(id);
// }

// @PATCH
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public Entry edit(Entry entry) {
// return entryService.updateEntry(entry);
// }

// }
