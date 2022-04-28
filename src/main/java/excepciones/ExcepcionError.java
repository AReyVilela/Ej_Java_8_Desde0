package excepciones;

public class ExcepcionError extends Exception {
    public ExcepcionError(int id) {


        super("NO existe el id " + id);

    }
}
