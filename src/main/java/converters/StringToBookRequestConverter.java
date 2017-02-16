package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repositories.BookRequestRepository;
import domain.BookRequest;

@Component
@Transactional
public class StringToBookRequestConverter implements Converter<String, BookRequest> {

	@Autowired
	BookRequestRepository bookRequestRepository;

	@Override
	public BookRequest convert(String text) {
		BookRequest result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = bookRequestRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;

	}

}
