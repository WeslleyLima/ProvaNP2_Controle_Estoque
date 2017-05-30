public class Produto {

    private String nome;
    private String fabricante;
    private int codigo;
    private int quantidade;
    private double precoVenda;
    private double custo;
    private Date dataEntradaEstoque;
    private Date dataVenda;

    public Produto(){

    }

//    public Produto(String nome, String fabricante, int codigo, int quantidade, double precoVenda, double custo, Date dataEntradaEstoque, Date dataVenda) {
//        this.nome = nome;
//        this.fabricante = fabricante;
//        this.codigo = codigo;
//        this.quantidade = quantidade;
//        this.precoVenda = precoVenda;
//        this.custo = custo;
//        this.dataEntradaEstoque = dataEntradaEstoque;
//        this.dataVenda = dataVenda;
//    }


    public Produto(String nome, String fabricante, int codigo, int quantidade, double precoVenda, double custo, Date dataEntradaEstoque) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.custo = custo;
        this.dataEntradaEstoque = dataEntradaEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Date getDataEntradaEstoque() {
        return dataEntradaEstoque;
    }

    public void setDataEntradaEstoque(Date dataEntradaEstoque) {
        this.dataEntradaEstoque = dataEntradaEstoque;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return String.format(
                "Nome: [%s], Fabricante: [%s], Quantidade: [%d], Custo: [R$ %.2f], Preço Venda: [R$ %.2f] Código: [%d]",
                nome, fabricante, quantidade, custo, precoVenda, codigo);

//        "Nome: [%s], Fabricante: [%s], Quantidade: [%d], Custo: [%.2f], Preço Venda: [%.2f], Código: [%d]",
//                nome, fabricante, quantidade, custo, precoVenda, codigo);
    }
}
