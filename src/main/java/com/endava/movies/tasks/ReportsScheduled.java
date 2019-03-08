package com.endava.movies.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

public class ReportsScheduled {
    
    private static final Logger log = LoggerFactory.getLogger(ReportsScheduled.class);

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}");
    }
}
