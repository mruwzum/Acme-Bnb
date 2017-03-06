package services;

import domain.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repositories.AttributeRepository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by daviddelatorre on 6/3/17.
 */
@Service
@Transactional
public class AttributeService {


    // Managed Repository ------------------------
    @Autowired
    private AttributeRepository attributeRepository;

    // Constructor -------------------------------
    public AttributeService() {
        super();
    }

    // Supporting services -----------------------

    // Simple CRUD methods -----------------------

    public Attribute create() {
        return new Attribute();
    }

    public Attribute findOne(int valueId) {
        Attribute result;

        result = attributeRepository.findOne(valueId);

        return result;
    }

    public Collection<Attribute> findAll() {
        Collection<Attribute> result;

        result = attributeRepository.findAll();

        return result;
    }

    public Attribute save(Attribute attribute) {
        Assert.notNull(attribute);
        return attributeRepository.save(attribute);
    }

    public void delete(Attribute attribute) {
        Assert.notNull(attribute);
        Assert.isTrue(attributeRepository.exists(attribute.getId()));
        attributeRepository.delete(attribute);
    }

    // Other business methods -----------------------


}
