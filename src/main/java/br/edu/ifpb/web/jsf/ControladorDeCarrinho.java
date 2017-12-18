package br.edu.ifpb.web.jsf;

import br.edu.ifpb.dac.CarrinhoOnline;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/12/2017, 09:22:31
 */
@Named
//@RequestScoped
@SessionScoped
public class ControladorDeCarrinho implements Serializable {

    private String produto;
    //private List<String> produtos = new ArrayList<>();

    @Inject
    private CarrinhoOnline carrinho;

    public String add() {
//        this.produtos.add(produto);
        this.carrinho.adicionarNovoProduto(produto);
        this.produto = "";
        return null;
    }

    public String remove(String produtoSelecionado) {
//        this.produtos.remove(produtoSelecionado);
        this.carrinho.removerProduto(produtoSelecionado);
        return null;
    }

    public String finalizar() {
//        this.produtos.clear();
        this.carrinho.finalizarCompra();
        encerrarSessao();
        return null;
//        return "home.xhtml?faces-redirect=true";
    }

    public List<String> todosOsprodutos() {
        return this.carrinho.todosOsProdutos();
    }

    @PostConstruct
    public void init() {
        this.carrinho.adicionarNovoProduto("Tv");
        this.carrinho.adicionarNovoProduto("Geladeira");
        this.carrinho.adicionarNovoProduto("Mesa");
        this.carrinho.adicionarNovoProduto("Cama");
    }

    private void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        if (session != null) {
            session.invalidate();
        }
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

}
