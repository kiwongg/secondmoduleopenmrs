package org.openmrs.module.premium;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.BaseModuleActivator;

public class PremiumWorldActivator extends BaseModuleActivator {

	private static final Log log = LogFactory.getLog(PremiumWorldActivator.class);

	@Override
	public void started() {
		log.info("Premium World Module started");
	}

	@Override
	public void stopped() {
		log.info("Premium World Module stopped");
	}
}