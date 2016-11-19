package com.findaflat.rest;

import com.findaflat.model.Offer;
import com.findaflat.model.SearchCriteria;
import com.findaflat.service.OffersFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/offers")
public class OffersController {

	private final OffersFinder offersFinder;

	@Autowired
	public OffersController(OffersFinder offersFinder) {
		this.offersFinder = offersFinder;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Collection<Offer>> findOffers(
			@RequestBody SearchCriteria searchCriteria) {
		Collection<Offer> offers = offersFinder.findOffer(searchCriteria);
		return new ResponseEntity<>(offers, HttpStatus.OK);
	}
}
