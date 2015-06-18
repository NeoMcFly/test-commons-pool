package fr.free.neomcfly.test.commons.pool.impl;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.springframework.aop.target.CommonsPoolTargetSource;
import org.springframework.beans.BeansException;

@Slf4j
public class ConnectionPoolTargetSource extends CommonsPoolTargetSource {

    @Override
    public boolean validateObject(Object obj) {
        log("Validate Object");

        return true;
    }

    private void log(String message) {
        log.info(message + " " + getInfo());
    }

    @Override
    public Object getTarget() throws Exception {

        Object target = super.getTarget();

        log("Get Target");

        return target;
    }

    @Override
    public Object makeObject() throws BeansException {
        log("Make Object");

        return super.makeObject();
    }

    @Override
    public void releaseTarget(Object target) throws Exception {

        super.releaseTarget(target);

        log("Make Release Target");
    }

    @Override
    public void destroyObject(Object obj) throws Exception {
        log("Destroy Object");

        super.destroyObject(obj);
    }

    /**
     * Gives the description information on this pool. Describes active and free
     * objects in the pool.
     */
    public String getInfo() {
        return "(Etat du pool : active=" + getActiveCount() + " idle="
                + getIdleCount() + ") ";
    }

    @Override
    protected ObjectPool createObjectPool() {
        GenericObjectPool createObjectPool = (GenericObjectPool) super
                .createObjectPool();
        createObjectPool.setTestOnBorrow(true);
        return createObjectPool;
    }

}
