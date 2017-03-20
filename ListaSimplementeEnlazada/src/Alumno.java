public class Alumno {
    private String codigo;
    private String apellidos;
    private String nombres;
    private int promedio;

    public Alumno(String codigo, String apellidos, String nombres, int promedio) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.promedio = promedio;
    }

    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }
    
    
}
