package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Tenant;

@Component
@Transactional
public class TenantToStringConverter implements Converter<Tenant, String> {

	@Override
	public String convert(Tenant tenant) {
		Assert.notNull(tenant);
		String result;
		result = String.valueOf(tenant.getId());
		return result;
	}

}