public class Date {

    private int mes;
    private int dia;
    private int ano;

    private static final int[] diaPorMes =
            {0, Mes.JANEIRO.dias, Mes.FEVEREIRO.getDias(), Mes.MARÇO.getDias(),
                Mes.ABRIU.getDias(), Mes.MAIO.getDias(), Mes.JUNHO.getDias(),
                Mes.JULHO.getDias(), Mes.AGOSTO.getDias(), Mes.SETEMBRO.getDias(),
                Mes.OUTUBRO.getDias(), Mes.NOVEMBRO.getDias(), Mes.DEZEMBRO.getDias()};


    public Date(){

    }

    public Date(int dia, int mes, int ano) {

        // verifica se mês está no intervalo
        if (mes <= 0 || mes > 12)
            throw new IllegalArgumentException(
                    "mes (" + mes + ") deve está entre 1-12");

        // verifica se dia está no intervalo
        if (dia <= 0 || (dia > diaPorMes[mes] && !(mes == 2) && dia == 29))
            throw new IllegalArgumentException(
                    "Dia (" + dia + ") fora do intervalor para o mes e ano especificado");

        // verifica no ano bissexto se o mês é 2 e o dia é 29
        if (mes == 2 && dia == 29 && !(ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)))
            throw new IllegalArgumentException(
                    "dia (" + dia + ") fora do intervalor para o mês e ano especificado");

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString(){
        return String.format("%d/%d/%d", dia, mes, ano);
    }
}

























