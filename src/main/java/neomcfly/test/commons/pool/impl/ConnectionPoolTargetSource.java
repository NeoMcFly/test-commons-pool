package neomcfly.test.commons.pool.impl;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.aop.target.CommonsPool2TargetSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionPoolTargetSource extends CommonsPool2TargetSource {

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
	public PooledObject<Object> makeObject() throws Exception {
		log("Make Object");

		return super.makeObject();
	}

	@Override
	public void releaseTarget(Object target) throws Exception {

		super.releaseTarget(target);

		log("Make Release Target");
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
		GenericObjectPool createObjectPool = (GenericObjectPool) super.createObjectPool();
		createObjectPool.setTestOnBorrow(true);
		return createObjectPool;
	}

}
