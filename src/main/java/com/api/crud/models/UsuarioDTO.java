package com.api.crud.models;

public class UsuarioDTO {
    private Long id;
    private String name;
    private String usuario;
    private Integer priority;

    public UsuarioDTO(Long id, String name, String usuario, Integer priority) {
        this.id = id;
        this.name = name;
        this.usuario = usuario;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

