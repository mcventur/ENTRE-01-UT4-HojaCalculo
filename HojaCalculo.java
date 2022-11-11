
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author - Ander Vegas
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
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int numeroFilas = 0;
        
        if(fila1 != null)
        {
            numeroFilas++;
        }
        if(fila2 != null)
        {
            numeroFilas++;
        }
        if(fila3 != null)
        {
            numeroFilas++;
        }
        
        return numeroFilas;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        
        boolean estaCompleta = false;
        
        if(getNumeroFilas() == 3)
        {
            estaCompleta = true;
            
        }else{
            estaCompleta = false;
        }
        
        return estaCompleta;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        
        if (this.fila1 == null)
        {
           this.fila1 = fila; 
        }
        else if (this.fila2 == null)
        {
           this.fila2 = fila;
        }
        else if (this.fila3 == null)
        {
           this.fila3 = fila;
        }
        else
        {
            System.out.println(fila.getId() + " no se puede añadir en " + this.nombre);
            System.out.println();
        }
    
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
         
        Fila nuevaFila = new Fila(id,fecha,ingresos,gastos);
        this.addFila(nuevaFila);

    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
         
        double TotalIngresos = 0;
        
        Fila Filas[] = {this.fila1 ,this.fila2 , this.fila3 };
        
        
         for(int i = 0; i < Filas.length; i++)
        {
            if(Filas[i] != null)
            {
                TotalIngresos += Filas[i].getIngresos();
            }
        }

        return TotalIngresos;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
         
        double TotalGastos = 0;
        
        Fila Filas[] = {this.fila1 ,this.fila2 , this.fila3 };
        
        
         for(int i = 0; i < Filas.length; i++)
        {
            if(Filas[i] != null)
            {
                TotalGastos += Filas[i].getGastos();
            }
        }

        return TotalGastos;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
         
        double Beneficios = 0;
        
        Fila Filas[] = {this.fila1 ,this.fila2 , this.fila3 };
        
        
         for(int i = 0; i < Filas.length; i++)
        {
            if(Filas[i] != null)
            {
                Beneficios += Filas[i].getBeneficio();
            }
        }

        return Beneficios;

    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String retorno="";
        
        if(this.getBeneficio() < 0.0)
        {
            retorno += "  **";
        }
        
        String filaFecha = String.format("%23s","FECHA");
        String filaIngresos = String.format("%16s","INGRESOS");
        String filaGastos = String.format("%16s","GASTOS");
        String filaBeneficios = String.format("%16s","BENEFICIO");
        String linea = String.format("-----------------------------------------------------------------------" + "\n");
        String filaTotalIngresos = String.format("%38.2f€",this.getTotalIngresos());
        String filaTotalGastos = String.format("%15.2f€",this.getTotalGastos());
        String filaTotalBeneficios = String.format("%15.2f€",this.getBeneficio());
        
        String columnas = this.nombre + "\n" + filaFecha + filaIngresos +
        filaGastos + filaBeneficios + "\n";
        
        String NumeroFilas = "";
        if(this.fila1 != null)
        {
           NumeroFilas += this.fila1.toString() + "\n";
        }
        if(this.fila2 != null)
        {
           NumeroFilas += this.fila2.toString() + "\n";
        }
        if(this.fila3 != null)
        {
           NumeroFilas += this.fila3.toString() + "\n";
        }
        
        
        return columnas + NumeroFilas + linea + filaTotalIngresos + filaTotalGastos
        + filaTotalBeneficios;

    }
    
    public void imprime(){
        System.out.println(toString());
        
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
       
       HojaCalculo duplicarHoja = new HojaCalculo("\n" + "Duplicada " + getNombre());
       if (this.fila1 != null)
       {
           duplicarHoja.addFila(fila1) ;
       }
       if (this.fila2 != null)
       {
           duplicarHoja.addFila(fila2) ;
       }
       if (this.fila3 != null)
       {
           duplicarHoja.addFila(fila3) ;
       }
        return duplicarHoja;

    }

   
}
