
package Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *  30/04/2021
 * @author d
 */
public class TestaConexaoDAO {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * 
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
 
       
        // cria a conexao com o DB 
     ConnexaoDAO.conectarDB();
        
        // exibe o valor de status (se falhar,mensagem informara)
        JOptionPane.showMessageDialog(null, ConnexaoDAO.statusDB(), "Verificacao de conexao",1);
 
        // fecha a conexao com o DB
        ConnexaoDAO.desconectarDB();
    }
    
}
