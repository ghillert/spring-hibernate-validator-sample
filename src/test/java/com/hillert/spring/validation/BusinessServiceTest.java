/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hillert.spring.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.hibernate.validator.method.MethodConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hillert.spring.validation.service.BusinessService;

/**
 * 
 * @author Gunnar Hillert
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class BusinessServiceTest extends BaseIntegrationTest {

	@Autowired
	private BusinessService service;
	
	@Test
	public void testConvertToUpperCase() throws Exception {
		assertEquals("HELLO WORLD!", service.convertToUpperCase("hello world!"));
	}

	@Test
	public void testConvertToUpperCaseWithNullReturn() throws Exception {
		
		try {
		    service.convertToUpperCase("returnnull");
		} catch (MethodConstraintViolationException e) {
			assertEquals("Null returns are not permitted", e.getConstraintViolations().iterator().next().getMessage());
			return;
		}
		
		fail("Was expecting a ConstraintViolationException.");
	}
	
	@Test
	public void testConvertToUpperCaseInputEmpty() throws Exception {
		
		try {
		    service.convertToUpperCase("");
		} catch (MethodConstraintViolationException e) {
			assertEquals("Input must not be null or empty.", e.getConstraintViolations().iterator().next().getMessage());
			return;
		}
		
		fail("Was expecting a ConstraintViolationException.");
	}

	@Test
	public void testConvertToUpperCaseInputNull() throws Exception {
		
		try {
		    service.convertToUpperCase(null);
		} catch (MethodConstraintViolationException e) {
			assertEquals("Input must not be null or empty.", e.getConstraintViolations().iterator().next().getMessage());
			return;
		}
		
		fail("Was expecting a ConstraintViolationException.");
	}
	
}
