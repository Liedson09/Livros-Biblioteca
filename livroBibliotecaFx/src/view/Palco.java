
package view;

import java.io.IOException;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author INF15
 * 
 */
public class Palco extends Application {
   static Stage palco;
   
 
   public static Scene sceneCadastroLivros;
   public static Scene sceneVisualizarLivros ;
   public static Scene scener;

    public static void telaPrincipal(String tela_Principal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void start(Stage stage) throws IOException{
        palco = stage;
       
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
        Parent cadastroLivros = FXMLLoader.load(getClass().getResource("FXMLCadastroLivro.fxml"));
        Parent visualizarLivros = FXMLLoader.load(getClass().getResource("FXMLVisualizar.fxml"));
      
         scener = new Scene(root, 600, 600);
         sceneCadastroLivros = new Scene(cadastroLivros, 500, 300);
         sceneVisualizarLivros = new Scene(visualizarLivros, 600, 400);
        stage.setTitle("Tela Principal");
        stage.setScene(scener);
        stage.setResizable(true);
        stage.show();
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void cadastroLivros(){
        palco.setTitle("Cadastro de Livros");
        palco.setScene(sceneCadastroLivros);        
    }
    
    public static void mostrarLivros(){
        palco.setTitle("Visualizar Livros");
        palco.setScene(sceneVisualizarLivros);
    }
    
    public static void telaPrincipal(){
        palco.setTitle("Tela Principal");
        palco.setScene(scener);
    }
    
    
}
