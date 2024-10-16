package com.Banking.Banking_app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BankingAppApplicationTests {
	Calculators c=new Calculators();


	@Test
	void contextLoads() {
	}

	@Test

	void add(){
		//Except
		int except=9;

		//result
		int result=c.add(4,5);
		assertEquals(except, result);
	}
	@Test
	void profuct1(){
		//except
		int prdt=90;

		//result
		int result =c.product(10,9);

		assertEquals(prdt,result);
	}

}
