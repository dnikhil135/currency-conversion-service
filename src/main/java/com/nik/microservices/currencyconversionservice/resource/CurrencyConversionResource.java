/*package com.nik.microservices.currencyconversionservice.resource;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nik.microservices.currencyconversionservice.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionResource {

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retriveConvertedCurrency(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		return new CurrencyConversionBean(1001, from, to, BigDecimal.ONE, quantity, quantity,0);
		
		
	}
}
*/