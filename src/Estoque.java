import java.util.List;
import java.util.ArrayList;

public class Estoque extends Produto{

    List<Produto> listaProdutos = new ArrayList<>();


    public Estoque(){
        listaProdutos.add(new Produto("Biscoito", "F. Fortaleza", 1234, 100, 2.8, 2.0, new Date(30,05,2017)));
        listaProdutos.add(new Produto("Arroz", "F. Castelo", 1235, 200, 8.3, 7.25, new Date(30,05,2017)));
        listaProdutos.add(new Produto("Feijão", "M. Dias Branco", 3333, 245, 4.6, 3.85, new Date(30,05,2017)));
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        s.append("=================================== Lista de Produtos no Estoque ================================\n");

        for (int i = 0; i < listaProdutos.size(); i++) {

            s.append("#" + (i+1) +
                    " Nome: [" + listaProdutos.get(i).getNome() + "], " +
                    "Fabricante: [" + listaProdutos.get(i).getFabricante() + "], " +
                    "Quantidade: [" + listaProdutos.get(i).getQuantidade() + "], " +
                    "Custo: [R$ " + listaProdutos.get(i).getCusto() + "], " +
//                    "Preço Venda: [R$ " + listaProdutos.get(i).getPrecoVenda() + "], " +
                    "Data Estoque: [" + listaProdutos.get(i).getDataEntradaEstoque() + "], " +
                    "Codigo: [" + listaProdutos.get(i).getCodigo() + "], " + "\n");
        }
        s.append("=================================================================================================");
        return s.toString();
    }
}
