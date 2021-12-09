package com.example.trabalhocrud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.PreparedStatement;

public class HelloController{
    Connection connect;

    {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:/home/valdinei/Documentos/banco_unifaesp.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private Label welcomeText;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    private  TextField txtEndereco;

    @FXML
    private Button btnInserir;

    @FXML
    private  Button btnPesquisar;

    @FXML
    private Button btnAtualizar;

    @FXML
    private  Button btnExcluir;

    @FXML
    private Label lblTitulo = new Label();

    @FXML
    private TableView tableView;

    @FXML
    TableColumn <String, String> colunaNome;

    @FXML
    TableColumn <String, String> colunaEmail;

    @FXML
    TableColumn <String, String> colunaTelefone;

    @FXML
    TableColumn <String, String> colunaEndereco;


    @FXML
    public void inserir(ActionEvent event){
        String insercao = "INSERT INTO cadastros(nome, telefone, email, endereco) values(?,?,?,?)";
        System.out.println(insercao);
        System.out.println("Cadastro inserido!");
    }
    @FXML
    public void inputNome(ActionEvent event){
        System.out.println("Inserindo Cadastro: Nome");
    }
    @FXML
    public  void btnpesquisar(ActionEvent event){
        String pesquisar = "SELECT * FROM cadastros";
        System.out.println(("Pesquisando dados..."));
        try (PreparedStatement prepare = connect.prepareStatement(pesquisar)) {
            prepare.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(("Cadastro Atualizado com Sucesso"));
        }
    }
    @FXML
    public  void btnatualizar(ActionEvent event){
        String  btnatualizar = "UPDATE FROM CADASTROS WHERE ID = ? ";
        try (PreparedStatement prepare = connect.prepareStatement(btnatualizar)) {
           prepare.execute();
           System.out.println(("Cadastro Atualizado com Sucesso"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    @FXML
    public  void btnexcluir(ActionEvent event){
        String btnexcluir = "DELETE FROM CADASTROS where ID = ?";
        try (PreparedStatement prepare = connect.prepareStatement(btnexcluir)) {
            prepare.execute();
            System.out.println(("Cadastro Removido com Sucesso"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
