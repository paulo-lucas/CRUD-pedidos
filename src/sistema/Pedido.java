
package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Pedido {
    List<ItemPedido> lista = new ArrayList<>();
    
    Scanner scan = new Scanner(System.in);
    
    Cliente c;
    int pedidoID;
    static int id = 0;
    String data;
    float valorTotal = 0;
    int i;
    int j;
    String item;
    int quantidade;
    float preco;
    int esc;
    public Pedido(){
        
    }

    public Pedido(int pedidoID, String data, Cliente c) {
        this.pedidoID = pedidoID;
        this.data = data;
        this.c = c;
    }

    public ItemPedido getItem(int indice){
        return this.lista.get(indice);
    }

    
    
    
    
    public void delItem(int indice){
        this.lista.remove(indice);
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c){
        this.c = c;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public float Total(){
        this.valorTotal = 0;
        for(i = 0; i < lista.size(); i++){
            valorTotal += lista.get(i).Total();
        }
        return valorTotal;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID() {
        Pedido.id++;
        this.pedidoID = Pedido.id;
    }

    public int getEsc() {
        return esc;
    }
    
    //CREATE
    public void addItem() {
        
        do{
            System.out.println(">>Qual o item a ser pedido");
            item = scan.next();
            System.out.println(">>Qual o valor da mercadoria?");
            preco = scan.nextFloat();
            System.out.println(">>Quantidade de produtos:");
            quantidade = scan.nextInt();
            ItemPedido itempedido = new ItemPedido(item, quantidade, preco);
            lista.add(itempedido);

            System.out.println(">>Mais algum item? Sim(1) / Não (0)");
            i = scan.nextInt();
                        
        }while(i > 0); 
                    
        
    }
    
    //READ
    public void exibirItens(){
        for(i = 0; i < lista.size(); i ++){
            System.out.println(i+") "+ lista.get(i).getItem()+" ("+lista.get(i).getQuantidade()+")");
        }
    }
    
    
    //UPDATE
    public void atualizarItem(){
        System.out.println("Itens do seu pedido:");
        this.exibirItens();
        esc = 0;
        System.out.println("Deseja alterar algum item? Sim (1) / Não (2)");
                int i = scan.nextInt();
                
                if(i == 1){
                    System.out.println("Qual dos itens deseja alterar?");
                    j = scan.nextInt();
                    if(j >= lista.size())
                        System.out.println("!!!Item não existe");
                    else{
                        System.out.println(">>Insira o novo nome do item");
                        item = scan.next();
                        System.out.println(">>Insira o novo preço");
                        preco = scan.nextFloat();
                        System.out.println(">>Insira a nova quantidade");
                        quantidade = scan.nextInt();

                        lista.get(j).setItem(item);
                        lista.get(j).setPreco(preco);
                        lista.get(j).setQuantidade(quantidade);
                        System.out.println("Item alterado com sucesso!");
                        esc++;
                    }
                }
        System.out.println("Deseja adicionar algum item? Sim (1) / Não (2)");
        i = scan.nextInt();
                
        if(i == 1){
            this.addItem();
                    
            esc++;
        }
                
    }
    
    //DELETE
    public void deletarItens(){
        esc = 0;
        System.out.println("Itens do seu pedido: ");
                this.exibirItens();
                System.out.println("Qual dos itens deseja deletar?");
                i = scan.nextInt();
                if(i >= lista.size() || i < 0)
                    System.out.println("!!!Item não existe");
                else{
                    
                    System.out.println("Tem certeza que deseja excluir o item " + lista.get(i).getItem());
                    System.out.println("Sim (1) / Não (2)");
                    j = scan.nextInt();
                    if(j == 1){
                        lista.remove(i);
                        System.out.println("Nova relação de itens: ");
 
                        this.exibirItens();
                        esc++;
                
                    }else{
                        System.out.println("!!!Abortado!!!");
                    }
                }
    }
    
}
