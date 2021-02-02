package startingApp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import startingApp.configuration.ConfigurationFiles;
import startingApp.model.CurrenciesInDate;
import startingApp.model.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MapperCurrenciesRate {

	private Map<String, List<Currency>> map = new HashMap<String, List<Currency>>();

	@Autowired
	ConfigurationFiles configuration;

	private static Logger logger = LoggerFactory.getLogger(CurrenciesInDate.class);

	public Map<String, List<Currency>> getMap() {
		mapping();
		return map;
	}

	public List<CurrenciesInDate> getListCurrenciesInDate() {
		List<CurrenciesInDate> listCurrenciesInDate = this.getMap().entrySet().stream()
				.map((Function<? super Entry<String, List<Currency>>, ? extends CurrenciesInDate>) entry -> {
					CurrenciesInDate currenciesInDate = new CurrenciesInDate();
					currenciesInDate.setDate(entry.getKey());
					entry.getValue().forEach(x -> {
						switch (x.getNameCurrency()) {
						case "EUR":
							currenciesInDate.setEur(x.getRate());
							break;
						case "USD":
							currenciesInDate.setUsd(x.getRate());
							break;
						case "GBP":
							currenciesInDate.setGbp(x.getRate());
							break;
						case "NZD":
							currenciesInDate.setNzd(x.getRate());
							break;
						case "AUD":
							currenciesInDate.setAud(x.getRate());
							break;
						case "JPY":
							currenciesInDate.setJpy(x.getRate());
							break;

						default:
							break;
						}

					});
					return currenciesInDate;

				}).collect(Collectors.toList());

		Collections.sort(listCurrenciesInDate, (x, y) -> y.getDate().compareTo(x.getDate()));
		return listCurrenciesInDate;
	}

	public void mapping() {
		String currenties = this.configuration.properties().getProperty("list");
		int counter = 0;
		while (counter <= 10) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = GregorianCalendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -counter);
			URL urlForGetRequest = null;
			try {
				urlForGetRequest = new URL("http://apilayer.net/api/historical?date=" + df.format(cal.getTime())
						+ "&access_key=e7b27c4429d02a693b656f85441f82f2&currencies=" + currenties
						+ "&source=USD&format=1");
			} catch (MalformedURLException e1) {
				logger.error("An ERROR Message", e1);
			}
			String readLine = null;

			try {
				HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
				connection.setRequestMethod("GET");
				int responseCode = connection.getResponseCode();

				if (responseCode == HttpURLConnection.HTTP_OK) {

					BufferedReader in = new BufferedReader(

							new InputStreamReader(connection.getInputStream()));

					StringBuffer response = new StringBuffer();

					while ((readLine = in.readLine()) != null) {

						response.append(readLine + "\r\n");

					}
					in.close();

					ObjectMapper objectMapper = new ObjectMapper();
					JsonNode node = objectMapper.readTree(response.toString());
					JsonNode locatedNode = node.path("quotes");
					JsonNode currentDate = node.path("date");
					List<Currency> listCurrency = new ArrayList<Currency>();
					locatedNode.fieldNames().forEachRemaining(x -> {
						listCurrency.add(new Currency(x.substring(3, x.length()), locatedNode.get(x).asDouble()));
					});
					map.put(currentDate.asText(), listCurrency);
				} else {
					logger.error("An ERROR Message: Connection wasn`t worked!");

				}
			} catch (ProtocolException e) {
				logger.error("An ERROR Message", e);
			} catch (IOException e) {
				logger.error("An ERROR Message", e);
			}
			counter++;
		}
	}

}
