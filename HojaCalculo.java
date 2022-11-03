
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author - Adrian Vera
 * @version - 0.0.1
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)
    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;

    }
    
    /**
     * Constructor sobrecargado para duplicar la hoja de cálculo
     */
    public HojaCalculo(String nombre, Fila fila1, Fila fila2, Fila fila3)
    {
        this.nombre = nombre;
        this.fila1 = fila1;
        this.fila2 = fila2;
        this.fila3 = fila3;
    }

    /**
     * Accesor para el nombre de la hoja
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Accesor para la fila1
     */
    public Fila getFila1()
    {
        return fila1;
    }

    /**
     * Accesor para la fila2
     */
    public Fila getFila2()
    {
        return fila2;
    }

    /**
     * Accesor para la fila3
     */
    public Fila getFila3()
    {
        return fila3;
    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas()
    {
        Fila[] filasArray = { this.fila1, this.fila2, this.fila3 };
        int contador = 0;
        
        for(int i = 0; i < filasArray.length; i++)
        {
            if(filasArray[i] != null)
            {
                contador++;
            }
        }
        
        return contador;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta()
    {   
        return this.getNumeroFilas() == 3;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila)
    {
        
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos)
    {
        
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos()
    {
        Fila[] filasArray = { this.fila1, this.fila2, this.fila3 };
        double totalIngresos = 0.0;
        
        for(int i = 0; i < filasArray.length; i++)
        {
            if(filasArray[i] != null)
            {
                totalIngresos += filasArray[i].getIngresos();
            }
        }
        
        return totalIngresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos()
    {
        Fila[] filasArray = { this.fila1, this.fila2, this.fila3 };
        double totalGastos = 0.0;
        
        for(int i = 0; i < filasArray.length; i++)
        {
            if(filasArray[i] != null)
            {
                totalGastos += filasArray[i].getGastos();
            }
        }
        
        return totalGastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio()
    {
        Fila[] filasArray = { this.fila1, this.fila2, this.fila3 };
        double totalBeneficio = 0.0;
        
        for(int i = 0; i < filasArray.length; i++)
        {
            if(filasArray[i] != null)
            {
                totalBeneficio += filasArray[i].getBeneficio();
            }
        }
        
        return totalBeneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString()
    {
        return null;
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja()
    {
       return new HojaCalculo("Dupliacada " + this.nombre, this.fila1, this.fila2, this.fila3);
    }

   
}
