package converters;

import domain.Attribute;
import domain.Finder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Attr;
import repositories.AttributeRepository;
import repositories.FinderRepository;

@Component
@Transactional
public class StringToAttributeConverter implements Converter<String, Attribute> {

	@Autowired
	AttributeRepository attributeRepository;

	@Override
	public Attribute convert(String text) {
		Attribute result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = attributeRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;

	}

}
