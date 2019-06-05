package com.srmasset.thcepdetails;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.srmasset.thcepdetails.domain.Address;
import com.srmasset.thcepdetails.service.CepService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThCepDetailsApplicationTests {

	@Autowired
	private CepService cepService;

	@Test
	public void testCache() {
		Address address1 = cepService.getAddressByCep("03312052");

		Address address2 = cepService.getAddressByCep("03312052");

		assertEquals(address1, address2);
	}

	@Test
	public void testCepFound() {
		Address cepAddress = cepService.getAddressByCep("94838370");

		assertNotNull(cepAddress);
	}

	@Test
	public void testCepNotFound() {
		Address cepAddress = cepService.getAddressByCep("94838371");

		assertNull(cepAddress);
	}
}