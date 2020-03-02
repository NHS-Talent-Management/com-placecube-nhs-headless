package com.placecube.nhs.headless.user.readiness.internal.resource.v1_0_0;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.vulcan.pagination.Page;
import com.placecube.nhs.headless.user.readiness.dto.v1_0_0.Question;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PermissionThreadLocal.class)
public class QuestionResourceImplTest extends PowerMockito {

	private static final Long USER_ID = 123l;
	private static final int INDEX_1 = 1;
	private static final Long QUESTION_ID_1 = 456l;
	private static final String NAME_1 = "nameQuestion1";
	private static final String[] OPTIONS_1 = new String[] { "opt1", "opt1A" };
	private static final String SELECTED_ANSWER_1 = "value1";
	private static final int INDEX_2 = 2;
	private static final Long QUESTION_ID_2 = 22456l;
	private static final String NAME_2 = "nameQuestion2";
	private static final String[] OPTIONS_2 = new String[] { "opt2", "opt2A" };
	private static final String SELECTED_ANSWER_2 = "value2";
	private static final int INDEX_3 = 3;
	private static final Long QUESTION_ID_3 = 33456l;
	private static final String NAME_3 = "nameQuestion3";
	private static final String[] OPTIONS_3 = new String[] { "opt3", "opt3A" };
	private static final String SELECTED_ANSWER_3 = "value3";

	@InjectMocks
	private QuestionResourceImpl questionResourceImpl;

	@Mock
	private ReadinessService mockReadinessService;

	@Mock
	private PermissionChecker mockPermissionChecker;

	@Mock
	private User mockUser;

	@Mock
	private ReadinessQuestion mockReadinessQuestion1;

	@Mock
	private ReadinessQuestion mockReadinessQuestion2;

	@Mock
	private ReadinessQuestion mockReadinessQuestion3;

	@Before
	public void setUp() {
		mockStatic(PermissionThreadLocal.class);
	}

	@Test(expected = Exception.class)
	public void deleteUserProfileQuestion_WhenExceptionDeletingAnswer_ThenThrowsException() throws Exception {
		when(PermissionThreadLocal.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockPermissionChecker.getUserId()).thenReturn(USER_ID);
		doThrow(new PortalException()).when(mockReadinessService).deleteAnswer(QUESTION_ID_1, USER_ID);

		questionResourceImpl.deleteUserProfileQuestion(QUESTION_ID_1);
	}

	@Test
	public void deleteUserProfileQuestion_WhenNoError_ThenDeletesTheAnswer() throws Exception {
		when(PermissionThreadLocal.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockPermissionChecker.getUserId()).thenReturn(USER_ID);

		questionResourceImpl.deleteUserProfileQuestion(QUESTION_ID_1);

		verify(mockReadinessService, times(1)).deleteAnswer(QUESTION_ID_1, USER_ID);
	}

	@Test
	public void getUserProfileQuestion_WhenNoError_ThenReturnsTheQuestionForTheUser() throws Exception {
		when(PermissionThreadLocal.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockPermissionChecker.getUser()).thenReturn(mockUser);
		when(mockReadinessService.getQuestion(QUESTION_ID_1, mockUser)).thenReturn(mockReadinessQuestion1);
		mockQuestionDetails(mockReadinessQuestion1, QUESTION_ID_1, INDEX_1, NAME_1, OPTIONS_1, SELECTED_ANSWER_1);

		Question result = questionResourceImpl.getUserProfileQuestion(QUESTION_ID_1);

		verifyQuestionDetails(result, QUESTION_ID_1, INDEX_1, NAME_1, OPTIONS_1, SELECTED_ANSWER_1);
	}

	@Test(expected = Exception.class)
	public void getUserProfileQuestion_WhenExceptionRetrievingQuestion_ThenThrowsException() throws Exception {
		when(PermissionThreadLocal.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockPermissionChecker.getUser()).thenReturn(mockUser);
		when(mockReadinessService.getQuestion(QUESTION_ID_1, mockUser)).thenThrow(new PortalException());

		questionResourceImpl.getUserProfileQuestion(QUESTION_ID_1);
	}

