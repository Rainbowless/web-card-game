package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.AccountBuildingEntity;
import ua.od.game.repository.dao.AccountBuildingDao;
import ua.od.game.repository.dao.DbTest;

import java.util.HashSet;
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
        HashSet<Integer> buildingHashSet = new HashSet<>();

        for (int i = 0; i < accountBuildingEntities.size(); i++) {
            System.out.println(accountBuildingEntities.get(i).getBuildingId() + " ");
            System.out.println(accountBuildingEntities.get(i).getAmount() + " ");
            assertFalse(((accountBuildingEntities.get(i).getBuildingId()) == null) ||
                        (accountBuildingEntities.get(i).getAmount() == null));
            buildingHashSet.add(accountBuildingEntities.get(i).getId());
            }

        assertFalse(buildingHashSet.size() != accountBuildingEntities.size());
    }

        @Test
    public void clearUserBuildingList(){
        assertTrue(buildingDao.clearAccountBuildingList(2));
    }
}
