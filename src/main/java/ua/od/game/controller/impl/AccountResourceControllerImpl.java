package ua.od.game.controller.impl;

import ua.od.game.controller.AccountResourceController;
import ua.od.game.dto.AccountResourceDto;
import ua.od.game.service.AccountResourceService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/account/resource")
public class AccountResourceControllerImpl implements AccountResourceController {

    @Inject
    private AccountResourceService accountResourceService;

    @GET
    @Path("{accountId}")
    public List<AccountResourceDto> getAccountResourceList(@PathParam("accountId") Integer accountId) {
        return accountResourceService.getAccountResourceList(accountId);
    }

    @GET
    @Path("{accountId}/clear")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response clearAccountResourceList(@PathParam("accountId") Integer accountId) {
        if (accountResourceService.clearAccountResourceList(accountId))
            return Response.status(200).entity("Resource list clean").build();
        else return Response.status(418).entity("Error").build();
    }
}