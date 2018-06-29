package cn.tentact.nebula;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
public class NebulaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NebulaApplication.class, args);
	}
}
