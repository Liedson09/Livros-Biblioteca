package controller;

import dao.LivrosDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Livros;
public class FXMLController implements Initializable {
    
    @FXML private TableView<Livros> tabela;
    @FXML private TableColumn<Livros, String> cDescricao;
    @FXML private TableColumn<Livros, String> cQuantidade;
    @FXML private TableColumn<Livros, Integer> cCodigo;
    LivrosDAO dao = new LivrosDAO();
   

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializeTable();
    }    

    private void inicializeTable() {
      cCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
       cDescricao.setCellValueFactory(  new PropertyValueFactory<>("descricao"));
       cQuantidade.setCellValueFactory(  new PropertyValueFactory<>("quantidade"));       
       tabela.setItems(listarLivros());
    }

    private ObservableList<Livros> listarLivros() {
        List<Livros> lista =  dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);
        
    }
    
}
