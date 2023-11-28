package TPI.Controller;

import TPI.Model.Cliente;
import TPI.Model.Tecnico;
import TPI.Repository.PersonaRepository;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class PersonaController {
    private PersonaRepository pr;

    public PersonaRepository getPr() {
        return pr;
    }

    public void setPr(PersonaRepository pr) {
        this.pr = pr;
    }

    public PersonaController() {
        this.pr = new PersonaRepository();
    }

    public void agregarCliente(Scanner scanner) {
        System.out.print("INGRESE EL NOMBRE DEL CLIENTE: ");
        String nombreCliente = scanner.next();

        Cliente cliente = new Cliente();
        cliente.setNombre(nombreCliente);


        pr.getEm().getTransaction().begin();
        pr.insertar(cliente);
        pr.getEm().getTransaction().commit();

        System.out.println("CLIENTE REGISTRADO CON ÉXITO.\n");
    }

    public void agregarTecnico(Scanner scanner) {
        System.out.print("INGRESE EL NOMBRE DEL TÉCNICO: ");
        String nombre = scanner.next();

        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);

        pr.getEm().getTransaction().begin();
        pr.insertar(tecnico);
        pr.getEm().getTransaction().commit();

        System.out.println("TÉCNICO REGISTRADO CON ÉXITO.\n");
    }

    public void mostrarClientes() {
        System.out.println("CLIENTES:");
        pr.buscarClientes().forEach(
                cliente -> System.out.println(cliente));
        System.out.println();
    }

    public Cliente buscarClienteId(long nroCliente) {
        Cliente cliente = pr.buscarUno(nroCliente);
        if(cliente!=null) {
            System.out.println(cliente);
        }else{
            System.out.println("CLIENTE NO VÁLIDO.");
        }
        return cliente;
    }

    public void mostrarTecnicos() {
        System.out.println("TECNICOS:");
        pr.buscarTecnicos().forEach(
                tecnico -> System.out.println(tecnico));
        System.out.println();
    }

    public Tecnico buscarTecnicoId(long nroTecnico) {
        Tecnico tecnico = pr.buscarUnT(nroTecnico);
        if(tecnico!=null) {
            System.out.println(tecnico);
        }else{
            System.out.println("TÉCNICO NO VÁLIDO.");
        }
        return tecnico;
    }
}
