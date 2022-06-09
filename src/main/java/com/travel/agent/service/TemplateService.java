package com.travel.agent.service;


import java.util.List;

import com.travel.agent.model.Template;

public interface TemplateService {

    Template findById(long id);

    List<Template> findAll();

}
