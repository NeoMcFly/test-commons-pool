package fr.free.neomcfly.test.commons.pool.impl;

import lombok.extern.slf4j.Slf4j;
import fr.free.neomcfly.test.commons.pool.Connection;

@Slf4j
public class DefaultConnection implements Connection {

    public void execute(String command) {
        log.info("> Executing command {}", command);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        log.info("< Executing command {}", command);

    }

}
