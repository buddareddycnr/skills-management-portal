package co.uk.skills.constants;

public enum AccountStatus {
    ACTIVE("Active"),INACTIVE("InActive"),RESTRICTED("Restricted"),PENDING("Pending"),CREATED("Created");
    private String status;
    AccountStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
