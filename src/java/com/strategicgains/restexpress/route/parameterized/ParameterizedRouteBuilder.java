/*
    Copyright 2011, Strategic Gains, Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package com.strategicgains.restexpress.route.parameterized;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.netty.handler.codec.http.HttpMethod;

import com.strategicgains.restexpress.route.Route;
import com.strategicgains.restexpress.route.RouteBuilder;
import com.strategicgains.restexpress.settings.RouteDefaults;

/**
 * @author toddf
 * @since Jan 13, 2011
 */
public class ParameterizedRouteBuilder
extends RouteBuilder
{

	/**
	 * @param uri
	 * @param controller
	 * @param routeType
	 */
	public ParameterizedRouteBuilder(String uri, Object controller, RouteDefaults defaults)
	{
		super(uri, controller, defaults);
	}

	@Override
	protected Route newRoute(String pattern, Object controller, Method action, HttpMethod method,
		boolean shouldSerializeResponse, String name, List<String> supportedFormats,
		String defaultFormat, Set<String> flags, Map<String, Object> parameters)
	{
		return new ParameterizedRoute(pattern, controller, action, method,
		    shouldSerializeResponse, name, supportedFormats, defaultFormat,
		    flags, parameters);
	}

	protected String toRegexPattern(String uri)
    {
	    String pattern = uri;

		if (pattern != null && !pattern.startsWith("/"))
		{
			pattern = "/" + pattern;
		}

		return pattern;
    }

}
