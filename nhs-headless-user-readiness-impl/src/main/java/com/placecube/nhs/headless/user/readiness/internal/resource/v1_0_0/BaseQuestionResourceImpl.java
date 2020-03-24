package com.placecube.nhs.headless.user.readiness.internal.resource.v1_0_0;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.util.TransformUtil;

import com.placecube.nhs.headless.user.readiness.dto.v1_0_0.Question;
import com.placecube.nhs.headless.user.readiness.resource.v1_0_0.QuestionResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Placecube
 * @generated
 */
@Generated("")
@Path("/1.0.0")
public abstract class BaseQuestionResourceImpl implements QuestionResource {

	@Override
	@GET
	@Operation(description = "Returns the whole user readiness questionnaire")
	@Path("/user-profile/questionnaire")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Question")})
	public Page<Question> getUserProfileQuestionnairePage() throws Exception {
		return Page.of(Collections.emptyList());
	}

	@Override
	@GET
	@Operation(
		description = "Returns the help information displayed in the first page of the questionnaire"
	)
	@Path("/user-profile/questionnaire-intro")
	@Produces("text/html")
	@Tags(value = {@Tag(name = "Question")})
	public String getUserProfileQuestionnaireIntro() throws Exception {
		return StringPool.BLANK;
	}

	@Override
	@DELETE
	@Operation(description = "Deletes the answer for a single question")
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "questionId")}
	)
	@Path("/user-profile/question/{questionId}")
	@Tags(value = {@Tag(name = "Question")})
	public void deleteUserProfileQuestion(
			@NotNull @Parameter(hidden = true) @PathParam("questionId") Long
				questionId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Returns a single question")
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "questionId")}
	)
	@Path("/user-profile/question/{questionId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Question")})
	public Question getUserProfileQuestion(
			@NotNull @Parameter(hidden = true) @PathParam("questionId") Long
				questionId)
		throws Exception {

		return new Question();
	}

	@Override
	@Consumes("text/plain")
	@Operation(description = "Updates the answer to a single question")
	@PUT
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "questionId")}
	)
	@Path("/user-profile/question/{questionId}")
	@Tags(value = {@Tag(name = "Question")})
	public void putUserProfileQuestion(
			@NotNull @Parameter(hidden = true) @PathParam("questionId") Long
				questionId,
			String string)
		throws Exception {
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(Question question, Question existingQuestion) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}