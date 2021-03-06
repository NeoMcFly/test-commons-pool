package neomcfly.test.commons.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import neomcfly.test.commons.pool.configuration.ConfigurationContext;
import neomcfly.test.commons.pool.configuration.ConfigurationPool;

public class Main {

    @Autowired
    private Service service;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(ConfigurationContext.class);
        ctx.register(ConfigurationPool.class);
        ctx.refresh();

        Service service = ctx.getBean(Service.class);

        service.test();

        ctx.close();

    }

}
