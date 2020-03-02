package com.placecube.nhs.headless.user.readiness.internal.graphql.servlet.v1_0_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.placecube.nhs.headless.user.readiness.internal.graphql.mutation.v1_0_0.Mutation;
import com.placecube.nhs.headless.user.readiness.internal.graphql.query.v1_0_0.Query;
import com.placecube.nhs.headless.user.readiness.resource.v1_0_0.QuestionResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Placecube
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setQuestionResourceComponentServiceObjects(
			_questionResourceComponentServiceObjects);

		Query.setQuestionResourceComponentServiceObjects(
			_questionResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/nhs-headless-user-readiness-graphql/v1_0_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<QuestionResource>
		_questionResourceComponentServiceObjects;

}