/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.util.ArrayList;
import modelo.Produto;
import persistencia.Conexao;
import persistencia.JDBCProduto;

/**
 *
 * @author ricar_iy0h
 */
public class Principal {
    
    public static void main(String[] args) {
        Produto p = new Produto("café", 5, 8);
        Conexao fabrica = new Conexao();
        JDBCProduto gerente = new JDBCProduto(fabrica.abrirConexao());
        gerente.inserirProduto(p);
        
        ArrayList<Produto> produtos = gerente.listarProdutos();
        
        for (Produto p1: produtos) {
            System.out.println(p1);
        } 
        fabrica.fecharConexao();
    }
}
