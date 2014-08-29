package ua.bes.calculate.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.bes.calculate.content.Calc;
import ua.bes.calculate.content.Data;

@RequestMapping("/calc")
@Controller
public class CalcController {

    @RequestMapping(value = "/jsp")
    public ModelAndView calcJSP(HttpServletResponse response) throws IOException {
	return new ModelAndView("calcJSP");
    }

    @RequestMapping(value = "/html")
    public void calcHTML(HttpServletResponse response) throws IOException {
	response.sendRedirect("/resources/static/calcHTML.html");
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public @ResponseBody String post(@RequestBody final Data data, Calc calc) {
	
	return calc.setPar(data);
    }
}
