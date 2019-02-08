package ua.od.game.service.impl;

import ua.od.game.dto.AccountResourceDto;
import ua.od.game.repository.dao.AccountResourceDao;
import ua.od.game.service.AccountResourceService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountResourceServiceImpl implements AccountResourceService {

    @Inject
    private AccountResourceDao accountResourceDao;

    @Override
    public List<AccountResourceDto> getAccountResourceList(Integer accountId) {
        final List<AccountResourceDto> accountResourceDtos = new LinkedList<>();
        accountResourceDao.getAccountResourceList(accountId).forEach(accountResourceEntity -> accountResourceDtos.add(new AccountResourceDto() {{
            setResourceId(accountResourceEntity.getResourceId());
            setAmount(accountResourceEntity.getAmount());
        }}));
        return accountResourceDtos;
    }

    @Override
    public Boolean clearAccountResourceList(Integer accountId) {
        return accountResourceDao.clearAccountResourceList(accountId);
    }
}
