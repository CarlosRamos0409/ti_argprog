package TPI;

import PatronRepository.EmpleadoRepository;
import TPI.Controller.EspecialidadController;
import TPI.Controller.IncidenteController;
import TPI.Controller.PersonaController;
import TPI.Model.Cliente;
import TPI.Model.Especialidad;
import TPI.Repository.IncidenteRepository;
import TPI.Repository.PersonaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class MainTPI {

    public static EntityManager getEntityManager(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(
                                "JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        PersonaController pc = new PersonaController();
        //seteando el entityManager al repository
        pc.getPr().setEm(em);

        IncidenteController ic = new IncidenteController();
        //seteando el entityManager al repository
        ic.getIr().setEm(em);

        EspecialidadController ec = new EspecialidadController();
        //seteando el entityManager al repository
        ec.getIr().setEm(em);

        Scanner scanner = new Scanner(System.in);

        int opcion;
        long nroCliente;
        long nroTecnico;
        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. REGISTRAR CLIENTE");
            System.out.println("2. MOSTRAR CLIENTES");
            System.out.println("3. REGISTRAR TÉCNICO");
            System.out.println("4. MOSTRAR TÉCNICOS");
            System.out.println("5. REGISTRAR ESPECIALIDAD");
            System.out.println("6. MOSTRAR ESPECIALIDADES");
            System.out.println("7. REGISTRAR INCIDENTE");
            System.out.println("0. SALIR");
            System.out.print("INGRESE UNA OPCIÓN: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    pc.agregarCliente(scanner);
                    break;
                case 3:
                    pc.agregarTecnico(scanner);
                    break;
                case 2:
                    pc.mostrarClientes();
                    break;
                case 4:
                    pc.mostrarTecnicos();
                    break;
                case 5:
                    ec.agregarEspecialidad(scanner);
                    break;
                case 6:
                    ec.mostrarEspecialidad();
                    break;
                case 7:
                    pc.mostrarClientes();
                    System.out.println("INGRESE EL NÚMERO DE CLIENTE:");
                    nroCliente = scanner.nextLong();
                    ic.agregarIncidente(
                            pc.buscarClienteId(nroCliente)
                    );
                    break;
                case 0:
                    System.out.println("SALIENDO. ¡HASTA PRONTO!");
                    break;
                default:
                    System.out.println("OPCIÓN INCORRECTA. INTETE NUEVAMENTE.");
            }
        } while (opcion != 0);
    }

}
