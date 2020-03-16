package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pageobject.CheckoutPagina;
import pageobject.ProdutoPagina;
import pageobject.SelecaoCategoriaPagina;
import pageobject.SelecaoProdutoPagina;
import pageobject.ShoppingCartPagina;
import pageobject.SucessoCompraPagina;

public class CompraProdutoTeste extends ClasseBaseTeste{

	private SelecaoCategoriaPagina selecaoCategoriaPagina;
	private ProdutoPagina produtoPagina;
	private SelecaoProdutoPagina selecaoProdutoPagina;
	private ShoppingCartPagina shoppingCartPagina;
	private CheckoutPagina checkoutPagina;
	private SucessoCompraPagina sucessoCompraPagina;
	
	@Before
	public void antesDoTeste() throws InterruptedException {
		iniciaAplicacao();
		selecaoCategoriaPagina = new SelecaoCategoriaPagina(driver);
		produtoPagina = new ProdutoPagina(driver);
		selecaoProdutoPagina = new SelecaoProdutoPagina(driver);
		shoppingCartPagina= new ShoppingCartPagina(driver);
		checkoutPagina= new CheckoutPagina(driver);
		sucessoCompraPagina = new SucessoCompraPagina(driver);
	}

	@Test
	public void compraProduto() {
		selecaoCategoriaPagina.selecionaProduto();
		selecaoProdutoPagina.selecionaProduto();
		produtoPagina.adicionaAoCarrinho();
		Assert.assertTrue(shoppingCartPagina.verificaMensagem());
		shoppingCartPagina.vaiParaCheckout();
		checkoutPagina.preencheFormularios();
		Assert.assertTrue(sucessoCompraPagina.verificaMensagem());
		sucessoCompraPagina.continuaCompra();
	}
	
}
