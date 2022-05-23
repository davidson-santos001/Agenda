
package Controller;


import Views.FrmAgenda;

/**
 *  29/04/2021
 * @author d
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // instanciar a janela do aplicativo 
        
        FrmAgenda janela = new FrmAgenda();
        
        janela.setVisible(true);
        janela. setTitle("Agenda de contatos");
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        
      
        
        // exemplos TBT
       // Contatos pessoa2 = new Contatos(4,"calos","7777-0001","carlos@gmail.com");
   //   pessoa.setnome("Antonio");
   // pessoa.getnome();
    }
    
}
