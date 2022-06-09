package com.travel.agent.service;

import com.travel.agent.model.Template;
import com.travel.agent.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateRepository templateRepository;

    public List<Template> findAll() {
        return templateRepository.findAll();
    }

    public Template findById(long id) {
        return templateRepository.findById(id).get();
    }

}
