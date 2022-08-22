package com.vigoengineering.vigocalendar;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@PWA(name = "VigoCalendar", shortName = "VigoCalendar", offlineResources = {})
@NpmPackage(value = "line-awesome", version = "1.3.0")
@NpmPackage(value = "@vaadin-component-factory/vcf-nav", version = "1.0.6")
public class VigocalendarApplication extends SpringBootServletInitializer implements AppShellConfigurator  {
	public static void main(String[] args) {
		SpringApplication.run(VigocalendarApplication.class, args);
	}
}
