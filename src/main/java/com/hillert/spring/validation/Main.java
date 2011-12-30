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

import java.util.Scanner;
import java.util.Set;

import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hillert.spring.validation.service.BusinessService;

/**
 * Executes the example to illustrate the usage of method validation with 
 * Hibernate Validator together with Spring.  
 *
 * @author Gunnar Hillert
 * @version 1.0
 *
 */
public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private Main() { }

    /**
     * Load the Spring Integration Application Context
     *
     * @param args - command line arguments
     */
    public static void main(final String... args) {

        LOGGER.info("\n========================================================="
                  + "\n                                                         "
                  + "\n          Welcome!                                       "
                  + "\n                                                         "
                  + "\n    For more information please visit:                   "
                  + "\n    http://blog.hillert.com                              "
                  + "\n                                                         "
                  + "\n=========================================================" );

        final AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:META-INF/spring/*-context.xml");

        context.registerShutdownHook();

        final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        final BusinessService service = context.getBean(BusinessService.class);

        LOGGER.info("\n========================================================="
                  + "\n                                                         "
                  + "\n    Please press 'q + Enter' to quit the application.    "
                  + "\n                                                         "
                  + "\n=========================================================" );

        System.out.println("Please enter a string and press <enter>: ");
        
        while(true){
        	
        	System.out.print("$ ");
            String input = scanner.nextLine();
        	
        	LOGGER.debug("Input string: '{}'", input);
        	
        	if ("q".equalsIgnoreCase(input)) {
        		break;
        	} else if ("null".equals(input)) {
        		input = null;
        	}
        	
        	try {
        	    System.out.println("Converted to upper-case: " + service.convertToUpperCase(input));
        	} catch (MethodConstraintViolationException e) {
        		Set<MethodConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        		LOGGER.info("Method Validation failed with {} error(s).", constraintViolations.size());
        		
        		for (MethodConstraintViolation<?> violation : e.getConstraintViolations()) {
        			LOGGER.info("Method Validation: {}", violation.getConstraintDescriptor());
        		}

        	}
        }

        LOGGER.info("Exiting application...bye.");

        System.exit(0);

    }
}
