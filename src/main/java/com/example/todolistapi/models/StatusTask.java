package com.example.todolistapi.models;

public enum StatusTask {
	
	IN_PROGRESS("In Progress"),
	COMPLETED("Completed"),
	PENDING("Pending");

	private String descricao;
 
    StatusTask(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }
}
