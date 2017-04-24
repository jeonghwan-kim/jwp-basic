package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class AddQuestionController extends AbstractController {
    private static final Logger log = LoggerFactory.getLogger(AddAnswerController.class);

    private QuestionDao questionDao = new QuestionDao();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse response) throws Exception {
        Object user = req.getSession().getAttribute("user");
        log.debug("session: {}", user);
        if (user == null) {
            return jsonView().addObject("error", "Unauthorized");
        }

        Question question = new Question(
                req.getParameter("writer"),
                req.getParameter("title"),
                req.getParameter("contents")
        );

        log.debug("question : {}", question);

        Question savedQuestion = questionDao.insert(question);
        return jsonView().addObject("question", savedQuestion);
    }
}
