package fr.free.neomcfly.test.commons.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Service {

    public class WorkerThread implements Runnable {

        private String userId;

        public WorkerThread(String userId) {
            this.userId = userId;
        }

        public void run() {

            log.info("user begin: " + userId);

            connection.execute("Command: " + userId);

            log.info("user end: " + userId);

        }
    }

    @Autowired
    @Qualifier("pooledConnection")
    private Connection connection;

    public void test() {

        ExecutorService executor = Executors.newFixedThreadPool(100); // illimité
        for (int i = 0; i < 10; i++) {

            Runnable worker = new WorkerThread("" + i);

            executor.execute(worker);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        log.info("> Wait Second passage");

        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("< Wait Second passage");

        executor = Executors.newFixedThreadPool(100); // illimité
        for (int i = 0; i < 10; i++) {

            Runnable worker = new WorkerThread("" + i);

            executor.execute(worker);

        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

    }
}
