package A_CuentaUsuario;

import java.util.*;

public class Cuenta_Usuario {
    private String alias;
    private String email;
    private List<Cuenta_Usuario> following;
    private List<Tweet> tweets;
    private List<Tweet> timeline;

    public Cuenta_Usuario(String alias, String email) {
        if (!Utils.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (!Utils.isValidAlias(alias)) {
            throw new IllegalArgumentException("Invalid alias");
        }
        this.alias = alias;
        this.email = email;
        this.following = new ArrayList<>();
        this.tweets = new ArrayList<>();
        this.timeline = new ArrayList<>();
    }

    public String getAlias() { return alias; }

    public String getEmail() { return email; }

    public void follow(Cuenta_Usuario user) {
        if (!following.contains(user)) {
            following.add(user);
            user.addFollower(this);
        }
    }

    private void addFollower(Cuenta_Usuario user) {
        this.timeline.addAll(user.tweets);
    }

    public void tweet(Tweet tweet) {
        this.tweets.add(tweet);
        for (Cuenta_Usuario user : following) {
            user.updateTimeline(tweet);
        }
    }

    private void updateTimeline(Tweet tweet) {
        this.timeline.add(tweet);
    }

    @Override
    public String toString() {
        return "Cuenta_Usuario{" +
                "alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
