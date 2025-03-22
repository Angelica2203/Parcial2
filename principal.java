import java.util.Stack;
import javax.swing.JOptionPane;

public class principal 
//Angelica Gaona
//Juan Felipe Puerta Bedoya
{
     public int Menu()
    {
        String input;
        int vrUsu = 0; 
        boolean validInput = false;
        do 
        {
            input = JOptionPane.showInputDialog("---------- MENU ----------\n" +
                                                "1.Registrar Credito\n" +
                                                "2.Actualizar Credito\n" +
                                                "3.VenderCredito\n" +
                                                "4.Eliminar Credito\n" +
                                                "5.Salir\n");
            if (input != null && input.matches("\\d+")) 
            {
                vrUsu = Integer.parseInt(input);
                if (vrUsu >= 1 && vrUsu <= 5) 
                {
                    validInput = true;
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Opción no válida, reintente por favor");
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }

        } while (!validInput);

        return vrUsu;
    }
    public static void main(String[] args) 
    {
        Stack<credito> pila = new Stack<>();
        int opc;
        do 
        {
            metodos met = new metodos();
            principal m = new principal();
            opc = m.Menu();
            switch (opc) 
            {
                case 1:
                    pila = met.RegistrarCredito(pila);
                    break;
                case 2:
                    met.ActualizarCredito(pila);
                    break;
                case 3:
                    met.VenderCredito(pila);
                    break;
                case 4:
                    met.EliminarCredito(pila);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El programa ha terminado");
                    break;
            }
            
        } while (opc != 5);
    }
}
