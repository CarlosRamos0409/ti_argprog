package TPI.Controller;

import TPI.Model.Cliente;
import TPI.Model.Especialidad;
import TPI.Model.Incidente;
import TPI.Model.Tecnico;
import TPI.Repository.EspecialidadRepository;
import TPI.Repository.IncidenteRepository;

import java.util.Scanner;

public class EspecialidadController {

    private EspecialidadRepository ir;

    public EspecialidadRepository getIr() {
        return ir;
    }

    public void setIr(EspecialidadRepository er) {
        this.ir = ir;
    }

    public EspecialidadController() {
        this.ir = new EspecialidadRepository();
    }

    public void agregarEspecialidad(Scanner scanner) {

        System.out.print("INGRESE LA ESPECIALIDAD: ");
        String nombre = scanner.next();

        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(nombre);

        ir.getEm().getTransaction().begin();
        ir.insertar(especialidad);
        ir.getEm().getTransaction().commit();

        System.out.println("ESPECIALIDAD REGISTRADA CON ÉXITO.\n");

    }

    public void mostrarEspecialidad() {
        System.out.println("ESPECIALIDADES:");
        ir.buscar().forEach(
                especialidad -> System.out.println(especialidad));
        System.out.println();
    }
}
