package uz.pdp.spring_boot_lessons;

import ch.qos.logback.core.model.Model;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public BaseController(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @GetMapping("/home")
    public ModelAndView home() {

        String sql = "select * from auth_user";
        List<User> users = namedParameterJdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(User.class));
        users.forEach(System.out::println);

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

}
