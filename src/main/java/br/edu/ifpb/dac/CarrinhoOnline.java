package br.edu.ifpb.dac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/12/2017, 09:03:54
 */
@Stateful
public class CarrinhoOnline {

    private List<String> produtos = new ArrayList<>();

    public void adicionarNovoProduto(String produto) {
        System.out.println("Produto adicionado: " + produto);
        this.produtos.add(produto);
    }

    public void removerProduto(String produto) {
        System.out.println("Produto removido: " + produto);
        this.produtos.remove(produto);
    }

    public List<String> todosOsProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    @Remove
    public void finalizarCompra() {
        System.out.println("---Compra finalizada---");
        produtos.forEach(System.out::println);

//        for (int i = 0; i < produtos.size(); i++) {
//            String get = produtos.get(i);
//            System.out.println(i + " - " + get);
//        }
//        IntStream.range(0, produtos.size())
//                .forEach(i -> System.out.println(i + " - " + produtos.get(i)));
    }
}
