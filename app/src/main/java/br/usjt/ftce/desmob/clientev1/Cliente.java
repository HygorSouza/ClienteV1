package br.usjt.ftce.desmob.clientev1;

import java.io.Serializable;

/**
 * Created by Hygor on 08/04/2017.
 */

public class Cliente implements Serializable, Comparable<Cliente> {
    private int id;
    private String nome;
    private String fone;
    private String email;

    public Cliente(int id, String nome, String fone, String email) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagem(){
        String imagem = email.replace('@','_');
        return imagem.replace('.','_');
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fone='" + fone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (id != cliente.id) return false;
        if (nome != null ? !nome.equals(cliente.nome) : cliente.nome != null) return false;
        if (fone != null ? !fone.equals(cliente.fone) : cliente.fone != null) return false;
        return email != null ? email.equals(cliente.email) : cliente.email == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (fone != null ? fone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Cliente outro) {
        return this.nome.compareTo(outro.getNome());
    }

}
