package neomcfly.test.commons.pool.impl;

import lombok.extern.slf4j.Slf4j;
import neomcfly.test.commons.pool.Connection;

@Slf4j
public class DefaultConnection implements Connection {

    public void execute(String command) {
        log.info("> Executing command {}", command);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }

        log.info("< Executing command {}", command);

    }

}
