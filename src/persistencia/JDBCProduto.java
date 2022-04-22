/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Produto;
/**
 *
 * @author ricar_iy0h
 */
public class JDBCProduto {
    Connection conexao;
    
    public JDBCProduto(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserirProduto(Produto p){
        String sql = "insert into produto(nome,valor,quantidade) values (?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1,p.getNome());
            ps.setInt(2, p.getValor());
            ps.setInt(3, p.getQuantidade());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**
     *
     * @return
     */
    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        String sql = "select* from produto";
        try {
            Statement declaracao = conexao.createStatement();
            ResultSet resposta = declaracao.executeQuery(sql);
        
        
        while(resposta.next()) {
            
            int id = resposta.getInt("id");
            String nome = resposta.getString("nome");
            int valor = resposta.getInt("valor");
            int quantidade = resposta.getInt("quantidade");
            
            Produto p = new Produto(id, nome, valor, quantidade);
            produtos.add(p);
        } 
    } catch (SQLException ex) {
        Logger.getLogger(JDBCProduto.class.getName()).log(Level.SEVERE, null, ex);
    }
        return produtos;
        
  }
    public void apagarTudo() {
        String sql = "delete from produto";
        
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
         Logger.getLogger(JDBCProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
    
        
        
