package com.placecube.nhs.headless.user.readiness.internal.resource.v1_0_0;

import com.liferay.portal.vulcan.resource.OpenAPIResource;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;

import javax.servlet.ServletConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Placecube
 * @generated
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0_0/openapi.properties",
	service = OpenAPIResourceImpl.class
)
@Generated("")
@OpenAPIDefinition(
	info = @Info(description = "An API to retrieve and update the readiness for a user", title = "NHS Talent - User Readiness", version = "1.0.0")
)
@Path("/1.0.0")
public class OpenAPIResourceImpl {

	@GET
	@Path("/openapi.{type:json|yaml}")
	@Produces({MediaType.APPLICATION_JSON, "application/yaml"})
	public Response getOpenAPI(
			@Context HttpHeaders httpHeaders, @Context UriInfo uriInfo,
			@PathParam("type") String type)
		throws Exception {

		return _openAPIResource.getOpenAPI(
			_application, httpHeaders, _resourceClasses, _servletConfig, type,
			uriInfo);
	}

	@Context
	private Application _application;

	@Reference
	private OpenAPIResource _openAPIResource;

	private final Set<Class<?>> _resourceClasses = new HashSet<Class<?>>() {
		{
			add(QuestionResourceImpl.class);

			add(OpenAPIResourceImpl.class);
		}
	};

	@Context
	private ServletConfig _servletConfig;

}