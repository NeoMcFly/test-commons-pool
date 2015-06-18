package fr.free.neomcfly.test.commons.pool.configuration;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import fr.free.neomcfly.test.commons.pool.Connection;
import fr.free.neomcfly.test.commons.pool.impl.ConnectionPoolTargetSource;
import fr.free.neomcfly.test.commons.pool.impl.DefaultConnection;

@Configuration
public class ConfigurationPool {

    @Bean(name = "pooledConnection")
    @Scope("session")
    public Connection getPooledConnection(BeanFactory beanFactory) {

        ConnectionPoolTargetSource targetSource = new ConnectionPoolTargetSource();
        targetSource.setMaxSize(1);
        targetSource.setMaxIdle(1);
        targetSource.setMinEvictableIdleTimeMillis(30000);
        targetSource.setTimeBetweenEvictionRunsMillis(1000);

        targetSource.setTargetBeanName("connection");
        targetSource.setBeanFactory(beanFactory);

        ProxyFactoryBean pfb = new ProxyFactoryBean();
        pfb.setProxyTargetClass(true);
        pfb.setTargetSource(targetSource);

        return (Connection) pfb.getObject();
    }

    @Bean(name = "connection")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Connection getConnection() {
        return new DefaultConnection();
    }

}
