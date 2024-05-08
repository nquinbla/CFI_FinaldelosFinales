package A_CuentaUsuario;

import java.time.LocalDate;

public class Tweet {
    protected String message;
    protected LocalDate time;
    protected Cuenta_Usuario sender;

    public Tweet(String message, LocalDate time, Cuenta_Usuario sender) {
        if (message.length() > 140) {
            throw new IllegalArgumentException("Message is too long");
        }
        this.message = message;
        this.time = time;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "message='" + message + '\'' +
                ", time=" + time +
                ", sender=" + sender +
                '}';
    }
}



