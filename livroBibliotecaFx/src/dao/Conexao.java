package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {    
    public static Connection abrirConexao(){
        Connection con = null;        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3307/biblioteca";
            System.out.println("Conectado com sucesso");
        
            con = DriverManager.getConnection(url, "root","usbw");
        }catch (SQLException e) {
            System.out.println("Deu erro");
            return null;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver não instalado");
            
        }
        return con;       
    }
    
    
    
    public static void fecharConexao(Connection con){
         try {
            con.close();
            System.out.println("Conexao fechada");
        } catch (Exception e) {
        }
    }    
}
