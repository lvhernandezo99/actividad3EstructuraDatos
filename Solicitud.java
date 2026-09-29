public class Solicitud {

    private Usuario usuario;
    private String codigoLibro;

    public Solicitud(Usuario usuario, String codigoLibro) {
        this.usuario = usuario;
        this.codigoLibro = codigoLibro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }
}
