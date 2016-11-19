package com.findaflat.rest;

import com.findaflat.model.Offer;
import com.findaflat.model.SearchCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController("/rest/offers")
public class OffersController {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Collection<Offer>> findOffers(
			@RequestBody
					SearchCriteria searchCriteria) {
		throw new UnsupportedOperationException("Non implemented yet!");
	}
}
