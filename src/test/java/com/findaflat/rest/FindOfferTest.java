package com.findaflat.rest;

import com.findaflat.model.Offer;
import com.findaflat.model.OfferLocation;
import com.findaflat.service.OffersFinder;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
@EnableWebMvc
@ComponentScan(basePackageClasses = RestControllerTestScanPoint.class)
@Configuration
public class FindOfferTest {

	@Autowired
	WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void OffersController() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/offers")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"price\": 1000, \"title\": \"dupa\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].price", Matchers.is(1000)))
				.andExpect(MockMvcResultMatchers
						.jsonPath("$[0].title", Matchers.is("dupa"))).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].offerLocation.longitude",
						Matchers.is(45.5433))).andExpect(MockMvcResultMatchers
				.jsonPath("$[0].offerLocation.lattitude",
						Matchers.is(51.5678)));
	}

	@Configuration
	static class Config {
		@Bean
		OffersFinder createOfferFinder() {
			return searchCriteria -> {
				Collection<Offer> offers = new ArrayList<>();
				offers.add(Offer.builder().price(new BigDecimal(1000))
						.title("dupa").offerLocation(
								OfferLocation.builder().longitude(45.5433)
										.lattitude(51.5678).build()).build());
				return offers;
			};
		}
	}

}
