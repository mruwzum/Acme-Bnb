package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Lessor;

@Component
@Transactional
public class LessorToStringConverter implements Converter<Lessor, String> {

	@Override
	public String convert(Lessor lessor) {
		Assert.notNull(lessor);
		String result;
		result = String.valueOf(lessor.getId());
		return result;
	}

}