package ru.mvxdev.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, ModelMap model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object errMsg = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object exp = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        model.addAttribute("code",Integer.valueOf(status.toString()));
        model.addAttribute("err_msg",errMsg.toString());
        model.addAttribute("exp",exp.toString());

        return "error";
    }
}
