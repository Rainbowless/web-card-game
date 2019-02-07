package ua.od.game.repository.dao.impl;

import ua.od.game.model.AccountResourceEntity;
import ua.od.game.repository.dao.AccountResourceDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class AccountResourceDaoImpl implements AccountResourceDao {

    private static final String GET_ACCOUNT_RESOURCE_LIST = "SELECT * FROM Account_Resource WHERE account_id = ?";
    private static final String CLEAR_ACCOUNT_RESOURCE_LIST = "DELETE FROM Account_Resource WHERE account_id = ?";

    @Override
    public List<AccountResourceEntity> getAccountResourceList(Integer accountId) {
        return SqlHelper.prepareStatement(GET_ACCOUNT_RESOURCE_LIST, query -> {
            query.setInt(1, accountId);
            ResultSet resultSet = query.executeQuery();
            List<AccountResourceEntity> result = new LinkedList<>();
            while (resultSet.next()) {
                result.add(new AccountResourceEntity() {{
                    setResourceId(resultSet.getInt("resource_id"));
                    setAmount(resultSet.getFloat("amount"));
                }});
            }
            return result;
        });
    }

    @Override
    public Boolean clearAccountResourceList(Integer accountId) {
        return SqlHelper.prepareStatement(CLEAR_ACCOUNT_RESOURCE_LIST, query -> {
            query.setInt(1, accountId);
            query.executeUpdate();
            return true;
        });
    }
}