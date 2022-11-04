
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
     * 
     * @param String : Nombre de la hoja
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
     * 
     * @param String : Nombre de la hoja
     * @param Fila : Fila1
     * @param Fila : Fila2
     * @param Fila : Fila3
     * 
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
     * 
     * @return String : Nombre de la hoja
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Devuelve atributo fila2
     * 
     * @return Fila
     */
    public Fila getFila1()
    {
        return fila1;
    }

    /**
     * Devuelve atributo fila2
     * 
     * @return Fila
     */
    public Fila getFila2()
    {
        return fila2;
    }

    /**
     * Devuelve atributo fila3
     * 
     * @return Fila
     */
    public Fila getFila3()
    {
        return fila3;
    }

    /**
     * Número de filas en la hoja que no están a null
     * 
     * @return int
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
     * Verifica si la hoja está completa o no
     * 
     * @return boolean
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
     * 
     * @param Fila : Fila para añadir
     * 
     */
    public void addFila(Fila fila)
    {
        Fila[] filasArray = { this.fila1, this.fila2, this.fila3 };
        int i = 0;
        
        if(!this.hojaCompleta())
        {
            for(;i < filasArray.length; i++)
            {
                if(filasArray[i] == null)
                {
                    break;
                }
            }
            
            switch(i)
            {
                case 0:
                    this.fila1 = fila;
                    break;
                case 1:
                    this.fila2 = fila;
                    break;
                case 2:
                    this.fila3 = fila;
                    break;
            }
        }
        else
        {
            System.out.println(fila.getId() + " no se puede añadir a " + this.nombre);
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     * 
     * @param String id
     * @param Fecha fecha
     * @param double ingresos
     * @param double gastos
     * 
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos)
    {
        this.addFila(new Fila(id, fecha, ingresos, gastos));
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     * 
     * @return double
     * 
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
     * 
     * @return double
     * 
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
     * 
     * @return double
     * 
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
     * 
     * @return String
     * 
     */
    @Override
    public String toString()
    {
        // Formateo de filas
        Fila[] filasArray = { this.fila1, this.fila2, this.fila3 };
        String columaFecha = String.format("%23s", "FECHA");
        String columnaIngresos = String.format("%16s", "INGRESOS");
        String columnaGastos = String.format("%16s", "GASTOS");
        String columnaBeneficio = String.format("%16s", "BENEFICIO");
        String lineaSeparador = "----------------------------------------------------------------------------\n";
        String totalIngresos = String.format("%38.2f€", this.getTotalIngresos());
        String totalGastos = String.format("%15.2f€", this.getTotalGastos());
        String totalBeneficio = String.format("%15.2f€", this.getBeneficio());
        String finalString = "\n" + this.nombre + "\n" + columaFecha + columnaIngresos + columnaGastos + columnaBeneficio + "\n";
        
        // Unión de cadenas de texto
        for(int i = 0; i < filasArray.length; i++)
        {
            if(filasArray[i] != null)
            {
                finalString += filasArray[i].toString() + "\n";
            }
        }
        
        // Añadir asteriscos si es negativo o positivo
        String add = "";
        if(this.getBeneficio() < 0.0)
        {
            add += "  **";
        }
        
        return finalString + lineaSeparador + totalIngresos + totalGastos + totalBeneficio + add;
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     * 
     * @return HojaCalculo
     */
    public HojaCalculo duplicarHoja()
    {
       return new HojaCalculo("Dupliacada " + this.nombre, this.fila1, this.fila2, this.fila3);
    }

   
}
