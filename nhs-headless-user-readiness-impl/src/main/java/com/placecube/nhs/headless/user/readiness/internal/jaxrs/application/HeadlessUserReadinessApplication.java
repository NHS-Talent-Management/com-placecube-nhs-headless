package com.placecube.nhs.headless.user.readiness.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Placecube
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/nhs-headless-user-readiness",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=NHS.Headless.User.Readiness"
	},
	service = Application.class
)
@Generated("")
public class HeadlessUserReadinessApplication extends Application {
}