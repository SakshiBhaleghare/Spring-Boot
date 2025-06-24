package com.Configuration;

import java.util.concurrent.Executor;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsynchConfiguration {

	
	@Bean
	public Executor asynchTaskExecution() {

		ThreadPoolTaskExecutor tes = new ThreadPoolTaskExecutor();

		tes.setCorePoolSize(3);
		tes.setMaxPoolSize(4);
		tes.setQueueCapacity(150);
		tes.initialize();

		return tes;

	}

}
