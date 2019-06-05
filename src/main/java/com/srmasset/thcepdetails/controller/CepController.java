package com.srmasset.thcepdetails.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srmasset.thcepdetails.domain.Address;
import com.srmasset.thcepdetails.service.CepService;

@RestController
@RequestMapping("/cepdetailsapp")
public class CepController {

	@Autowired
	private CepService cepService;

	@GetMapping("/cep/{cep}")
	public ResponseEntity<Address> getCep(@PathVariable String cep) {
		Address address = cepService.getAddressByCep(cep);
		if (address == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(address);
	}

	@PostMapping("/ceps")
	public ResponseEntity<List<Address>> getListOfCeps(@RequestBody List<String> ceps) {
		List<Address> addressList = new ArrayList<>();
		if (ceps != null && !ceps.isEmpty()) {
			ceps.forEach(cep -> {
				addressList.add(cepService.getAddressByCep(cep));
			});
			return ResponseEntity.ok(addressList);
		}
		return ResponseEntity.noContent().build();

	}

}