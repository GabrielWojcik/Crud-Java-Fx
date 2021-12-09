package com.example.trabalhocrud;
import java.sql.PreparedStatement;

class Cadastros{
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private  String endereco;

    public Cadastros (String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public  String getNome(){return  nome;}

    public  String getTelefone(){return  telefone;}

    public  String getEmail(){return  email;}

    public  String getEndereco(){return endereco;}

    private  void pesquisarRecord(){
        //Comando para pesquisar os dados
        String pesquisar = "SELECT * FROM cadastros";
    }

    private void insertRecord() {
        //Comando para inserir dados
        String insercao = "INSERT INTO cadastros(nome, telefone, email, endereco) values(?,?,?,?)";
    }

    private void updateRecord(){
        //Comando para atualizar dados
        String atualizar = "UPDATE from cadastros SET nome= ? WHERE id= ?";
    }
    private  void deleteRecord(){
        //Removendo dados
        String remover = "DELETE from cadastros where id= ?";
    }

}
    
    
