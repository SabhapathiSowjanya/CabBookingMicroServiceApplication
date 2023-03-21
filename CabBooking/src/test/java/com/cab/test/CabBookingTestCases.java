package com.cab.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cab.entity.CabBooking;
import com.cab.repository.CabRepository;
import com.cab.service.CabServiceImp;

@SpringBootTest
public class CabBookingTestCases {

	@Autowired
	private CabServiceImp cabSer;

	@MockBean
	private CabRepository cabRepo;

	@Test
	public void getAllCabs() {
		Mockito.when(cabRepo.findAll()).thenReturn(Stream
				.of(new CabBooking(1, "Hyd", 200, true), new CabBooking(2, "banglore", 500, true)).collect(Collectors.toList()));
		assertEquals(2, cabSer.getAllCabs().size());
	}


	@Test
	public void addCabDetails() {
		CabBooking cab = new CabBooking(1, "bngr", 500, true);
		Mockito.when(cabRepo.save(cab)).thenReturn(cab);

		assertEquals(cab, cabSer.addCabDetails(cab));
	}

	@Test
	public void deleteCabById() {
		CabBooking cab = new CabBooking(1, "bngr", 500, true);
		assertEquals("Deleted Successfully", cabSer.deleteCabById(cab.getCabId()));
	}

	@Test
	public void testDeleteall() {
		assertEquals("All Cabs deleted", cabSer.deleteAllCabs());
	}

}
