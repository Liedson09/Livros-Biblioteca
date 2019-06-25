
package controller;

import dao.LivrosDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Livros;
import view.Palco;

/**
 * FXML Controller class
 *
 * @author INF15
 */
public class FXMLVisualizarController implements Initializable {
    @FXML private TableColumn<Livros, Integer> colCodigo;
    @FXML private TableColumn<Livros, String> colDescricao;
    @FXML private TableView<Livros> tabela;
    @FXML private TableColumn<Livros, Integer> colQuantidade; 
    LivrosDAO dao = new LivrosDAO();
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        mostrarTabela();
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
            mostrarTabela();
            }
        };
        timer.start();
    }    

    
        
    @FXML
    public void btExcluir(){        
        Livros biblioteca = new Livros();
        biblioteca = tabela.getSelectionModel().getSelectedItem();        
        if(biblioteca != null){
            if(dao.deletar(biblioteca.getCodigo())){
                Alert alert = new Alert(Alert.AlertType.WARNING);            
                alert.setTitle("Exclusão com sucesso");
                alert.setHeaderText("Exclusão");
                alert.setContentText("Dados excluidos com sucesso");
                alert.showAndWait();
                mostrarTabela();
            }else{
                System.out.println("Erro ao excluir");
            }                             
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);            
            alert.setTitle("Exclusão");
            alert.setHeaderText("Cabeçalho do alerta");
            alert.setContentText("Você deve selecionar um livro para excluir");
            alert.show();
        }        
    }

    public void mostrarTabela(){
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));         
        tabela.setItems(listaLivros());
    }
    public ObservableList<Livros> listaLivros(){
        List<Livros> lista =  dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);        
    }
    @FXML
    public void btAlterar() throws IOException{
        Livros livro = tabela.getSelectionModel().getSelectedItem();
        if(livro != null){
            boolean buttonConfirmaClick = showTela(livro);
            if(buttonConfirmaClick){                
                dao.atualizar(livro);
                mostrarTabela();
            }            
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);            
            alert.setTitle("Alterar");
            alert.setHeaderText("Cabeçalho do alerta");
            alert.setContentText("Você deve selecionar um livro para alterar");
            alert.show();
        }          
    }

    private boolean showTela(Livros livros)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAtualizarLivrosController.class.getResource("/view/FXMLAtualizarLivros.fxml"));
        AnchorPane pagina = (AnchorPane) loader.load();        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Atualizar livros");
        Scene scener = new Scene(pagina);
        dialogStage.setScene(scener);
        
        FXMLAtualizarLivrosController alterarController = loader.getController();
        alterarController.setStage(dialogStage);
        alterarController.setLivro(livros);
        dialogStage.showAndWait();
        return alterarController.isBtnSalvar();
    }
    @FXML
    void btFechar(ActionEvent event) {
        Palco.telaPrincipal();
    }
}