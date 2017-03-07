package converters;

import domain.Actor;
import domain.Administrator;
import domain.Attribute;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component
@Transactional
public class AttributeToStringConverter implements Converter<Attribute, String> {

	@Override
	public String convert(Attribute attribute) {
		Assert.notNull(attribute);
		String result;
		result = String.valueOf(attribute.getId());
		return result;
	}

}