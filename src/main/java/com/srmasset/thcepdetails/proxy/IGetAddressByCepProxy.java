package com.srmasset.thcepdetails.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.srmasset.thcepdetails.domain.Address;

@FeignClient("get-address-by-cep")
@RibbonClient("get-address-by-cep")
public interface IGetAddressByCepProxy {

	@GetMapping("/orchestrator/v1/obter-endereco-por-cep/{cep}")
	public Address getAddressByCep(@PathVariable("cep") String cep);
}