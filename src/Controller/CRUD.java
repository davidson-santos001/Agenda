package Controller;

import static Controller.ConnexaoDAO.conn;
import Model.Contatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * 04/052021
 *
 * @author d
 */
public class CRUD {

    public static ArrayList<Contatos> exibir;
    // CRUD - create, read, update & delete ( Banco de dados )

    // -----------------------------------------metodo para inserir registro Contatos
// declarar contatos do tipo pessoal, para não precisar digitar todos atributos da classe do package model 
    // //, ClassNotFoundException   se der bizil tirar aspas 
    public void inserir(Contatos pessoa) throws SQLException //, ClassNotFoundException
    {

        // sentença SQL a '?' e parametro adicionado na base de dados 
        // escreva codigo se não estiver com auto increments no banco de dados 
        String sql = " insert into Contatos (codigo, nome, fone, email)"
                + "values(?,?,?,?)";

        Connection conn;
        // cria uma conexao com DB ( banco de dados )
        conn = ConnexaoDAO.conectarDB();

        // obejeto da classe jdbc que dispara as instruções SQL para o banco de dados  
        PreparedStatement psm;

        // cria um PreparedStatement = classe usada para - classe usada para executar a consulta 
        psm = conn.prepareStatement(sql);

        // adiciona os valores de parametros da sql 
        // set int quando estiver sem auto increment 
        psm.setInt(1, pessoa.getCodigo());
        psm.setString(2, pessoa.getNome());
        psm.setString(3, pessoa.getFone());
        psm.setString(4, pessoa.getEmail());

        // executa a sentença SQL para incerção de dados  
        psm.execute();
        JOptionPane.showMessageDialog(null, " Dados inseridos com sucesso.");
        // fecha as conexões 
        psm.close();
        conn.close();

        // -----------------------------------------metodo para remover registro no DB por codigo
    }

    public void remover(int codigo) throws SQLException {

        // intrução SQL onde o ? sera o codigo selecionado para exclusao
        String sql = "Delete from Contatos where codigo=?";

        // cria uma conexao com DB ( banco de dados )
        // Connection conn = ConnexaoDAO.conectarDB();   
        // cria uma conexao com DB ( banco de dados )
        conn = ConnexaoDAO.conectarDB();

        // objeto da classe jdbc que dispara as instruções SQL para o banco de dados  
        PreparedStatement psm;

        psm = conn.prepareStatement(sql);

        //   informe o valor passado como parametro para senteça SQL
        psm.setInt(1, codigo);
        // executa a sentença SQL para incerção de dados  

        psm.execute();

        // fecha as conexões 
        psm.close();
        conn.close();
    }
    //--------------------------metodo para remover registro no DB por codigo

    public void atualizar(Contatos pessoa) throws SQLException, ClassNotFoundException {
        

         // sentença SQL a '?' e parametro adicionado na base de dados 
        // escreva codigo se não estiver com auto increments no banco de dados 
        String sql = "Update Contatos set nome=?,fone=?,email=? where codigo =?";

        Connection conn;
        // cria uma conexao com DB ( banco de dados )
        conn = ConnexaoDAO.conectarDB();

        // obejeto da classe jdbc que dispara as instruções SQL para o banco de dados  
        PreparedStatement psm;

        // cria um PreparedStatement = classe usada para - classe usada para executar a consulta 
        psm = conn.prepareStatement(sql);

        // atualizar os valores de parametros da sql 
        // set int quando estiver sem auto increment 
        psm.setInt(4, pessoa.getCodigo());
        psm.setString(1, pessoa.getNome());
        psm.setString(2, pessoa.getFone());
        psm.setString(3, pessoa.getEmail());

        // executa a sentença SQL para incerção de dados  
        psm.executeUpdate();

        // fecha as conexões 
        psm.close();
        conn.close();

    }

    public List<Contatos> exibir(String nome) throws SQLException, ClassNotFoundException {

        // objeto Arraylist ir´a armazenar os nomes pesquisados com resultSet 
        // ResultSet , criando uma lista dos registro no objeto pessoas 
        List<Contatos> pessoas = new ArrayList();

        // sentença SQL a '?' e parametro pesquisas na base de dados 
        String sql = "Select*from  Contatos where nome like ?";

        Connection conn;

        // obejeto da classe jdbc que dispara as instruções SQL para o banco de dados  
        PreparedStatement psm;
        // cria uma conexao com DB ( banco de dados )
        ConnexaoDAO.conectarDB();
        conn= ConnexaoDAO.conectarDB();
        // cria um PreparedStatement = classe usada para - classe usada para executar a consulta 
       psm =conn.prepareStatement(sql);
         
      // envia criterio de pesquisa de pesquisa para a senteça SQL
        psm.setString(1, nome);

        // ResultSet - Classe que recupera registro no DB (Banco de dados )
        ResultSet rs = psm.executeQuery();

        // Estrutura de repetição - enquanto existir dados na tabela,pesquisa continua
        while (rs.next()) {
            Contatos c = new Contatos();
            // recuperar os dados  e atribuir ao objeto  

            c.setCodigo(rs.getInt("Codigo"));
            c.setNome(rs.getString("Nome"));
            c.setFone(rs.getString("Fone"));
            c.setEmail(rs.getString("Email"));

            // adicionar o Contato recuperado a lista de contatos (tabela)
            pessoas.add(c);
             }
            // fecha as conexões 
            psm.close();
            conn.close();
        
        // retrna a lista de contatos pesquisados 
        return pessoas;
    }
}
