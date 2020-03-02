package com.placecube.nhs.headless.user.readiness.internal.resource.v1_0_0;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.vulcan.pagination.Page;
import com.placecube.nhs.headless.user.readiness.dto.v1_0_0.Question;
import com.placecube.nhs.headless.user.readiness.resource.v1_0_0.QuestionResource;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;

/**
 * @author Placecube
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0_0/question.properties", scope = ServiceScope.PROTOTYPE, service = QuestionResource.class)
public class QuestionResourceImpl extends BaseQuestionResourceImpl {

	@Reference
	private ReadinessService readinessService;

	@Override
	public void deleteUserProfileQuestion(@NotNull Long questionId) throws Exception {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		readinessService.deleteAnswer(questionId, permissionChecker.getUserId());
	}

	@Override
	public Question getUserProfileQuestion(@NotNull Long questionId) throws Exception {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		ReadinessQuestion readinessQuestion = readinessService.getQuestion(questionId, permissionChecker.getUser());
		return getQuestionFromReadinessQuestion(readinessQuestion);
	}

	@Override
	public Page<Question> getUserProfileQuestionnairePage() throws Exception {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		List<ReadinessQuestion> readinessQuestions = readinessService.getQuestions(permissionChecker.getUser());
		List<Question> questions = readinessQuestions.stream().map(readinessQuestion -> getQuestionFromReadinessQuestion(readinessQuestion)).collect(Collectors.toList());
		questions.sort((o1, o2) -> o1.getIndex().compareTo(o2.getIndex()));
		return Page.of(questions);
	}

	@Override
	public void putUserProfileQuestion(@NotNull Long questionId, String value) throws Exception {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		readinessService.updateAnswer(questionId, permissionChecker.getUserId(), value);
	}

	private Question getQuestionFromReadinessQuestion(ReadinessQuestion readinessQuestion) {
		Question question = new Question();
		question.setId(readinessQuestion.getQuestionId());
		question.setName(readinessQuestion.getQuestionTitle());
		question.setIndex(readinessQuestion.getIndex());
		question.setSelectedAnswer(readinessQuestion.getUserAnswer());
		question.setOptions(readinessQuestion.getAvailableAnswers());
		return question;
	}

}