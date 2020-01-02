package com.byzoro.entity;

import java.io.Serializable;

public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    private Integer id;

    /**
    * 
    */
    private String name;

    /**
    * 
    */
    private Integer parentId;

    /**
    * 
    */
    private Integer type;

    /**
    * 
    */
    private String code;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" [");
        builder.append("id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", parentId=");
        builder.append(parentId);
        builder.append(", type=");
        builder.append(type);
        builder.append(", code=");
        builder.append(code);
        builder.append("]");
        return builder.toString();
    }


}
