package CONTROLADOR;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PrimosServlet")
public class PrimosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos los parámetros del rango inical que nosotros damos
        int inicio = Integer.parseInt(request.getParameter("inicio"));
        int fin = Integer.parseInt(request.getParameter("final"));

        // Calcular los números primos en el rango dado

        List<Integer> primos = new ArrayList<>();
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                primos.add(i);
            }
        }

        // Cuenta los números primos que haiga encontrado

        int cantidadPrimos = primos.size();

        // Envía los datos al JSP llamado resultado

        request.setAttribute("primos", primos);
        request.setAttribute("cantidadPrimos", cantidadPrimos);
        request.setAttribute("inicio", inicio);
        request.setAttribute("fin", fin);
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
    //es el comentario de la linea 56:
    // Esta línea define un método llamado 'esPrimo', que recibe un entero 'numero' como parámetro y devuelve un valor booleano (true o false).
    // El propósito de este método es determinar si el número es primo o no.

    //  comentario de la lina 57: Si el número es menor que 2, se retorna 'false', ya que por definición los números primos son mayores o iguales a 2.

    //coemntario de la linea 58:
    // Un bucle for que comienza con i = 2 y va hasta la raíz cuadrada del número.
    // Se utiliza la raíz cuadrada porque si el número tiene un divisor mayor que su raíz cuadrada, debe tener uno menor, por lo que no es necesario revisar más allá de la raíz cuadrada.

    // Comentarrio de la linea 60 :Si el número es divisible entre 'i' (es decir, el residuo de la división de 'numero' entre 'i' es 0), significa que el número no es primo y se retorna 'false'.
    // Esto se debe a que un número primo solo tiene divisores 1 y él mismo, y si es divisible por otro número, no es primo.

    // Comenatario de la linea 67: Si el ciclo for no encuentra ningún divisor (lo que significa que el número no es divisible por ningún número entre 2 y su raíz cuadrada),
    // entonces se retorna 'true', indicando que el número es primo.

    private boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {

            if (numero % i == 0) return false;

        }

        return true;

    }

}


