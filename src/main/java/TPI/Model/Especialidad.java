package TPI.Model;

import javax.persistence.*;

@Entity
@Table(name="especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    @ManyToOne(targetEntity = Aplicacion.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Aplicacion aplicacion;

    public Especialidad(String nombre) {
        this.nombre=nombre;
    }

    public Especialidad() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String toString() {
        return this.getId()+"-"+this.getNombre();
    }
}
