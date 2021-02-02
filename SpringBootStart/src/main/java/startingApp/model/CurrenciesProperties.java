package startingApp.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ConfigurationProperties
@PropertySource(value = { "classpath:currencies.properties" })
public class CurrenciesProperties implements ListOfCurrencies {

	private String list;

	@Override
	public String getList() {
		return list;
	}

	public CurrenciesProperties() {
	}

	public CurrenciesProperties(String list) {
		this.list = list;
	}

	public void setList(String list) {
		this.list = list;
	}

}
