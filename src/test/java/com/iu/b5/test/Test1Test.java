package com.iu.b5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Test1Test {
	
	@Autowired
	private Test1 test1;
	
	/*
	 * @Autowired private Child1 child1;
	 * 
	 * @Autowired private Child2 child2;
	 */
	
	/*
	 * @Autowired private Parent parent;
	 */
	
	@Autowired
	private Parent child1;
	
	
	
 
	@Test
	void test() {
		System.out.println(child1 != null);
		
		/*
		 * System.out.println(child1 != null);
		 *  System.out.println(child2 != null);
		 */
		assertNotNull(test1);
	}

	

}
