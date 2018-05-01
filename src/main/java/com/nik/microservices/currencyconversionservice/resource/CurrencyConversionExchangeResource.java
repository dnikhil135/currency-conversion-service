package com.nik.microservices.currencyconversionservice.resource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nik.microservices.currencyconversionservice.feign.CurrencyExchangeFeignProxy;
import com.nik.microservices.currencyconversionservice.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionExchangeResource {
	
	@Autowired
	private CurrencyExchangeFeignProxy currencyExchangeFeignProxy;
	
	@GetMapping("/currency-conversion-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retriveConvertedCurrency(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange-jpa/from/{from}/to/{to}", 
				CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean currencyCovResp = response.getBody();
		return new CurrencyConversionBean(currencyCovResp.getId(), from, to, currencyCovResp.getCurrencyValue(), quantity,
				quantity.multiply(currencyCovResp.getCurrencyValue()),currencyCovResp.getPort());
	}
	
	@GetMapping("/currency-conversion-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retriveConvertedCurrencyFeign(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionBean currencyCovResp = currencyExchangeFeignProxy.retriveCurrencyValue(from, to);
		return new CurrencyConversionBean(currencyCovResp.getId(), from, to, currencyCovResp.getCurrencyValue(), quantity,
				quantity.multiply(currencyCovResp.getCurrencyValue()),currencyCovResp.getPort());
	}
}
