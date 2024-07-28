package com.srijan.sringboot.myfirstwebapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyfirstwebappApplicationTests {

	@Test
	void contextLoads() {

		public String noRepetition(String str){
			Set<Character> charSet  = new LinkedHashSet<>();

			char[] carr = str.toCharArray();

			for(char c: carr){
				charSet.add(c);
			}
		
			return str;
		}
			
	}
}
