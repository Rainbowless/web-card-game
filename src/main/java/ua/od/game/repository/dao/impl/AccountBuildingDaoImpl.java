package ua.od.game.repository.dao.impl;

import ua.od.game.model.AccountBuildingEntity;
import ua.od.game.repository.dao.AccountBuildingDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class AccountBuildingDaoImpl implements AccountBuildingDao {

    private static final String GET_ACCOUNT_BUILDING_LIST = "SELECT * FROM Account_Building WHERE account_id = ?";
    private static final String CLEAR_ACCOUNT_BUILDING_LIST = "DELETE FROM Account_Building WHERE account_id = ?";

    @Override
    public List<AccountBuildingEntity> getAccountBuildingList(Integer accountId) {
        return SqlHelper.prepareStatement(GET_ACCOUNT_BUILDING_LIST, query -> {
            query.setInt(1, accountId);
            ResultSet resultSet = query.executeQuery();
            List<AccountBuildingEntity> result = new LinkedList<>();
            while (resultSet.next()) {
                result.add(new AccountBuildingEntity() {{
                    setBuildingId(resultSet.getInt("building_id"));
                    setAmount(resultSet.getFloat("amount"));
                }});
            }
            return result;
        });
    }

    @Override
    public Boolean clearAccountBuildingList(Integer accountId) {
        return SqlHelper.prepareStatement(CLEAR_ACCOUNT_BUILDING_LIST, query -> {
            query.setInt(1, accountId);
            query.executeUpdate();
            return true;
        });
    }
}
