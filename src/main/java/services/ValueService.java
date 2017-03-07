package services;

import domain.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repositories.ValueRepository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by daviddelatorre on 6/3/17.
 */
@Service
@Transactional
public class ValueService {

    // Managed Repository ------------------------
    @Autowired
    private ValueRepository valueRepository;

    // Constructor -------------------------------
    public ValueService() {
        super();
    }

    // Supporting services -----------------------

    // Simple CRUD methods -----------------------

    public Value create() {
        return new Value();
    }

    public Value findOne(int valueId) {
        Value result;

        result = valueRepository.findOne(valueId);

        return result;
    }

    public Collection<Value> findAll() {
        Collection<Value> result;

        result = valueRepository.findAll();

        return result;
    }

    public Value save(Value value) {
        Assert.notNull(value);
        return valueRepository.save(value);
    }

    public void delete(Value value) {
        Assert.notNull(value);
        Assert.isTrue(valueRepository.exists(value.getId()));
        valueRepository.delete(value);
    }

    // Other business methods -----------------------

}
