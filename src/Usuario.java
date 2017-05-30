public class Usuario {

    private String login;
    private String senha;
    private boolean perfil; // true é adminstrador; false é vendedor


    public Usuario(String login, String senha, boolean perfil) {
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isPerfil() {
        return perfil;
    }

    public void setPerfil(boolean perfil) {
        this.perfil = perfil;
    }


}
