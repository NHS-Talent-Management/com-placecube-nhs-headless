package com.placecube.nhs.headless.user.readiness.internal.graphql.mutation.v1_0_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;

import com.placecube.nhs.headless.user.readiness.resource.v1_0_0.QuestionResource;

import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Placecube
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setQuestionResourceComponentServiceObjects(
		ComponentServiceObjects<QuestionResource>
			questionResourceComponentServiceObjects) {

		_questionResourceComponentServiceObjects =
			questionResourceComponentServiceObjects;
	}

	@GraphQLInvokeDetached
	public void deleteUserProfileQuestion(
			@GraphQLName("questionId") Long questionId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_questionResourceComponentServiceObjects,
			this::_populateResourceContext,
			questionResource -> questionResource.deleteUserProfileQuestion(
				questionId));
	}

	@GraphQLInvokeDetached
	public void putUserProfileQuestion(
			@GraphQLName("questionId") Long questionId,
			@GraphQLName("string") String string)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_questionResourceComponentServiceObjects,
			this::_populateResourceContext,
			questionResource -> questionResource.putUserProfileQuestion(
				questionId, string));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(QuestionResource questionResource)
		throws Exception {

		questionResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<QuestionResource>
		_questionResourceComponentServiceObjects;

}