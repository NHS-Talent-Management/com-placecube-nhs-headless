package com.placecube.nhs.headless.user.readiness.resource.v1_0_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.pagination.Page;

import com.placecube.nhs.headless.user.readiness.dto.v1_0_0.Question;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/nhs-headless-user-readiness/1.0.0
 *
 * @author Placecube
 * @generated
 */
@Generated("")
public interface QuestionResource {

	public Page<Question> getUserProfileQuestionnairePage() throws Exception;

	public String getUserProfileQuestionnaireIntro() throws Exception;

	public void deleteUserProfileQuestion(Long questionId) throws Exception;

	public Question getUserProfileQuestion(Long questionId) throws Exception;

	public void putUserProfileQuestion(Long questionId, String string)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}