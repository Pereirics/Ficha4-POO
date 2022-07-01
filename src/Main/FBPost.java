package Main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FBPost {

    // Variáveis de instância
    private int id;
    private String utilizador;
    private LocalDateTime dataPub;
    private String conteudo;
    private int nLikes;
    private List<String> comentarios;

    // Construtor por omissão
    public FBPost() {
        this.id = 0;
        this.utilizador = "";
        this.dataPub = LocalDateTime.now();
        this.conteudo = "";
        this.nLikes = 0;
        this.comentarios = new ArrayList<>();
    }

    // Construtor parametrizado
    public FBPost(int id, String utilizador, LocalDateTime dataPub, String conteudo, int nLikes, List<String> comentarios) {
        this.id = id;
        this.utilizador = utilizador;
        this.dataPub = dataPub;
        this.conteudo = conteudo;
        this.nLikes = nLikes;
        this.comentarios = comentarios;
    }

    // Construtor cópia
    public FBPost(FBPost f) {
        this.id = f.getId();
        this.utilizador = f.getUtilizador();
        this.dataPub = f.getDataPub();
        this.conteudo = f.getConteudo();
        this.nLikes = f.getnLikes();
        this.comentarios = f.getComentarios();
    }

    // Métodos de instância
    public int getId() {
        return this.id;
    }

    public String getUtilizador() {
        return this.utilizador;
    }

    public LocalDateTime getDataPub() {
        return this.dataPub;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public int getnLikes() {
        return this.nLikes;
    }

    public List<String> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setDataPub(LocalDateTime dataPub) {
        this.dataPub = dataPub;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setnLikes(int nLikes) {
        this.nLikes = nLikes;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        FBPost f = (FBPost) o;
        return (this.id == f.getId() && Objects.equals(this.utilizador, f.getUtilizador())
                && this.dataPub == f.getDataPub()
                && Objects.equals(this.conteudo, f.getConteudo())
                && this.nLikes == f.getnLikes()
                && Objects.equals(this.comentarios, f.getComentarios())
                );
    }

    public String toString() {
        return "FBPost{" +
                ", Id: " + this.id +
                ", Utilizador: " + this.utilizador +
                ", Data Publicação: " + this.dataPub +
                ", Conteúdo: " + this.conteudo +
                ", Número Likes: " + this.nLikes +
                ", Comentários: " + this.comentarios +
                "}";
    }

    public FBPost clone() {
        return new FBPost(this);
    }
}
