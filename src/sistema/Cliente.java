
package sistema;

public class Cliente {
    
    int clienteID;
    String nome;
    String email;
    
    public Cliente(int id, String nome, String email){
        this.clienteID = id;
        this.nome = nome;
        this.email = email;
    }
    public Cliente(){
        
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void nomeNull(){
        this.nome = null;
    }
    
}
