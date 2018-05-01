package com.nik.microservices.currencyconversionservice.model;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private int id;
	private String from;
	private String to;
	private BigDecimal currencyValue;
	private BigDecimal quantity;
	private BigDecimal convertionValue;
	private int port;
	
	public CurrencyConversionBean() {
		
	}	
	public CurrencyConversionBean(int id, String from, String to, BigDecimal currencyValue, BigDecimal quantity,
			BigDecimal convertionValue,int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyValue = currencyValue;
		this.quantity = quantity;
		this.convertionValue = convertionValue;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(BigDecimal currencyValue) {
		this.currencyValue = currencyValue;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getConvertionValue() {
		return convertionValue;
	}

	public void setConvertionValue(BigDecimal convertionValue) {
		this.convertionValue = convertionValue;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	
	
}
