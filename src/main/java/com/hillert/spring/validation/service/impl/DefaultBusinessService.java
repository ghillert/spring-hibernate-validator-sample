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
package com.hillert.spring.validation.service.impl;

import org.springframework.stereotype.Service;

import com.hillert.spring.validation.service.BusinessService;


/**
 * Default implementation of the Business Service. 
 * 
 * @author Gunnar Hillert
 * @since 1.0
 * 
 */
@Service
public class DefaultBusinessService implements BusinessService {
	
	/** {@inheritDoc} */
	public String convertToUpperCase(String input) {
		
		if ("returnnull".equalsIgnoreCase(input)) {
			return null;
		}
		
		return input.toUpperCase();	
	}

}
