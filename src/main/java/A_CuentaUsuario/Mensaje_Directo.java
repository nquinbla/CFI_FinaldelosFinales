package A_CuentaUsuario;

import java.time.LocalDate;

public class Mensaje_Directo extends Tweet {
        private Cuenta_Usuario receiver;

        public Mensaje_Directo(String message, LocalDate time, Cuenta_Usuario sender, Cuenta_Usuario receiver) {
            super(message, time, sender);
            this.receiver = receiver;
        }

        @Override
        public String toString() {
            return "DirectMessage{" +
                    "message='" + message + '\'' +
                    ", time=" + time +
                    ", sender=" + sender +
                    ", receiver=" + receiver +
                    '}';
        }
    }

