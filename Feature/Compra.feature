#language:pt
@CompraProduto
Funcionalidade: Compra de produto
  A pesquisa deve ser feita pela home page.

  Contexto: 
    Dado que estou na pagina inicial
    E usuario faz login
    E clico no menu SPEAKERS
    E seleciono o produto

  @CompraSucesso
  Cenario: Compra de produto pelo menu inicial com sucesso
    E adiciono ao carrinho
    E vou para a pagina de chekout
    E confirmo o endereco de entrega
    Quando confirmo o pagamento
    Entao eu valido a compra feita

  @CompraFalha
  Cenario: Compra de mais de 10 unidades de produto
    E seleciono 11 unidades
    E adiciono ao carrinho
    E vou para a pagina de chekout
    Entao sao adicionados 10 unidades
