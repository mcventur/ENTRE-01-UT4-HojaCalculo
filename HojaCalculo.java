
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
        int contador=0;
        if(fila1 != null){
            contador++;
        }
        if(fila2 != null){
            contador++;
        }
        if(fila3 != null){
            contador++;
        }
        return contador;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        int contador=0;
        boolean check =false;
        if(fila1 != null){
            contador++;
        }
        if(fila2 != null){
            contador++;
        }
        if(fila3 != null){
            contador++;
        }
        if(contador==3){
            check = true;
        }
        return check;
        
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(fila1 == null){
            fila1 = fila;
        }
        else if(fila2 == null){
            fila2 = fila;
        }
        else if(fila3 == null){
            fila3 = fila;
        }
        else{
            System.out.println(fila.getId() +" no se puede a�adir en " + nombre);
        }

    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila filaCreada = new Fila(id,fecha,ingresos,gastos);
        addFila(filaCreada);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos= 0;
        
        if(fila1 == null && fila2 == null && fila3 == null){
            totalIngresos = 0;
        }
        else if(fila2 == null){
            totalIngresos = fila1.getIngresos() + totalIngresos;
        }
        else if(fila3 == null){
            totalIngresos = fila1.getIngresos() + fila2.getIngresos() +totalIngresos;
        }
        else{
            totalIngresos = fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos() +totalIngresos;
        }
        return totalIngresos;

    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos= 0;
        
        if(fila1 == null && fila2 == null && fila3 == null){
            totalGastos = 0;
        }
        else if(fila2 == null){
            totalGastos = fila1.getGastos() + totalGastos;
        }
        else if(fila3 == null){
            totalGastos = fila1.getGastos() + fila2.getGastos() +totalGastos;
        }
        else{
            totalGastos = fila1.getGastos() + fila2.getGastos() + fila3.getGastos() +totalGastos;
        }
        return totalGastos;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getTotalBeneficio() {
        double totalBeneficio= 0;
        
        if(fila1 == null && fila2 == null && fila3 == null){
            totalBeneficio = 0;
        }
        else if(fila2 == null){
            totalBeneficio = fila1.getBeneficio() + totalBeneficio;
        }
        else if(fila3 == null){
            totalBeneficio = fila1.getBeneficio() + fila2.getBeneficio() +totalBeneficio;
        }
        else{
            totalBeneficio = fila1.getBeneficio() + fila2.getBeneficio() + fila3.getBeneficio() +totalBeneficio;
        }
        return totalBeneficio;

    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String filasConcatenadas = "";
        String totales = "";
        if(fila1 != null){
            filasConcatenadas = filasConcatenadas +fila1.toString()+"\n";
        }
        if(fila2 != null){
            filasConcatenadas = filasConcatenadas +fila2.toString()+"\n";
        }
        if(fila3 != null){
            filasConcatenadas = filasConcatenadas +fila3.toString()+"\n";
        }
        String strBeneficios = ""+getTotalBeneficio();
        if(getTotalBeneficio()<0){
            strBeneficios = strBeneficios+"� **";
            totales = String.format("%38.2f�%15.2f�%18s",getTotalIngresos(),getTotalGastos(),strBeneficios);
        }
        else{
            strBeneficios = strBeneficios+"�";
            totales = String.format("%38.2f�%15.2f�%15s",getTotalIngresos(),getTotalGastos(),strBeneficios);
        }
        
        
        String encabezado = String.format("%s%23s%16s%16s%15s",nombre+"\n","FECHA","INGRESOS","GASTOS","BENEFICIO");
        System.out.println(encabezado +"\n"+filasConcatenadas+"----------------------------------------------------------------------------"+"\n"+totales);
        return "";
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
       HojaCalculo duplicacion = new HojaCalculo("Duplicada " + nombre);
       if(fila1 != null){
            duplicacion.addFila(fila1.duplicar());
       }
       if(fila2 != null){
            duplicacion.addFila(fila2.duplicar());
       }
       if(fila3 != null){
            duplicacion.addFila(fila3.duplicar());
       }
       
       return duplicacion;
    }
    
}
