package com.example.trabalhocrud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Formulário de Cadastro");
        stage.setScene(scene);
        stage.show();
        //Teste de conexão com o banco de dados
        try{
            Connection connect = DriverManager.getConnection("jbdc:sqlite:D:\\banco_unifaesp\\banco_unifaesp.db");
            System.out.println("Conexão OK");
            //Login no sistema
            System.out.println("Digite seu login: ");
            String login = new Scanner(System.in).next();
            System.out.println("Digite sua senha: ");
            String senha = new Scanner(System.in).next();
            String validarLogin = "select *from usuarios where login = ? and senha = ?";
            PreparedStatement loginStatement = connect.prepareStatement(validarLogin);
            loginStatement.setString(1, login);
            loginStatement.setString(2, senha);
            ResultSet loginResult = loginStatement.executeQuery();
            if(loginResult.next()){
                System.out.println("Usuário: " + loginResult.getString("login"));
                System.out.println("Senha: " + loginResult.getString("senha"));
            }else{
                System.out.println("Login incorreto!");
            }
            //Executar SELECT
            Statement consulta = connect.createStatement();
            ResultSet resultado = consulta.executeQuery("select * from cadastros");
            System.out.println(resultado);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}