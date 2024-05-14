package org.apache.seata.sample;

import org.apache.seata.sample.service.BusinessService;
import org.apache.seata.sample.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Seata CommandLineRunner
 **/
@Component
public class SeataCmdLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeataCmdLineRunner.class);


    @Resource
    BusinessService businessService;

    @Override
    public void run(String... args) throws Exception {
        String userId = "U100001";

        businessService.purchase(userId, UUID.randomUUID().toString(), 2, false, false);
        LOGGER.info("[prepare ok] do not call remote");

        businessService.purchase(userId, UUID.randomUUID().toString(), 2, true, false);
        LOGGER.info("[prepare ok] call remote");

        try {
            businessService.purchase(userId + "e", UUID.randomUUID().toString(), 2, false, true);
        } catch (Exception e) {
            LOGGER.error("[prepare error] do not call remote :" + e.getMessage());
        }

        try {
            businessService.purchase(userId + "e", UUID.randomUUID().toString(), 2, true, true);
        } catch (Exception e) {
            LOGGER.error("[prepare error] call remote:" + e.getMessage());
        }
    }
}
