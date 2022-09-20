package co.uk.skills.converters;

import co.uk.skills.constants.AccountStatus;
import co.uk.skills.constants.AreaOfInterest;
import co.uk.skills.exception.UnsupportedAreaOfInterestException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class AccountStatusConverter implements AttributeConverter<AccountStatus,String> {
    /**
     * @param accountStatus
     * @return
     */
    @Override
    public String convertToDatabaseColumn(AccountStatus accountStatus) {
        var dbColumnAccountStatus = Arrays.stream(AccountStatus.values()).filter(status ->
                accountStatus.equals(status)).findFirst().orElseThrow(() ->
                new UnsupportedAreaOfInterestException("Please verify the account status which you passed, Allowed values are Active,InActive,Restricted,Pending,Created"));
        return dbColumnAccountStatus.toString();
    }

    /**
     * @param status
     * @return
     */
    @Override
    public AccountStatus convertToEntityAttribute(String status) {
        return Arrays.stream(AccountStatus.values()).filter(accountStatus ->
                status.equals(accountStatus.toString())).findFirst().orElseThrow(() ->
                new UnsupportedAreaOfInterestException("Please verify the account status which you passed, Allowed values are Active,InActive,Restricted,Pending,Created"));

    }
}
