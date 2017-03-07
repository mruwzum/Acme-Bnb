package converters;

import domain.Actor;
import domain.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component
@Transactional
public class ValueToStringConverter implements Converter<Value, String> {

	@Override
	public String convert(Value actor) {
		Assert.notNull(actor);
		String result;
		result = String.valueOf(actor.getId());
		return result;
	}

}