/*
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.oracle.hk2.devtest.cdi.jit;

import jakarta.inject.Inject;

import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.JustInTimeInjectionResolver;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.jvnet.hk2.annotations.Service;

/**
 * This is the JIT resolver that creates implementations
 * of HK2Service
 * 
 * @author jwells
 *
 */
@Service
public class JITResolver implements JustInTimeInjectionResolver {
    @Inject
    private ServiceLocator locator;

    @Override
    public boolean justInTimeResolution(Injectee failedInjectionPoint) {
        if (!failedInjectionPoint.getRequiredType().equals(HK2Service.class)) return false;
        
        HK2Service hk2Service = new HK2Service() {};
        ServiceLocatorUtilities.addOneConstant(locator, hk2Service);
        
        return true;
    }

}
