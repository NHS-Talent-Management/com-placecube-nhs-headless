package com.placecube.nhs.headless.user.readiness.internal.graphql.query.v1_0_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;

import com.placecube.nhs.headless.user.readiness.dto.v1_0_0.Question;
import com.placecube.nhs.headless.user.readiness.resource.v1_0_0.QuestionResource;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Placecube
 * @generated
 */
@Generated("")
public class Query {

	public static void setQuestionResourceComponentServiceObjects(
		ComponentServiceObjects<QuestionResource>
			questionResourceComponentServiceObjects) {

		_questionResourceComponentServiceObjects =
			questionResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Question> getUserProfileQuestionnairePage()
		throws Exception {

		return _applyComponentServiceObjects(
			_questionResourceComponentServiceObjects,
			this::_populateResourceContext,
			questionResource -> {
				Page paginationPage =
					questionResource.getUserProfileQuestionnairePage();

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Question getUserProfileQuestion(
			@GraphQLName("questionId") Long questionId)
		throws Exception {

		return _applyComponentServiceObjects(
			_questionResourceComponentServiceObjects,
			this::_populateResourceContext,
			questionResource -> questionResource.getUserProfileQuestion(
				questionId));
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

	private void _populateResourceContext(QuestionResource questionResource)
		throws Exception {

		questionResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<QuestionResource>
		_questionResourceComponentServiceObjects;

}