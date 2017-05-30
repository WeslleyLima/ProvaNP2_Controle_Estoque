public enum Mes {

    JANEIRO(31),
    FEVEREIRO(28),
    MARÇO(31),
    ABRIU(30),
    MAIO(31),
    JUNHO(30),
    JULHO(31),
    AGOSTO(31),
    SETEMBRO(30),
    OUTUBRO(31),
    NOVEMBRO(30),
    DEZEMBRO(31);

    int dias;

    Mes(int dias){
        this.dias = dias;
    }

    public int getDias(){
        return dias;
    }
}
