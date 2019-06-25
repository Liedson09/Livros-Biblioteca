
package controller;

import dao.LivrosDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Livros;
import view.Palco;

/**
 * FXML Controller class
 *
 * @author INF15
 */
public class FXMLCadastroLivroController implements Initializable {

      @FXML
    private Button btSalvar;
      @FXML
    private Button btFechar;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtQuantidade;;

    

    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void salvar(ActionEvent event) {
        LivrosDAO dao = new LivrosDAO();
        Livros bliblioteca = new Livros();
        bliblioteca.setCodigo(Integer.parseInt(txtCodigo.getText()));
        bliblioteca.setDescricao(txtDescricao.getText());
        bliblioteca.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        
        
        
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setHeaderText("Cadastro de Livros");
         alert.setContentText(dao.salvar(bliblioteca));
         alert.show();
         Palco.telaPrincipal();
    }
    
    public void limpaCampos(){
        txtQuantidade.setText("");
        txtCodigo.setText("");
        txtDescricao.setText("");
    }
    @FXML
    void fechar(ActionEvent event) {
        Palco.telaPrincipal();
    }
    
        
    

}
