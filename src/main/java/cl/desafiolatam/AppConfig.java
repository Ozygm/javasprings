package cl.desafiolatam;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("cl.desafiolatam")
@PropertySource("classpath:database.properties")
public class AppConfig {
	
		@Autowired
		Environment enviroment;
		
		@Bean
		DataSource dataSource() {
			DriverManagerDataSource dm = new DriverManagerDataSource();
			dm.setUrl(enviroment.getProperty("url"));
			dm.setUsername(enviroment.getProperty("dbuser"));
			dm.setPassword(enviroment.getProperty("dbpass"));
			dm.setDriverClassName(enviroment.getProperty("driver"));
			return dm;
		}

}
