package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.AccountBuildingEntity;
import ua.od.game.repository.dao.AccountBuildingDao;
import ua.od.game.repository.dao.DbTest;

import java.util.List;

import static org.junit.Assert.*;

public class AccountBuildingDaoImplTest extends DbTest {
    private AccountBuildingDao buildingDao;

    @Before
    public void init(){ buildingDao = new AccountBuildingDaoImpl(); }

    @Test
    public void getUserBuildingList(){

        List<AccountBuildingEntity> accountBuildingEntities = buildingDao.getAccountBuildingList(3);

        for (int i = 0; i < accountBuildingEntities.size(); i++) {
            System.out.println(accountBuildingEntities.get(i).getId() + " ");
            System.out.println(accountBuildingEntities.get(i).getAccountBuildingId() + " ");
            System.out.println(accountBuildingEntities.get(i).getBuildingId() + " ");
            System.out.println(accountBuildingEntities.get(i).getAmount() + " ");
        }
        assertFalse(accountBuildingEntities.isEmpty());
    }

    @Test
    public void clearUserBuildingList(){
        assertTrue(buildingDao.clearAccountBuildingList(2));
    }
}
