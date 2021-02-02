package startingApp.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

import startingApp.model.CurrenciesProperties;

@Service
@Configurable
public class ConfigurationFiles {

	public ConfigurationFiles() {
	}

	public ConfigurationFiles(AnnotationConfigApplicationContext context) {
		this.context = context;
	}

	private AnnotationConfigApplicationContext context = null;

	public ConfigurableEnvironment properties() {
		if (context == null) {
			context = new AnnotationConfigApplicationContext();
			context.register(CurrenciesProperties.class);
			context.refresh();
		}
		return context.getEnvironment();
	}

}
