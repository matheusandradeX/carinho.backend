package com.ifsp.hto.carinho.backend;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class teste {

	public static void main(String[] args) {

		Instant nowUtc = Instant.now();
		ZoneId brasilia = ZoneId.of("Brazil/East");
		ZonedDateTime nowBrazil = ZonedDateTime.ofInstant(nowUtc, brasilia);
		System.out.println(nowBrazil);

	}

}
