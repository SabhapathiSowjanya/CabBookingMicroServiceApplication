package com.api.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.admin.entity.CabAdmin;
import com.admin.repository.CabAdminRepository;
import com.admin.service.CabAdminServiceImp;


@SpringBootTest(classes = CabAdminTestCases.class)
public class CabAdminTestCases {
	@Autowired
	private CabAdminServiceImp cabSer;

	@MockBean
	private CabAdminRepository cabRepo;

	@Test
	public void getAllCabs() {
		Mockito.when(cabRepo.findAll()).thenReturn(Stream
				.of(new CabAdmin(1, "Hyd","mini", 123), new CabAdmin(2, "bng", "auto", 198)).collect(Collectors.toList()));
		assertEquals(2, cabSer.getAllCabs().size());
	}


	@Test
	public void addCabSearchDetails() {
		CabAdmin cab = new CabAdmin(1, "Hyd","mini", 123);
		Mockito.when(cabRepo.save(cab)).thenReturn(cab);

		assertEquals(cab, cabSer.addCabSearchDetails(cab));
	}

	@Test
	public void deleteCabByAdminId() {
		CabAdmin cab = new CabAdmin(1, "Hyd","mini", 123);
		assertEquals("Deleted Successfully", cabSer.deleteCabByAdminId(cab.getAdminId()));
	}

	@Test
	public void deleteAllCabs() {
		assertEquals("All Cabs deleted", cabSer.deleteAllCabs());
	}


}
