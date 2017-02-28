package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Invoice;
import repositories.InvoiceRepository;

@Service
@Transactional
public class InvoiceService {

	// Managed Repository ------------------------
	@Autowired
	private InvoiceRepository invoiceRepository;

	// Constructor -------------------------------
	public InvoiceService() {
		super();
	}

	// Supporting services -----------------------

	// Simple CRUD methods -----------------------
	
	public Invoice create() {
		return new Invoice();
	}

	public Invoice findOne(int invoiceId) {
		Invoice result;

		result = invoiceRepository.findOne(invoiceId);

		return result;
	}

	public Collection<Invoice> findAll() {
		Collection<Invoice> result;

		result = invoiceRepository.findAll();

		return result;
	}

	public Invoice save(Invoice invoice) {
		Assert.notNull(invoice);
		return invoiceRepository.save(invoice);
	}
	
	public void delete(Invoice invoice) {
		Assert.notNull(invoice);
		Assert.isTrue(invoiceRepository.exists(invoice.getId()));
		invoiceRepository.delete(invoice);
	}

	// Other business methods -----------------------

}