	@Test
	public void getUserProfileQuestionnairePage_WhenNoError_ThenReturnsTheQuestionsForTheUser() throws Exception {
		when(PermissionThreadLocal.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockPermissionChecker.getUser()).thenReturn(mockUser);
		List<ReadinessQuestion> questions = new ArrayList<>();
		questions.add(mockReadinessQuestion1);
		questions.add(mockReadinessQuestion2);
		questions.add(mockReadinessQuestion3);
		when(mockReadinessService.getQuestions(mockUser)).thenReturn(questions);
		mockQuestionDetails(mockReadinessQuestion1, QUESTION_ID_1, INDEX_3, NAME_1, OPTIONS_1, SELECTED_ANSWER_1);
		mockQuestionDetails(mockReadinessQuestion2, QUESTION_ID_2, INDEX_1, NAME_2, OPTIONS_2, SELECTED_ANSWER_2);
		mockQuestionDetails(mockReadinessQuestion3, QUESTION_ID_3, INDEX_2, NAME_3, OPTIONS_3, SELECTED_ANSWER_3);

		Page<Question> results = questionResourceImpl.getUserProfileQuestionnairePage();

		assertThat(results.getItems().size(), equalTo(3));

		Iterator<Question> iterator = results.getItems().iterator();
		Question questionOne = iterator.next();
		Question questionTwo = iterator.next();
		Question questionThree = iterator.next();

		verifyQuestionDetails(questionOne, QUESTION_ID_2, INDEX_1, NAME_2, OPTIONS_2, SELECTED_ANSWER_2);
		verifyQuestionDetails(questionTwo, QUESTION_ID_3, INDEX_2, NAME_3, OPTIONS_3, SELECTED_ANSWER_3);
		verifyQuestionDetails(questionThree, QUESTION_ID_1, INDEX_3, NAME_1, OPTIONS_1, SELECTED_ANSWER_1);
	}

	@Test(expected = Exception.class)
	public void getUserProfileQuestionnairePage_WhenExceptionRetrievingQuestions_ThenThrowsException() throws Exception {
		when(PermissionThreadLocal.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockPermissionChecker.getUser()).thenReturn(mockUser);
		when(mockReadinessService.getQuestions(mockUser)).thenThrow(new PortalException());

		questionResourceImpl.getUserProfileQuestionnairePage();
	}

	@Test
	public void putUserProfileQuestion_WhenNoError_ThenUpdatesTheAnswer() throws Exception {
		when(PermissionThreadLocal.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockPermissionChecker.getUserId()).thenReturn(USER_ID);

		questionResourceImpl.putUserProfileQuestion(QUESTION_ID_1, SELECTED_ANSWER_1);

		verify(mockReadinessService, times(1)).updateAnswer(QUESTION_ID_1, USER_ID, SELECTED_ANSWER_1);
	}

	@Test(expected = Exception.class)
	public void putUserProfileQuestion_WhenExceptionUpdatingAnswer_ThenThrowsException() throws Exception {
		when(PermissionThreadLocal.getPermissionChecker()).thenReturn(mockPermissionChecker);
		when(mockPermissionChecker.getUserId()).thenReturn(USER_ID);
		doThrow(new PortalException()).when(mockReadinessService).updateAnswer(QUESTION_ID_1, USER_ID, SELECTED_ANSWER_1);

		questionResourceImpl.putUserProfileQuestion(QUESTION_ID_1, SELECTED_ANSWER_1);

	}

	private void mockQuestionDetails(ReadinessQuestion readinessQuestion, Long questionId, int index, String name, String[] options, String selectedAnswer) {
		when(readinessQuestion.getQuestionId()).thenReturn(questionId);
		when(readinessQuestion.getIndex()).thenReturn(index);
		when(readinessQuestion.getAvailableAnswers()).thenReturn(options);
		when(readinessQuestion.getQuestionTitle()).thenReturn(name);
		when(readinessQuestion.getUserAnswer()).thenReturn(selectedAnswer);
	}

	private void verifyQuestionDetails(Question result, Long questionId, int index, String name, String[] options, String selectedAnswer) {
		assertThat(result.getId(), equalTo(questionId));
		assertThat(result.getIndex(), equalTo(index));
		assertThat(result.getName(), equalTo(name));
		assertThat(result.getOptions(), equalTo(options));
		assertThat(result.getSelectedAnswer(), equalTo(selectedAnswer));
	}
}
