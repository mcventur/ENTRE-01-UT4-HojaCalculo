
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -  DAvid Andueza Ferro 
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
        int numero = 0;
        if(fila1 != null){
            numero ++;
        }  
        if(fila2 != null){
            numero ++;
        }  
        if(fila3 != null){
            numero ++;
        }  
        return numero;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        return getNumeroFilas() == 3;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        
    if (fila1 == null){
        fila1 = fila; 
    }   
    else if (fila2 == null){
        fila2 = fila;
    }
    else if (fila3 == null){
        fila3 = fila;
    }
    else{
        System.out.println(fila.getId() + " no se puede añadir en " + nombre);

    }
    
    }
    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
         Fila fila = new Fila(id,fecha,ingresos,gastos);
         addFila(fila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
       double resultado = 0;

        if (this.fila1 != null){
           resultado += this.fila1.getIngresos(); 
        }
        if (this.fila2 != null){
           resultado += this.fila2.getIngresos(); 
        }
        if (this.fila3 != null){
           resultado += this.fila3.getIngresos(); 
        }
        return resultado;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double resultado = 0;

        if (this.fila1 != null){
           resultado += this.fila1.getGastos(); 
        }
        if (this.fila2 != null){
           resultado += this.fila2.getGastos(); 
        }
        if (this.fila3 != null){
           resultado += this.fila3.getGastos(); 
        }
        return resultado;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double resultado = 0;

        if (this.fila1 != null){
           resultado += this.fila1.getBeneficio(); 
        }
        if (this.fila2 != null){
           resultado += this.fila2.getBeneficio(); 
        }
        if (this.fila3 != null){
           resultado += this.fila3.getBeneficio(); 
        }
        return resultado;

    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String guiones = "-";
        String ad = "\n\n"+this.nombre+"\n";
        String cab = String.format("%23s","FECHA") + String.format("%16s","INGRESOS") + String.format("%16s","GASTOS") + String.format("%16s","BENEFICIOS") + "\n";
        String row = "";
        if (this.fila1 != null){row += this.fila1.toString() + "\n";}
        if (this.fila2 != null){row += this.fila2.toString() + "\n";}
        if (this.fila3 != null){row += this.fila3.toString() + "\n";}
        String guion = guiones.repeat(80) + "\n";
        String total = String.format("%38.2f€", getTotalIngresos()) + String.format("%15.2f€", getTotalGastos()) + String.format("%15.2f€", getBeneficio()) + "\n";
        return ad + cab + row + guion + total;
    }
    

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo duplicado = new HojaCalculo("Duplicada " + getNombre());
        duplicado.addFila(this.fila1);
        duplicado.addFila(this.fila2);
        duplicado.addFila(this.fila3);
        return duplicado;
    }

   
}
