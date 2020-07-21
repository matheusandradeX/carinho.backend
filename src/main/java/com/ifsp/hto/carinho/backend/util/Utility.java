package com.ifsp.hto.carinho.backend.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Utility {

	/**
	 *
	 * https://mkyong.com/java8/java-display-all-zoneid-and-its-utc-offset/
	 * 
	 * @param config
	 * @return
	 */
	public static ZonedDateTime getDate(String config) {

		Instant nowUtc = Instant.now();
		ZoneId brasilia = ZoneId.of(config);
		ZonedDateTime nowBrazil = ZonedDateTime.ofInstant(nowUtc, brasilia);

		return nowBrazil;
	}

}
