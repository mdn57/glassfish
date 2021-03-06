/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
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

package org.glassfish.web.deployment.runtime;

import com.sun.enterprise.deployment.runtime.RuntimeDescriptor;

/**
* this class contains runtime information for the web bundle 
* it was kept to be backward compatible with the schema2beans descriptors
* generated by iAS 7.0 engineering team.
*
* @author Jerome Dochez
*/
public class ConstraintField extends RuntimeDescriptor
{
    
    static public final String VALUE = "Value";	// NOI18N
    static public final String NAME = "Name";
    static public final String SCOPE = "Scope";    
    static public final String MATCH_EXPR = "MatchExpr";
    static public final String CACHE_ON_MATCH = "CacheOnMatch";
    static public final String CACHE_ON_MATCH_FAILURE = "CacheOnMatchFailure";
        
    public ConstraintField(ConstraintField other)
    {
	super(other);
    }

    public ConstraintField()
    {
	setAttributeValue(SCOPE, "request.parameter");
	setAttributeValue(CACHE_ON_MATCH, "true");
	setAttributeValue(CACHE_ON_MATCH_FAILURE, "false");  
    }
    
    // This attribute is an array, possibly empty
    public void setValue(int index, String value)
    {
	this.setValue(VALUE, index, value);
    }
    
    //
    public String getValue(int index)
    {
	return (String)this.getValue(VALUE, index);
    }
    
    // This attribute is an array, possibly empty
    public void setValue(String[] value)
    {
	this.setValue(VALUE, value);
    }
    
    //
    public String[] getValue()
    {
	return (String[])this.getValues(VALUE);
    }
    
    // Return the number of properties
    public int sizeValue()
    {
	return this.size(VALUE);
    }
    
    // Add a new element returning its index in the list
    public int addValue(String value)
    {
	int index = this.addValue(VALUE, value);
	if (getAttributeValue(VALUE, index, MATCH_EXPR)==null)
	    setAttributeValue(VALUE, index, MATCH_EXPR, "equals");
	if (getAttributeValue(VALUE, index, CACHE_ON_MATCH)==null)	    
	    setAttributeValue(VALUE, index, CACHE_ON_MATCH, "true");
	if (getAttributeValue(VALUE, index, CACHE_ON_MATCH_FAILURE)==null)	    
	    setAttributeValue(VALUE, index, CACHE_ON_MATCH_FAILURE, "false");
	return index;
    }
    
    //
    // Remove an element using its reference
    // Returns the index the element had in the list
    //
    public int removeValue(String value)
    {
	return this.removeValue(VALUE, value);
    }
    
    // This method verifies that the mandatory properties are set
    public boolean verify()
    {
	return true;
    }
}
