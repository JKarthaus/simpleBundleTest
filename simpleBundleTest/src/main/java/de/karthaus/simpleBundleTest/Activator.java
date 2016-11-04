/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.karthaus.simpleBundleTest;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class Activator implements BundleActivator, ManagedService {

	private static final String BUNDLE_ID = "simpleBundleTest";
	private ServiceRegistration serviceReg;
	private Logger log = Logger.getLogger(this.getClass().getName());

	public void start(BundleContext context) {
		Hashtable<String, Object> properties = new Hashtable<String, Object>();
		properties.put(Constants.SERVICE_PID, BUNDLE_ID);
		serviceReg = context.registerService(ManagedService.class.getName(), this, properties);
		log.info("Starting Bundle " + BUNDLE_ID);
	}

	public void stop(BundleContext context) {
		log.info("Stopping Bundle " + BUNDLE_ID);
	}

	public void updated(Dictionary properties) throws ConfigurationException {
		if (properties == null) {
			log.info(BUNDLE_ID + " config not found  - Please give me a config File in Folder config");
			return;
		}
		log.info(BUNDLE_ID + " Config was set.");
		log.info("Found " + properties.size() + " config Items.");
	}

}