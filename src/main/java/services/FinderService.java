package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Finder;
import repositories.FinderRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class FinderService {

	// Managed Repository ------------------------
	@Autowired
	private FinderRepository finderRepository;
    @Autowired
    private PropertyService propertyService;

	// Constructor -------------------------------
	public FinderService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Finder create() {
		return new Finder();
	}

	public Finder findOne(int finderId) {
		Finder result;

		result = finderRepository.findOne(finderId);

		return result;
	}

	public Collection<Finder> findAll() {
		Collection<Finder> result;

		result = finderRepository.findAll();

		return result;
	}

	public Finder save(Finder finder) {
		Assert.notNull(finder);
		return finderRepository.save(finder);
	}
	
	public void delete(Finder finder) {
		Assert.notNull(finder);
		Assert.isTrue(finderRepository.exists(finder.getId()));
		finderRepository.delete(finder);
	}



	// Other business methods -----------------------

	public List<Property> finder(String city, Double max, Double min, String keyword){
        List<Property> properties = new ArrayList<>(propertyService.findAll());
        List<Property> aux = new ArrayList<>();
        for (Property p : properties){
            if (p.getCity().equals(city)||p.getRate()<max && p.getRate()>min && containsKey(properties,keyword)){
                   aux.add(p);
               }
            }
            return aux;

	}
	private Boolean containsKey(List<Property> properties, String keyword){
            Boolean res = false;
            for (Property p : properties){
                if (p.getName().contains(keyword) || p.getDescription().contains(keyword) || p.getAddress().contains(keyword)){
                    res = true;
                }
            }
            return res;
    }

}