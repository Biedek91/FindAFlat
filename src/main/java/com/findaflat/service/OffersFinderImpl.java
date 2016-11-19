package com.findaflat.service;

import com.findaflat.model.Offer;
import com.findaflat.model.OfferLocation;
import com.findaflat.model.SearchCriteria;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class OffersFinderImpl implements OffersFinder {
	@Override
	public Collection<Offer> findOffer(SearchCriteria searchCriteria) {

		Collection<Offer> offers = new ArrayList<>();
		offers.add(Offer.builder().price(new BigDecimal(1000)).title("dupa")
				.offerLocation(OfferLocation.builder().longitude(45.5433)
						.lattitude(51.5678).build()).build());

		offers.add(Offer.builder().price(new BigDecimal(2000)).title("dupa2")
				.offerLocation(OfferLocation.builder().longitude(25.5433)
						.lattitude(21.5678).build()).build());

		offers.add(Offer.builder().price(new BigDecimal(3000)).title("dupa3")
				.offerLocation(OfferLocation.builder().longitude(35.5433)
						.lattitude(31.5678).build()).build());

		return offers;
	}
}
