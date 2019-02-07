package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.AccountResourceEntity;
import ua.od.game.repository.dao.AccountResourceDao;
import ua.od.game.repository.dao.DbTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AccountResourceDaoImplTest extends DbTest {
    private AccountResourceDao resourceDao;

    @Before
    public void init(){ resourceDao = new AccountResourceDaoImpl(); }

    @Test
    public void getAccountResourceListTest(){
        List<AccountResourceEntity> accountResourceEntities = resourceDao.getAccountResourceList(4);
        assertFalse(accountResourceEntities.isEmpty());

        for (AccountResourceEntity i: accountResourceEntities) {
            System.out.println(i.getResourceId() + " ");
            System.out.println(i.getAmount() + " ");
            assertFalse(((i.getResourceId()) == null) || (i.getAmount() == null));
        }

        assertEquals(accountResourceEntities.size(), accountResourceEntities.stream().map(AccountResourceEntity::getId).collect(Collectors.toSet()).size());

    }

    @Test
    public void clearUserResourceList(){
        assertTrue(resourceDao.clearAccountResourceList(2));
    }
}