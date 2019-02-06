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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class AccountBuildingDaoImplTest extends DbTest {
    private AccountBuildingDao buildingDao;

    @Before
    public void init(){ buildingDao = new AccountBuildingDaoImpl(); }

    @Test
    public void getAccountBuildingListTest(){
        List<AccountBuildingEntity> accountBuildingEntities = buildingDao.getAccountBuildingList(1);

        assertFalse(accountBuildingEntities.isEmpty());

        HashSet<AccountBuildingEntity> buildingHashSet = new HashSet<>(accountBuildingEntities);
        assertFalse(buildingHashSet.size() != accountBuildingEntities.size());

        for (int i = 0; i < accountBuildingEntities.size(); i++) {
            System.out.println(accountBuildingEntities.get(i).getBuildingId() + " ");
            System.out.println(accountBuildingEntities.get(i).getAmount() + " ");
            assertFalse(((accountBuildingEntities.get(i).getBuildingId()) == null) ||
                    (accountBuildingEntities.get(i).getAmount() == null));
        }
    }

    @Test
    public void clearUserBuildingList(){
        assertTrue(buildingDao.clearAccountBuildingList(2));
    }
}
