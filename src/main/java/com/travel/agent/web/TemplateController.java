package com.travel.agent.web;

import java.util.List;

import com.travel.agent.model.Template;
import com.travel.agent.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.travel.agent.service.UserService;


@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public String list(Model model) {

        List<Template> templates = templateService.findAll();

        model.addAttribute("templatesList", templates);

        return "templatelist";
    }

    @RequestMapping("/show/{id}")
    public String get(@PathVariable("id") int id, Model model) {

        Template template = templateService.findById(id);

        if(template == null)
            return "redirect:/list?error&m=Template with given ID not found!";

        model.addAttribute("template", template);

        return template.getHtmlFileName();
    }

}
