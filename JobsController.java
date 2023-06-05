package com.plantect.self.service.controller.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.plantect.self.service.service.EmailService;
import com.plantect.self.service.service.PasscodeEmailLogService;

@Controller
public class JobsController {
	private static final Logger logger = LoggerFactory.getLogger(JobsController.class);//log added by Subha n dipti
	
	@Autowired
	PasscodeEmailLogService passcodeEmailLogService;

	@Autowired
	EmailService emailService;

	/**
	 * Re-send email after 1 minute
	 */
	@Scheduled(cron = "${app.passcode.email.send.cron}")
	public void sendPasscodeEmail() {
		logger.info("Send passcode emails");
		
		passcodeEmailLogService.resendPasscodeEmail();
	}
}
