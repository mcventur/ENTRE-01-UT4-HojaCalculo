
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -   
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
        int nFilas = 0;
            if (fila1 == null){
             nFilas = 0;}
             else if (fila1 != null && fila2 == null){
             nFilas = 1;}
             else if (fila2 != null && fila3 == null){
             nFilas = 2;}
            else if (fila3 != null){
             nFilas = 3;}
        return nFilas;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if (fila1 != null && fila2 != null && fila3 != null){
        return true;}
        else{
        return false;}
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
         if (getNumeroFilas() == 3)
         {
         System.out.println(fila.getId() + " no se puede añadir en " + nombre);
         }
         else
              if (getNumeroFilas() == 0)
              {
              fila1 = fila;
              }
              else if (getNumeroFilas() == 1)
              {
              fila2 = fila;
              }
              else if (getNumeroFilas() == 2)
              {
              fila3 = fila;
              }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) 
    {
        addFila(new Fila(id, fecha, ingresos, gastos));
    }
    
    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos = 0;
        if (hojaCompleta() == true)
        {
            totalIngresos = fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
        }
        else 
        if (getNumeroFilas() == 1) 
        {
            totalIngresos = fila1.getIngresos();
        }
        else if (getNumeroFilas() == 2)
        {
            totalIngresos = fila1.getIngresos() + fila2.getIngresos();
        }
        return totalIngresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos = 0;
        if (hojaCompleta() == true)
        {
            totalGastos = fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
        }
        else 
        if (getNumeroFilas() == 1) 
        {
            totalGastos = fila1.getGastos();
        }
        else if (getNumeroFilas() == 2)
        {
            totalGastos = fila1.getGastos() + fila2.getGastos();
        }
        return totalGastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double beneficio = 0;
        if (hojaCompleta() == true)
        {
            beneficio = fila1.getBeneficio() + fila2.getBeneficio() + fila3.getBeneficio();
        }
        else 
        if (getNumeroFilas() == 1) 
        {
            beneficio = fila1.getBeneficio();
        }
        else if (getNumeroFilas() == 2)
        {
            beneficio = fila1.getBeneficio() + fila2.getBeneficio();
        }
        return beneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
       String strResul = "";
        if (hojaCompleta() == true)
       {
         strResul = String.format("%1s \n %15s %9s %8s %10s \n %s \n %s \n %s \n -------------------------------------------- \n %24.2f€ %8.2f€ %8.2f€ \n",nombre,"FECHA","INGRESOS","GASTOS","BENEFICIO",
         fila1.toString() ,fila2.toString(),fila3.toString(),getTotalIngresos(),getTotalGastos(),getBeneficio());
       }
       else if (getNumeroFilas() == 2)
       {
         strResul = String.format("%1s \n %15s %9s %8s %10s \n %s \n %s \n -------------------------------------------- \n %24.2f€ %8.2f€ %8.2f€ \n",nombre,"FECHA","INGRESOS","GASTOS","BENEFICIO",
         fila1.toString() ,fila2.toString(),getTotalIngresos(),getTotalGastos(),getBeneficio());
       }
       else if (getNumeroFilas() == 1)
       {
         strResul = String.format("%1s \n %15s %9s %8s %10s \n %s \n -------------------------------------------- \n %24.2f€ %8.2f€ %8.2f€ \n",nombre,"FECHA","INGRESOS","GASTOS","BENEFICIO",
         fila1.toString(),getTotalIngresos(),getTotalGastos(),getBeneficio());
       }
       return strResul;
    }   

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo hojaDuplicada;
        nombre = "Duplicada " + this.nombre;
        hojaDuplicada = new HojaCalculo(nombre);
        System.out.println(this.toString());
        return hojaDuplicada;
    }

   
}
