package view;

import dao.LivrosDAO;
import java.util.ArrayList;
import java.util.List;
import model.Livros;

/**
 *
 * @author INF15
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LivrosDAO dao = new LivrosDAO();
        List<Livros> lista = new ArrayList<Livros>();
        lista = dao.pesquisarAll();
        
        for(Livros l : lista){
            System.out.println("Descrição:" + l.getDescricao());
        }
    }
    
}
