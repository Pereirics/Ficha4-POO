package Main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FBFeed {

    // Variáveis de instância
    private List<FBPost> posts;

    // Construtor por omissão
    public FBFeed() {
        this.posts = new ArrayList<FBPost>();
    }

    // Construtor parametrizado
    public FBFeed(List<FBPost> posts) {
        this.posts = posts;
    }

    // Construtor cópia
    public FBFeed(FBFeed f) {
        this.posts = f.getPosts();
    }

    public List<FBPost> getPosts() {
        return this.posts;
    }

    public void setPosts(List<FBPost> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        FBFeed fbFeed = (FBFeed) o;
        return Objects.equals(this.getPosts(), fbFeed.getPosts());
    }

    @Override
    public String toString() {
        return "FBFeed{" +
                "posts=" + this.posts +
                '}';
    }

    public FBFeed clone() {
        return new FBFeed(this);
    }

    public int nrPosts(String user) {
        int cont = 0;
        for (FBPost post: this.posts) {
            if (post.getUtilizador().equals(user)) cont++;
        }
        return cont;
    }

    public List<FBPost> postsOf(String user) {
        List<FBPost> res = new ArrayList<>();
        for (FBPost post: this.posts) {
            if (post.getUtilizador().equals(user)) {
                res.add(post);
            }
        }
        return res;
    }

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim) {
        List<FBPost> res = new ArrayList<>();
        for (FBPost post: this.posts) {
            if (post.getUtilizador().equals(user) && post.getDataPub().isAfter(inicio) && post.getDataPub().isBefore(fim)) {
                res.add(post);
            }
        }
        return res;
    }

    public FBPost getPost(int id) {
        for (FBPost post: this.posts) {
            if (post.getId() == id) return post;
        }
        return new FBPost();
    }

    public void comment(FBPost post, String comentario) {
        for (FBPost post1: this.posts) {
            if (post1.equals(post))  {
                List<String> novo;
                novo = post1.getComentarios();
                novo.add(comentario);
                post1.setComentarios(novo);
            }
        }
    }

    public void like(FBPost post) {
        for (FBPost fbPost: this.posts) {
            if (fbPost.equals(post)) {
                int numLikes = fbPost.getnLikes();
                fbPost.setnLikes(numLikes + 1);
            }
        }
    }

    public void like(int postId) {
        for (FBPost fbPost: this.posts) {
            if (fbPost.getId() == postId) {
                int numLikes = fbPost.getnLikes();
                fbPost.setnLikes(numLikes + 1);
            }
        }
    }

    public List<Integer> top5Comments() { // Dá muito trabalho
        return new ArrayList<>();
    }
}
