package com.liuyu.mango.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liu yu
 */
@EnableAdminServer
@SpringBootApplication
public class MangoMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangoMonitorApplication.class, args);
	}

}