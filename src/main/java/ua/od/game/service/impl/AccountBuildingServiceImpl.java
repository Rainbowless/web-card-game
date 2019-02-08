package ua.od.game.service.impl;

import ua.od.game.dto.AccountBuildingDto;
import ua.od.game.repository.dao.AccountBuildingDao;
import ua.od.game.service.AccountBuildingService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountBuildingServiceImpl implements AccountBuildingService {

    @Inject
    private AccountBuildingDao accountBuildingDao;

    @Override
    public List<AccountBuildingDto> getUserBuildingList(Integer accountId) {
        final List<AccountBuildingDto> accountBuildingDtos = new LinkedList<>();
        accountBuildingDao.getAccountBuildingList(accountId).forEach(accountBuildingEntity -> accountBuildingDtos.add(new AccountBuildingDto() {{
            setBuildingId(accountBuildingEntity.getBuildingId());
            setAmount(accountBuildingEntity.getAmount());
        }}));
        return accountBuildingDtos;
    }

    @Override
    public Boolean clearUserBuildingList(Integer accountId) {
        return accountBuildingDao.clearAccountBuildingList(accountId);
    }
}