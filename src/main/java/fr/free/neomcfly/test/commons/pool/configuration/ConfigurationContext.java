package fr.free.neomcfly.test.commons.pool.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.free.neomcfly.test.commons.pool.Main;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class ConfigurationContext {

}
