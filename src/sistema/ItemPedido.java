
package sistema;

public class ItemPedido {

    String item;
    int quantidade;
    float preco;
    float total;

    public ItemPedido( String item, int quantidade, float preco) {

        this.item = item;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedido() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public float Total(){
        this.total = 0;
        this.total = preco*quantidade;
        return total;
    }
    
}
