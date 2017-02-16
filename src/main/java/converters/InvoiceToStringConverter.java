package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Invoice;

@Component
@Transactional
public class InvoiceToStringConverter implements Converter<Invoice, String> {

	@Override
	public String convert(Invoice invoice) {
		Assert.notNull(invoice);
		String result;
		result = String.valueOf(invoice.getId());
		return result;
	}

}