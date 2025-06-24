package com.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	@Scheduled(cron = "*/1 * * * * *")
	public String getMsgInService() {
		System.out.println("Notify");
		return "GM";

	}

}
