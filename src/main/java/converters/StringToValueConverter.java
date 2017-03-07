package converters;

import domain.Invoice;
import domain.Value;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import repositories.InvoiceRepository;
import repositories.ValueRepository;

@Component
@Transactional
public class StringToValueConverter implements Converter<String, Value> {

	@Autowired
	ValueRepository valueRepository;

	@Override
	public Value convert(String text) {
		Value result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = valueRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;

	}

}
