package com.srmasset.thcepdetails.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.srmasset.thcepdetails.domain.Address;
import com.srmasset.thcepdetails.proxy.IGetAddressByCepProxy;

@Service
public class CepService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CepService.class);

	@Autowired
	private IGetAddressByCepProxy proxy;

	@Cacheable(value = "cepAddress")
	public Address getAddressByCep(String cep) {
		LOGGER.info("Getting cep {} in web service", cep);
		Address cepAddress = proxy.getAddressByCep(cep);
		if (cepAddress.getState() == null) {
			LOGGER.info("Cep {} not found", cep);
			return null;
		}
		LOGGER.info("Cep {} found", cep);
		return cepAddress;
	}
}