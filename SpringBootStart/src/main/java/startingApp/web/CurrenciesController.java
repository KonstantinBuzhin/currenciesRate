package startingApp.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import startingApp.model.CurrenciesInDate;
import startingApp.service.MapperCurrenciesRate;

@RestController
@RequestMapping("/api/currenciesRate")
public class CurrenciesController {

	@Autowired
	private MapperCurrenciesRate mapper;

	@RequestMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<CurrenciesInDate> getListOfCurrenciesInDate() {
		return mapper.getListCurrenciesInDate();
	}
}
