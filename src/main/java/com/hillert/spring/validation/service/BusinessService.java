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
package com.hillert.spring.validation.service;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

/**
 * Simple example of a business layer with method validation contraints.
 * 
 * @author Gunnar Hillert
 * @since 1.0
 *
 */
@Validated
public interface BusinessService {
	
	/**
	 * Convert the provided input String to the upper-case representation.
	 * 
	 * @param input String to be converted to upper-case
	 * @return Converted String. Never returns null.
	 */
	@NotNull(message="Null returns are not permitted") 
	String convertToUpperCase(@NotEmpty(message="Input must not be null or empty.") 
	                          String input);

}
