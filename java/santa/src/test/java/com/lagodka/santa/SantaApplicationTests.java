package com.lagodka.santa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SantaApplicationTests {

	@Autowired
	private MessageReceiver messageReceiver;

	@Autowired
	private MyMessageReceiver myMessageReceiver;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldPrint3Lines(){
		messageReceiver.onMessage("106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n" +
				"…\n" +
				"107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\n" +
				"…\n" +
				"108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\n" +
				"…\n" +
				"109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100\n" +
				"…\n" +
				"110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110");
	}

	@Test
	void shouldPrint5Lines(){
		myMessageReceiver.onMessage("106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n" +
				"…\n" +
				"107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\n" +
				"…\n" +
				"108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\n" +
				"…\n" +
				"109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100\n" +
				"…\n" +
				"110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110");
	}

}
