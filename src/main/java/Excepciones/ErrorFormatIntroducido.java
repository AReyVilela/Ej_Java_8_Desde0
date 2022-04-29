package Excepciones;

public class ErrorFormatIntroducido extends Exception{
    public ErrorFormatIntroducido(int opcion) {
        super("Tiene que ser un numero " + opcion);
    }
}
