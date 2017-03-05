package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by mruwzum on 3/3/17.
 */

@Entity
@Access(AccessType.PROPERTY)
public class Fee extends DomainEntity{

    private Double value;



    @NotNull
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


}
