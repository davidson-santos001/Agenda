
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 29/04/2021
 * @author d
 */  // A CLASSE CONEXAO POSSUI 3 METODOS : UM ABRIR :Conectar ao banco de dados(),
     // outro metodo para fechar a conexao com a base de dados: desconectar o database(),
    // e um terceiro metodo para exibir o status atual da conexao.
public class ConnexaoDAO {
    //variavel 
    public static Connection conn = null;
    // variavel de configuracao Timezone e SSL caso de erro na versao 8 do mysql
   //public static final String Conf = "?useTimezone=true&serverTimezone=UTC;useSSL=false";
    //variavel de URL ( caminho de unidade e arquivo )
   // public static String url = "jdbc:mysql://localhost:3306/agenda"+Conf;
    
     public static String url = "jdbc:mysql://localhost:8080/agenda?useSSL=false&useTimezone=true&serverTimezone=UTC";     
    //variavel Login do Usuario no mysql
    public static String usuario ="root";
    //variavel senha do usuariono mysql
    public static String senha = "dmx123";
    // variavel informa status = "Sem conexao com o banco de dados ";
    
    public static String status ="Sem conexao com o banco de dados ";
    // variavel informa o tipo de icone na messagebox
    public static int icone = 0 ;
    // -----------------------------------------metodo para estabelecer a conexao 
    
    public static Connection conectarDB() throws SQLException{
        
        // as instruçoes irao obter "Driver" e a conexao 
        // devem ser inseridos em um bloco try/catch,
        // onde podem ser tratados possiveis problemas de conexao 
        
        try{
             // carregando o driver para a conexao
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                /**
                 * para abrir a conexao será utilizado o metodo getConnection()
                 * do DriverManager, que recebe a URL, usuario e a senha do banco
                 * a partir daqui podemos usar os statements para o metodo CRUD.
                 */
                conn = DriverManager.getConnection(url, usuario, senha);
                
                status = "Pronto !! = conexao realizada...";
                icone = 1;
        } catch(ClassNotFoundException ec){
                    // a variavel ec vai receber a mensagem de excecao
                  status = "Erro - o driver especificadon nao foi encontrado";
                 icone= 0;
                  return null;
                } catch (SQLException es){
                    // a variavel es vai receber a mensagem de excecao 
                    status = "Erro de conexao = banco de dados nao encontrado";
                     icone= 2;
                    return null;
                }
                return conn;
    }
    
     // -----------------------------------------metodo para finalizar  a conexao
    public static boolean desconectarDB()throws SQLException{
        try {
            /**
             *  o fechamento da conexao ocorrera quando esse metodo receber 
             * um objeto do tipo Connection e sera fechado
             *  na sequencia fecha  o PreparedStatement e o ResultSet
             */
             conn.close();
            status = "Banco de Dados desconectado !!";    
            return true;
        } catch (SQLException es) {
            
        }
        return false;

    }
    // -----------------------------------------metodo para finalizar  a conexa
    
    public static String statusDB(){
        return status;
    } 
}
