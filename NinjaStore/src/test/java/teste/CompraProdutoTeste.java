package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pageobject.CheckoutPagina;
import pageobject.ProdutoPagina;
import pageobject.SelecaoCategoriaProdutoPagina;
import pageobject.SelecaoProdutoPagina;

public class CompraProdutoTeste extends ClasseBaseTeste{

	private SelecaoCategoriaProdutoPagina selecaoCategoriaProdutoPagina;
	private SelecaoProdutoPagina selecaoProdutoPagina;
	private ProdutoPagina produtoPagina;
	private CheckoutPagina checkoutPagina;
	
	@Before
	public void antesDoTeste() {
		iniciaAplicacao();
		selecaoCategoriaProdutoPagina = new SelecaoCategoriaProdutoPagina(driver);
		selecaoProdutoPagina = new SelecaoProdutoPagina(driver);
		produtoPagina = new ProdutoPagina(driver);
		checkoutPagina = new CheckoutPagina(driver);
	}
	
	@Test
	public void compraProduto() throws InterruptedException {
		selecaoCategoriaProdutoPagina.selecionaMenuCamera();
		selecaoProdutoPagina.selecionaProduto();
		produtoPagina.adicionaAoCarrinho();
		Assert.assertTrue(produtoPagina.verificaMensagem());
		produtoPagina.vaiParaCheckout();
		checkoutPagina.preencheFormulario();
		Assert.assertTrue(checkoutPagina.verificaMensagem());
		checkoutPagina.finaliza();
	}
}
