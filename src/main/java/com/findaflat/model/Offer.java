package com.findaflat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

	private BigDecimal price;

	private String title;

	private OfferLocation offerLocation;
}
