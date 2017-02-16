package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.BookRequest;

@Component
@Transactional
public class BookRequestToStringConverter implements Converter<BookRequest, String> {

	@Override
	public String convert(BookRequest bookRequest) {
		Assert.notNull(bookRequest);
		String result;
		result = String.valueOf(bookRequest.getId());
		return result;
	}

}