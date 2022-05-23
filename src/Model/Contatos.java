
package Model;

/**
 *  29/04/2021
 * @author d
 */
public class Contatos {
    
    
// atributos da classe
 // atributos da classe  privados encapsulamento  
    //( precisa do getset para poder acessar quando ela estiver privada )
    // botão direito , inserir codigo , get setter ( encapisular)
    private int codigo;
    private String nome;
    private String fone;
    private String email;
    
    // construtor  padrao
    public  Contatos (){
    
  }
    
    // construtor de inicializacao padrao
      
 // public Contatos (){
      
   //   codigo =0;
   //  nome="";
 ///  fone="";
   // email="";
 // }
    
    // encapsular os atributos da classe 
    // construtor da classe com passagem de parametros 
    
    public Contatos(int codigo, String nome, String fone, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }
    
// metodos criados para acessar atributos privados 
   // serve para pegar informação  
    
    public String getEmail() {
        return email;
    }
// serve para autorizar ou inserir novos dados ou atualizar...
    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       
           this.nome = nome;
      
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
    
}
