
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Livros;

public class LivrosDAO {
    Connection con = null;
    public LivrosDAO(){
        con = Conexao.abrirConexao();
    }
    
    public List<Livros> pesquisarAll(){
        List<Livros> lista = new ArrayList<>();
        try {            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM LIVROS");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Livros biblioteca = new Livros();
                biblioteca.setCodigo(rs.getInt("codigo"));
                biblioteca.setDescricao(rs.getString("descricao"));
                biblioteca.setQuantidade(rs.getInt("quantidade"));
                lista.add(biblioteca);                
            }
            return lista;
        } catch (Exception e) {
        }
        return null;
    }
    
    public void pesquisar(int numero){}
    
    
    public String salvar(Livros biblioteca){        
        try {
            String sql = "INSERT INTO LIVROS(CODIGO, DESCRICAO, QUANTIDADE) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, biblioteca.getCodigo());
            ps.setString(2, biblioteca.getDescricao());
            ps.setInt(3, biblioteca.getQuantidade());
           
            if(ps.executeUpdate() != 0){
                return "Cadastrado com sucesso";
            }else{
                return "Erro ao cadastrar";
            }
        } catch (Exception e) {
            return "Deu erro";
        }
    }
    
     public boolean deletar(int codigo){
        try {
            String sql = "DELETE FROM LIVROS WHERE CODIGO = '"+codigo+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void atualizar(Livros biblioteca){
        try {
            String sql = "UPDATE LIVROS SET DESCRICAO = ?, QUANTIDADE = ? WHERE CODIGO = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, biblioteca.getDescricao());
            ps.setInt(2, biblioteca.getQuantidade());
            ps.setInt(3, biblioteca.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
    