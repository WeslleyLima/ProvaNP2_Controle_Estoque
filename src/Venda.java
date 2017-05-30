public class Venda extends Produto{


    private String hora;
    private double valor;
    private int codigoVenda;
    private int indexListVendaCount;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getIndexListVendaCount() {
        return indexListVendaCount;
    }

    public void setIndexListVendaCount(int indexListVendaCount) {
        this.indexListVendaCount = indexListVendaCount;
    }

    public void incrementaIndexListVendaCount(){
        indexListVendaCount++;
    }

    @Override
    public String toString() {

        return String.format(
                " Hora: [%s], Valor Venda: [R$ %.2f], Código Venda: [%d]",
                hora, valor, codigoVenda);
    }
}
