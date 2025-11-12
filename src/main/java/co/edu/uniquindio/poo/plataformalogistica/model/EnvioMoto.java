package co.edu.uniquindio.poo.plataformalogistica.model;

public class EnvioMoto implements EnviarEnvio {
    @Override
    public void enviar() {
        System.out.println("Envío en curso (REPARTIDOR MOTORIZADO)");
    }
}

