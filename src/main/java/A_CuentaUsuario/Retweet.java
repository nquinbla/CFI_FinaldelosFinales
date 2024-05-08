package A_CuentaUsuario;

import java.time.LocalDate;

public class Retweet extends Tweet {
    private Tweet originalTweet;

    public Retweet(String message, LocalDate time, Cuenta_Usuario sender, Tweet originalTweet) {
        super(message, time, sender);
        this.originalTweet = originalTweet;
    }

    @Override
    public String toString() {
        return "Retweet{" +
                "message='" + message + '\'' +
                ", time=" + time +
                ", sender=" + sender +
                ", originalTweet=" + originalTweet +
                '}';
    }
}
