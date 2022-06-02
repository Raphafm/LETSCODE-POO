package org.example.Model;

public abstract class User {
    protected String nome;
    protected final String login;
    protected final String senha;
    protected final String identificador;

    public User(String nome, String login, String senha, String identificador) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getIdentificador() {
        return identificador;
    }

    public boolean autenticarLogin(String login, String senha){
        return this.login.equals(login) && this.senha.equals(senha);
    }

    //Realizar um metodo para autenticar o identificador ao criar a conta.
    //e na criação identificar pelo cpf ou cnpj pra ser new cliente ou new corretora
}
