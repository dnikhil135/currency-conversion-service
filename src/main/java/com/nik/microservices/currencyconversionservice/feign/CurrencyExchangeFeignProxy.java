package com.nik.microservices.currencyconversionservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nik.microservices.currencyconversionservice.model.CurrencyConversionBean;

@FeignClient(name="currency-exhange-service",url="localhost:8000")
public interface CurrencyExchangeFeignProxy {
	
	@GetMapping("/currency-exchange-jpa/from/{from}/to/{to}")
	public CurrencyConversionBean retriveCurrencyValue(@PathVariable("from") String from, @PathVariable("to") String to);
	
}
