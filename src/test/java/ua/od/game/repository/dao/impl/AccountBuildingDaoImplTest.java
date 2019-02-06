package ua.od.game.repository.dao.impl;

import jersey.repackaged.com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.AccountBuildingEntity;
import ua.od.game.repository.dao.AccountBuildingDao;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class AccountBuildingDaoImplTest extends DbTest {
    private AccountBuildingDao buildingDao;

    @Before
    public void init(){ buildingDao = new AccountBuildingDaoImpl(); }

    @Test
    public void getAccountBuildingListTest(){
        Integer accId = 3, buildingId = 14; Float amount = -2f;
        List<AccountBuildingEntity> accountBuildingEntities = buildingDao.getAccountBuildingList(accId);

        System.out.println(accountBuildingEntities.get(0).getBuildingId() + " ");
        System.out.println(accountBuildingEntities.get(0).getAmount() + " ");

        assertFalse(
                (accountBuildingEntities.get(0).getBuildingId() != buildingId) ||
               !(accountBuildingEntities.get(0).getAmount().equals(amount))
        );
    }

    @Test
    public void clearUserBuildingList(){
        assertTrue(buildingDao.clearAccountBuildingList(2));
    }
}
