import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

public class metodos 
{
    Scanner sc = new Scanner(System.in);
    public Stack<credito> RegistrarCredito(Stack<credito> pila) 
    {
        credito o = new credito();
        o.setNombre(JOptionPane.showInputDialog("Ingrese el nombre"));

        String entrada;
        entrada = JOptionPane.showInputDialog("Ingrese la cedula");
        while (!entrada.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.");
            entrada = JOptionPane.showInputDialog("Ingrese la cedula (número entero):");
        }
        o.setCedula(Integer.parseInt(entrada));
        
        o.setTipocredito(JOptionPane.showInputDialog("Ingrese el tipo de credito"));
        
        entrada = JOptionPane.showInputDialog("Ingrese el valor del credito");
        while (!entrada.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            entrada = JOptionPane.showInputDialog("Ingrese el valor del credito (número válido):");
        }
        o.setVrcredito(Double.parseDouble(entrada));
        return ValidarPrenda(pila, o);
    }
    public Stack<credito> ValidarPrenda(Stack<credito> pila, credito nuevoCredito) 
    {
        boolean encontrado = false;
        for (credito cred : pila) 
        {
            if ((cred.getCedula() == nuevoCredito.getCedula()) && cred.getTipocredito().equalsIgnoreCase(nuevoCredito.getTipocredito())) 
            {
                cred.setVrcredito(cred.getVrcredito() + nuevoCredito.getVrcredito());
                encontrado = true;
                JOptionPane.showMessageDialog(null, "El credito ya existe, se ha actualizado el valor del credito");
                break;
            }
        }
        if (!encontrado) 
        {
            pila.push(nuevoCredito);
            JOptionPane.showMessageDialog(null, "Credito ingresado correctamente");
        }
        MostrarPila(pila);
        return pila;
    }
    public void MostrarPila(Stack<credito> pila) 
    {
        for (credito o : pila) 
        {
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Cedula: " + o.getCedula());
            System.out.println("Tipo de Credito: " + o.getTipocredito());
            System.out.println("Valor Credito " + o.getVrcredito());
            System.out.println();
        }
    }
    public void ActualizarCredito(Stack<credito> pila) 
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay datos registrados");
            pila = RegistrarCredito(pila);
        }
        System.out.println("Ingrese la cedula para actualizar el credito");
        int ced = sc.nextInt();
        boolean encontrado = false;
        for (credito credito : pila) 
        {
            if (credito.getCedula() == ced) 
            {
                encontrado = true;
                System.out.println("---MODIFICAR--- \n" + "1.Nombre\n" + "2.Tipo Credito\n" + "3.Valor del credito\n");
                int opt = sc.nextInt();
                switch (opt) 
                {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre");
                        credito.setNombre(sc.next());
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo tipo de credito");
                        credito.setTipocredito(sc.next());
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo valor del credito");
                        credito.setVrcredito(sc.nextDouble());
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                System.out.println("CREDITO MODIFICADO\n" +
                                    "Nombre: " + credito.getNombre() + "\n" +
                                    "Cedula: " + credito.getCedula() + "\n" +
                                    "Tipo de credito: " + credito.getTipocredito() + "\n" +
                                    "Valor del credito: " + credito.getVrcredito() + "\n");
                return;
            }
        }
        if (!encontrado) 
        {
            System.out.println("Credito no encontrado");
            return;
        }
    }
    public void EliminarCredito(Stack<credito> pila) 
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay registros ingresados");
            pila = RegistrarCredito(pila);
        }
        System.out.println("Ingrese la cedula del credito a eliminar");
        int ced = sc.nextInt();
        boolean encontrado = false;
        for (credito credito : pila) 
        {
            if (credito.getCedula() == ced) 
            {
                encontrado = true;
                pila.remove(credito);
                System.out.println("CREDITO ELIMINADO");
                MostrarPila(pila);
                return;
            }
        }
        if (!encontrado) 
        {
            System.out.println("Credito no encontrado");
            return;

        }
    }
    public void VenderCredito(Stack<credito> pila)
    {
        JOptionPane.showMessageDialog(null, "INGRESE EL REGISTRO A VENDER");
        RegistrarCredito(pila);
        return;
    }
}
