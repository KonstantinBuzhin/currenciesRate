package com.springstart.SpringBootStart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import startingApp.SpringBootStartApplication;
import startingApp.configuration.ConfigurationFiles;
import startingApp.model.CurrenciesInDate;
import startingApp.model.User;
import startingApp.service.RegistrationRepository;

@SpringBootTest(classes = SpringBootStartApplication.class)
class SpringBootStartApplicationTests {

	@Autowired
	private RegistrationRepository repository;

	@Autowired
	private ConfigurationFiles configuration;

	private static Logger logger = LoggerFactory.getLogger(CurrenciesInDate.class);

	@Test
	public void checkCurrencyAPI() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = GregorianCalendar.getInstance();

		URL urlForGetRequest = null;
		try {
			urlForGetRequest = new URL("http://apilayer.net/api/historical?date=" + df.format(cal.getTime())
					+ "&access_key=e7b27c4429d02a693b656f85441f82f2&currencies="
					+ configuration.properties().getProperty("list") + "&source=USD&format=1");
		} catch (MalformedURLException e1) {
			logger.error("An ERROR Message", e1);
		}
		try {
			HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			assertEquals(200, responseCode);
		} catch (Exception e) {
			logger.error("An ERROR Message", e);
		}
	}

	@Test
	void checkConfigurationFiles() {
		assertNotNull(configuration.properties().getProperty("list"));
	}

	@Test
	void checkGettingAllUsers() {
		assertNotNull(repository.findAll());
	}

	@Test
	public void checkGettingUserByEmail() {
		User user = new User(1, "", "", "", "kkostyan@ukr.net", "");
		User found = repository.findByEmail(user.getEmail());
		assertEquals(found.getEmail(), user.getEmail());
	}

	@Test
	public void checkAuthericationByUser() {
		User user = new User(1, "", "", "", "kkostyan@ukr.net", "passs");
		User found = repository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		assertNotNull(found);
	}

}
