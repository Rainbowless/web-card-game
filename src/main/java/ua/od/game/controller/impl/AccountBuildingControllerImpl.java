package ua.od.game.controller.impl;

import ua.od.game.controller.AccountBuildingController;
import ua.od.game.dto.AccountBuildingDto;
import ua.od.game.service.AccountBuildingService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/account/building")
public class AccountBuildingControllerImpl implements AccountBuildingController {

    @Inject
    private AccountBuildingService accountBuildingService;

    @GET
    @Path("{accountId}")
    public List<AccountBuildingDto> getAccountBuildingList(@PathParam("accountId") Integer accountId) {
        return accountBuildingService.getUserBuildingList(accountId);
    }

    @GET
    @Path("{accountId}/clear")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response clearAccountBuildingList(@PathParam("accountId") Integer accountId) {
        if (accountBuildingService.clearUserBuildingList(accountId))
             return Response.status(200).entity("Building list clean").build();
        else return Response.status(418).entity("Error").build();
    }
}