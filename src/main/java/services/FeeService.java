package services;

import domain.Fee;
import domain.Finder;
import domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repositories.FeeRepository;
import repositories.FinderRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class FeeService {

	// Managed Repository ------------------------
	@Autowired
	private FeeRepository feeRepository;


	// Constructor -------------------------------
	public FeeService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Fee create() {
		return new Fee();
	}

	public Fee findOne(int feeId) {
		Fee result;

		result = feeRepository.findOne(feeId);

		return result;
	}

	public Collection<Fee> findAll() {
		Collection<Fee> result;

		result = feeRepository.findAll();

		return result;
	}

	public Fee save(Fee finder) {
		Assert.notNull(finder);
		return feeRepository.save(finder);
	}
	
	public void delete(Fee finder) {
		Assert.notNull(finder);
		Assert.isTrue(feeRepository.exists(finder.getId()));
		feeRepository.delete(finder);
	}





}