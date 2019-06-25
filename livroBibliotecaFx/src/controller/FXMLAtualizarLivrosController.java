package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Livros;
import view.Palco;

/**
 * FXML Controller class
 *
 * @author Israel
 */
public class FXMLAtualizarLivrosController implements Initializable {
    
    @FXML private TextField txtDescricao;
    
    @FXML private Button btFechar;
    
    @FXML private TextField txtCodigo;
    
    @FXML private TextField txtQunatidade;
    
    private Stage stage;
    private boolean btnAtualizar = false;
    Livros livro = new Livros();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isBtnSalvar() {
        return btnAtualizar;
    }

    public void setBtnSalvar(boolean btnSalvar) {
        this.btnAtualizar = btnSalvar;
    }
    @FXML
    void handleSalvar() {        
        livro.setCodigo(Integer.parseInt(txtCodigo.getText()));
        livro.setDescricao(txtDescricao.getText());
        livro.setQuantidade(Integer.parseInt(txtQunatidade.getText()));    
        btnAtualizar = true;
        stage.close();
        
    }

    @FXML
    void handleCancelar() {
        stage.close();
    }
    
    public void setLivro(Livros livro){
        this.livro = livro;
        txtCodigo.setText(String.valueOf(livro.getCodigo()));
        txtDescricao.setText(String.valueOf(livro.getDescricao()));
        txtQunatidade.setText(String.valueOf(livro.getQuantidade()));
        
    }
     @FXML
    void fechar(ActionEvent event) {
        Palco.telaPrincipal();
    }
    
    
    
    
    
    
}
