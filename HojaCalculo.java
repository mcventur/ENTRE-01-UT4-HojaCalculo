
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author Khrystyna Polishchuk   
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
        this.fila1 = null;
        this.fila1 = null;
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
     * Devuelve el nÂº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int numeroFilas = 0; 
        if(getFila1() != null){
            numeroFilas++;
        }
        if(getFila2() != null){
            numeroFilas++;
        }
        if(getFila3() != null){
            numeroFilas++;
        }
        return numeroFilas; 
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if(getNumeroFilas() == 3){
            return true;
        }
        else{
            return false; 
        }
    }

    /**
     * Se aÃ±ade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
         if(hojaCompleta()){
             System.out.println("FilaX no se puede añadir en HOJAX");
         }
         else if(getFila1() == null){
             this.fila1 = fila;
         }
         else if(getFila1() != null && getFila2() == null){
             this.fila2 = fila;
         }
         else {
             this.fila3 = fila; 
         }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila filaY = new Fila(id, fecha, ingresos, gastos); 
        addFila(filaY);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos = 0;
        if(getFila1()!=null){
            totalIngresos += fila1.getIngresos();
        }
        if(getFila2()!=null){
            totalIngresos += fila2.getIngresos();
        }
        if(getFila3()!=null){
            totalIngresos += fila3.getIngresos();
        }
        return totalIngresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos = 0; 
        if(getFila1()!=null){
            totalGastos += fila1.getGastos();
        }
        if(getFila2()!=null){
            totalGastos += fila2.getGastos();
        }
        if(getFila3()!=null){
            totalGastos += fila3.getGastos();
        }
        return totalGastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double totalBeneficio; 
        totalBeneficio = getTotalIngresos() - getTotalGastos();
        return totalBeneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String str = "";
        str = "\n" + nombre + "\n";
        str += String.format("%23s%16s%16s%16s", "Fecha", "Ingresos", "Gastos", "Beneficios");
        if(getFila1()!=null){
            str+="\n"+fila1.toString();
        }
        if(getFila2()!=null){
            str+="\n"+fila2.toString();
        }
        if(getFila3()!=null){
            str+="\n"+fila3.toString();
        }
        str += "\n--------------------------------------------------------------------------------";
        str += String.format("\n %37.2f€%15.2f€%15.2f€", getTotalIngresos(), getTotalGastos(), getBeneficio());
        System.out.print(str);
        return str;
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
       HojaCalculo Duplicada_HojaX = new HojaCalculo(nombre);
       return Duplicada_HojaX;
    }
   
}
