package ua.od.game.model;

public class AccountBuildingEntity {
    private Integer id;
    private Integer buildingId;
    private Integer accountBuildingId;
    private Float amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getAccountBuildingId() {
        return accountBuildingId;
    }

    public void setAccountBuildingId(Integer accountBuildingId) { this.accountBuildingId = accountBuildingId; }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
