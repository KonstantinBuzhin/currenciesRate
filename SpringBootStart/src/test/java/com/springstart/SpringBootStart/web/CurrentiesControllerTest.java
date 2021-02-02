package com.springstart.SpringBootStart.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import startingApp.model.CurrenciesInDate;
import startingApp.service.MapperCurrenciesRate;
import startingApp.web.CurrenciesController;

@WebMvcTest(controllers = CurrenciesController.class)
@ActiveProfiles("test")
public class CurrentiesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MapperCurrenciesRate mapper;

//	@Test
//	public void greetingShouldReturnMessageFromService() throws Exception {
//		List<CurrenciesInDate> list = new ArrayList<CurrenciesInDate>();
//		list.add(new CurrenciesInDate("2020-01-31", 10.10, 1, 10.10, 10.10, 10.10, 10.10));
//		Mockito.when(mapper.getListCurrenciesInDate()).thenReturn(list);
//		MvcResult result = this.mockMvc.perform(get("/api/currentiesRate")).andExpect(status().isOk()).andReturn();
//		this.mockMvc.perform(asyncDispatch(result)).andExpect(status().isInternalServerError()).andReturn();
//	}

	private List<CurrenciesInDate> list;

	@BeforeEach
	void setUp() {
		this.list = new ArrayList<>();
		this.list.add(new CurrenciesInDate("2020-01-31", 10.10, 1, 10.10, 10.10, 10.10, 10.10));
		this.list.add(new CurrenciesInDate("2020-01-30", 10.10, 1, 10.10, 10.10, 10.10, 10.10));
		this.list.add(new CurrenciesInDate("2020-01-29", 10.10, 1, 10.10, 10.10, 10.10, 10.10));

	}
	
	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {

		this.mockMvc.perform(get("/api/currentiesRate", "2020-01-31")).andExpect(status().isOk());
//		this.mockMvc.perform(asyncDispatch(result)).andExpect(status().isInternalServerError()).andReturn();
	}

}
