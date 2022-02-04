package ru.mvxdev.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mvxdev.objects.ConnectionORA;

import javax.jms.JMSException;
import java.sql.SQLException;

@Controller
public class MainController {

    public ConnectionORA connectionORA;
    private String ora_url;
    private String ora_login;
    private String ora_pass;
    private String connection_state = "connect off";
    private String queue_name_g;

    private static Logger logger = LoggerFactory.getLogger(ConnectionORA.class);

    @GetMapping("/")
    public String index(ModelMap model) {

        model.addAttribute("url",ora_url);
        model.addAttribute("login",ora_login);
        model.addAttribute("pass",ora_pass);
        model.addAttribute("c_state",connection_state);
        return "index";
    }

    @PostMapping("/connect_ora")
    public String createOraConnection(@ModelAttribute("cora") ConnectionORA connectionORA,
                                      BindingResult result, ModelMap model) throws SQLException, JMSException {
        if(result.hasErrors()) logger.error("fuck!!!");

        this.connectionORA = connectionORA;

        ora_url = connectionORA.getUrl();
        ora_login = connectionORA.getLogin();
        ora_pass = connectionORA.getPass();

        connectionORA.initialize();
        connection_state = "connect on";

        model.addAttribute("url", connectionORA.getUrl());
        model.addAttribute("login", connectionORA.getLogin());
        model.addAttribute("pass", connectionORA.getPass());
        model.addAttribute("c_state",connection_state);

        return "/send_msg";
    }

    @GetMapping("/send_msg")
    public String send_msg_page(ModelMap model) {

        model.addAttribute("c_state",connection_state);
        return "send_msg";
    }

    @PostMapping("/send_msg")
    public void send_msg(@RequestParam(required = false)String queue_name,@RequestParam(required = false)String data,ModelMap model) throws JMSException {
        queue_name_g = queue_name;
        model.addAttribute("queue_name",queue_name_g);
        model.addAttribute("c_state",connection_state);
        connectionORA.sendTextMsg(queue_name,data);

    }
}
