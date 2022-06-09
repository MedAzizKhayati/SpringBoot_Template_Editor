package com.travel.agent.model;

import javax.persistence.*;

@Entity
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String htmlFileName;

    public Template() {

    }

    public Template(String name, String htmlFileName, String data) {
        this.htmlFileName = htmlFileName;
        this.data = data;
        this.name = name;
    }

    @Lob
    private String data;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHtmlFileName() {
        return htmlFileName;
    }

    public void setHtmlFileName(String htmlFileName) {
        this.htmlFileName = htmlFileName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", htmlFileName='" + htmlFileName + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}


