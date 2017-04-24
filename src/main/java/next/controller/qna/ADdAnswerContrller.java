package next.controller.qna;

import com.fasterxml.jackson.databind.ObjectMapper; // 잭슨 라이브러리 json 생성
import core.mvc.Controller;
import next.dao.AnswerDao;
import next.model.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by woowahan on 2017. 4. 24..
 */
public class ADdAnswerContrller implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Answer answer = new Answer(req.getParameter("writer"), req.getParameter("contents"),
                Long.parseLong(req.getParameter("questionId")));
        AnswerDao answerDao = new AnswerDao();
        Answer savedAnswer = answerDao.insert(answer);
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");;
        PrintWriter out =resp.getWriter();
        out.print(mapper.writeValueAsString(savedAnswer));
        return null;
    }
}
