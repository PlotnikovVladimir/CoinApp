package com.test.configuration;

/**
 * Created by user on 16.09.2015.
 */

import org.springframework.security.access.*;
import org.springframework.security.web.context.*;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer() {
		  super(SecurityConfig.class);
	}
}

