package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Date;

@Component
@Transactional
public class DateToStringConverter implements Converter<Date, String> {

	@Override
	public String convert(Date date) {
		Assert.notNull(date);
		String result;
		result = String.valueOf(date.getId());
		return result;
	}

}