/*
 * Copyright 2014 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.services.ejb.impl;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import org.jbpm.kie.services.impl.bpmn2.BPMN2DataServiceImpl;
import org.jbpm.services.api.DefinitionService;
import org.jbpm.services.api.model.ProcessDefinition;
import org.jbpm.services.ejb.api.DefinitionServiceEJBLocal;
import org.jbpm.services.ejb.api.DefinitionServiceEJBRemote;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
public class DefinitionServiceEJBImpl extends BPMN2DataServiceImpl implements DefinitionService, DefinitionServiceEJBLocal, DefinitionServiceEJBRemote {

	@Lock(LockType.WRITE)
	@Override
	public ProcessDefinition buildProcessDefinition(String deploymentId, String bpmn2Content, ClassLoader classLoader, boolean cache) throws IllegalArgumentException {
		return super.buildProcessDefinition(deploymentId, bpmn2Content, classLoader, cache);
	}

}
