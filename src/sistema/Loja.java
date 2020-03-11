package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
    List<Pedido> pedidos = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    int i;
    int j;
    int k;
    int quantidade;
    int id = 0;
    String data;
    String item;
    String cliente;
    String email;
    float preco;
    int esc = 0;
    
    public Pedido getPedido(int indice){
        return pedidos.get(indice);
    }
    
    public Cliente getCliente(int indice){
        return getPedido(indice).getC();
    }
    
    public String getNomeCliente(int indice){
        return getCliente(indice).getNome();
    }
    
    
    public void menu(){
        System.out.println("------------------------------------------");
        System.out.println("O que deseja fazer?");
        System.out.println("> Digite 1 para adicionar");
        System.out.println("> Digite 2 para pesquisar");
        System.out.println("> Digite 3 para atualizar");
        System.out.println("> Digite 4 para deletar");
        i = scan.nextInt();
        if(i == 1){
            System.out.println("------------------------------------------");
            System.out.println("ADICIONAR");
            System.out.println("------------------------------------------");
            this.adicionar();
            this.menu();
        }else if(i == 2){
            if(!pedidos.isEmpty()){
                System.out.println("------------------------------------------");
                System.out.println("PESQUISAR");
                System.out.println("------------------------------------------");
                this.pesquisar();
            }else
                System.out.println("!!!Nenhum pedido feito ainda!!!");
            
            this.menu();
        }else if(i == 3){
            if(!pedidos.isEmpty()){
                System.out.println("------------------------------------------");
                System.out.println("ATUALIZAR");
                System.out.println("------------------------------------------");
                this.atualizar();
            }else
                System.out.println("!!!Nenhum pedido feito ainda!!!");
            
            this.menu();
        }else if(i == 4){
            if(!pedidos.isEmpty()){
                System.out.println("------------------------------------------");
                System.out.println("DELETAR");
                System.out.println("------------------------------------------");
                this.deletar();
            }else
                System.out.println("!!!Nenhum pedido feito ainda!!!");
            this.menu();
        }else if(i == 0){
            System.out.println("Sistema encerrando . . .");
        }else{
            System.out.println("!!! Digite um valor valido !!!");
            this.menu();
        } 
    }
    
    //CREATE
    public void adicionar(){
        
        Pedido x = new Pedido();
        pedidos.add(x);
        
        System.out.println("Novo pedido");
        
        System.out.println(">>Qual o primeiro nome do cliente?");
        cliente = scan.next();
        System.out.println(">>Qual seu email?");
        email = scan.next();
        
        getPedido(id).addItem();
        
        System.out.println(">>Insira a data da requisição:");
        data = scan.next();
        
        Cliente c = new Cliente();
        
        c.setNome(cliente);
        c.setEmail(email);
        
        getPedido(id).setData(data);
        getPedido(id).setPedidoID();
        getPedido(id).setC(c);

        System.out.println("------------------------------------------");
        System.out.println("Obrigado "+getNomeCliente(id)+"! Pedido feito! Código ID do pedido: "+getPedido(id).getPedidoID());
        getPedido(id).exibirItens();
        System.out.println("Valor total: R$"+ getPedido(id).Total());
        System.out.println("Um email de confirmção será enviado para "+getCliente(id).getEmail());
        
        id++;
        
    }
    
    //READ
    public void pesquisar(){
        System.out.println("Nova pesquisa");
        System.out.println(">>Deseja pesquisar por cliente(1) ou por id do pedido(2)?");
        i = scan.nextInt();
        if(i == 1){
            esc = 0;
            System.out.println(">>Qual o primeiro nome do cliente?");
            cliente = scan.next();
            for(i = 0; i < pedidos.size(); i++){
                if(cliente.equals(getNomeCliente(i))){
                    System.out.println("O cliente "+cliente+" fez um pedido em "+getPedido(i).getData());
                    System.out.println("Itens:");
                    
                    getPedido(i).exibirItens();
                    System.out.println("Total: R$ "+ getPedido(i).Total());
                    System.out.println("Contato: "+ getCliente(i).getEmail());
                    esc++;
                }
            }
            if(esc == 0) {
                System.out.println("!!!Cliente não encontrado!!!");
            }
        }else if(i == 2){
            System.out.println(">>Insira o código ID disponibilizado na realização do pedido");
            System.out.println("-Não tenho um código ID => insira -1 e pesquise pelo nome do cliente");
            i = scan.nextInt();
            if(i < 0){
                this.pesquisar();
            }else{
                esc = 0;
                
                for(j = 0; j < pedidos.size(); j++){
                    if(getPedido(j).getPedidoID() == i){
                        System.out.println("Código do produto encontrado: "+ i);
                        System.out.println("O cliente "+getNomeCliente(j)+" realizou o pedido em "+getPedido(j).getData());
                        System.out.println("Itens:");
                        getPedido(j).exibirItens();
                        System.out.println("Total: R$ "+ getPedido(j).Total());
                        System.out.println("Contato: "+ getCliente(j).getEmail());
                        esc++;
                    }
                }
                if(esc == 0){
                    System.out.println("!!!Código ID não encontrado!!!");
                }
            }
        }else if(i == 0){
            menu();
        }else
            System.out.println("!!! Digite um valor valido !!!");
    }
    
    //UPDATE
    public void atualizar(){
        System.out.println("Novo update");
        System.out.println(">>Qual seu nome?");
        cliente = scan.next();
        esc = 0;
        for(j = 0; j < pedidos.size(); j++){
            if(cliente.equals(getNomeCliente(j))){
                System.out.println("Bem vindo "+cliente);
                k = j;
                esc++;
            }
        }
        
        if(esc == 0){
            System.out.println("!!!Cliente não encontrado!!!");
        }else{
            esc = 0;
            System.out.println(">>O que deseja alterar?");
            System.out.println("- Cadastro do cliente (1)");
            System.out.println("- Itens do pedido (2)");
            i = scan.nextInt();
            
            if(i == 1){
                
                System.out.println(">>Alterar nome do cliente? Sim(1) / Não (2)");
                i = scan.nextInt();
                if(i == 1){    
                    System.out.println(">>Insira o novo nome do cliente");
                    cliente = scan.next();
                    getCliente(k).setNome(cliente);
                    System.out.println("Nome do cliente alterado");
                    esc++;
                }
                
                System.out.println(">>Alterar email do cliente? Sim(1) / Não (2)");
                i = scan.nextInt();
                if(i == 1){
                    System.out.println(">>Insira o novo email");
                    email = scan.next();
                    getCliente(k).setEmail(email);
                    System.out.println("Email do cliente alterado");
                    esc++;
                }
                
            }else if(i == 2){ 
                getPedido(k).atualizarItem();
                
            }else if(i == 0){
                menu();
            }else{
                System.out.println("!!!Digite um valor válido!!!");
            }
         
            if(esc > 0 || getPedido(k).getEsc() > 0)
                System.out.println("Dados alterados com sucesso!");
            else
                System.out.println("!!!Nenhum item alterado!!!");
        }
    }
    
    //DELETE
    public void deletar(){
        System.out.println("Novo delete");
        System.out.println(">>Qual seu nome?");
        cliente = scan.next();
        esc = 0;
        for(j = 0; j < pedidos.size(); j++){
            if(cliente.equals(getNomeCliente(j))){
                System.out.println("Bem vindo "+cliente);
                k = j;
                esc++;
            }
        }
        if(esc == 0){
            System.out.println("!!!Cliente não encontrado");
        }else{
            esc = 0;
            System.out.println(">>O que deseja deletar?");
            System.out.println("- Pedido (1)");
            System.out.println("- Itens do pedido (2)");
            System.out.println("- Abortar operação (0)");
            i = scan.nextInt();
            if(i == 1){
                
                System.out.println("O pedido no nome de "+getNomeCliente(k)
                                    +", realizado em "+getPedido(k).getData()+", será excluido");
                System.out.println("Itens a serem excluidos juntamente com o pedido:");
                
                
                getPedido(k).exibirItens();
                System.out.println("Total: R$ "+ getPedido(k).Total());
                System.out.println("Contato: "+ getCliente(k).getEmail());
                        
                pedidos.remove(k);
                id--;
                esc++;
                
            }else if(i == 2){
                
                getPedido(k).deletarItens();
            }else if(i == 0){
                menu();
            }else{
                System.out.println("!!!Digite um valor válido!!!");
            }  
        }
        if(esc > 0 || getPedido(k).getEsc() > 0)
            System.out.println("Dados deletados com sucesso!");
        else
            System.out.println("!!!Nenhum item deletado!!!");
    }
    
    
    public static void main(String[] args) {
        Loja l = new Loja();
        System.out.println("Bem vindo.");
        l.menu();
    }
}