package com.findaflat.service;

import com.findaflat.model.Offer;
import com.findaflat.model.SearchCriteria;

import java.util.Collection;

public interface OffersFinder {

	Collection<Offer> findOffer(SearchCriteria searchCriteria);
}
