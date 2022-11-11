
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
         if (fila1 != null && fila2 != null && fila3 != null){
         System.out.println(fila.getId() + "no se puede añadir en " + nombre);}
         else
          if (fila1 == null){
              fila1 = fila;}
          else if (fila1 != null && fila2 == null){
              fila2 = fila;}
          else if (fila1 != null && fila2 != null && fila3 == null){
              fila3 = fila;}
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        if (getNumeroFilas()== 0){
            fila1 = new Fila(id,fecha,ingresos,gastos);}
            else if (getNumeroFilas()== 1){
            fila2 = new Fila(id,fecha,ingresos,gastos);}
            else if (getNumeroFilas()== 2){
            fila3 = new Fila(id,fecha,ingresos,gastos);}
            else if (getNumeroFilas()== 3){
            System.out.println("Fila4 no se puede añadir en " + nombre);} 
        }
            
            
    

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        return fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        return fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        return fila1.getBeneficio() + fila2.getBeneficio() + fila3.getBeneficio();
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
         String strResul;
             strResul = nombre + "\n" + "                       " + "FECHA" +
             "       " + "INGRESOS" + "         " + "GASTOS" + "      " + "BENEFICIO"
             + "   " + "\n" + fila1.toString() + "\n" + fila2.toString() + 
             "\n" + fila3.toString() + "\n" + "--------------------------------------------------------------------------"
              + "\n" + "                             " + getTotalIngresos() + "€" +
             "      " + getTotalGastos() + "€" + "      " + getBeneficio() + 
             "€" + "   ";
         System.out.println(strResul);
         return strResul;
        
        
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        new HojaCalculo(this.nombre);
        nombre = "Duplicada " + nombre;
        System.out.println(this);
        return this;
    }

   
}
