
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author - Kaiet Jimenez Aldasoro
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
        int filas =0;
        if (fila1 != null){
            filas++;
        }
        if(fila2 != null){
            filas++;
        }
        if(fila3 != null){
            filas++;
        }
        return filas;
        //variable local que  cuenta las filas.
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {

        if(getNumeroFilas()== 3){
            return true;
        }
        else{
            return false;
        }
        //llamo al metodo getNumeroFilas y si me devuelve 3 filas, sera true, si no false

    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(hojaCompleta() == true){
            System.out.println("Fila "+ (getNumeroFilas()+1) +" no se puede a�adir en " + getNombre());
        
        }
         else if(fila1 == null){
            fila1 = fila;
        
        }
        else if(fila2 == null){
            fila2 = fila;
        }
         else if(fila3 == null){
            fila3 = fila;
        }
        // llamando al anterior metodo si da true(si la hoja esta completa), quiero que me responda que no se puede anadir, si no, que las filas se vayan anadiendo.
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila nueva = new Fila(id,fecha,ingresos,gastos);
        addFila(nueva);
        
        //declaro una variable Fila con nombre nueva, que creara un nuevo objeto Fila con los parametros del segundo constructor de la clase fila. Para anadirla aprovecharemos el anterior metodo para anadir la fila que yo la he llamado nueva.
        }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double sumas = 0;
        if(fila1 != null ){
             sumas += fila1.getIngresos();
        }
         if(fila2 != null){
            sumas += fila2.getIngresos();
        }
        if(fila3 != null){
            sumas += fila3.getIngresos();
        }
        return sumas;
        
        //declaro una variable local y lo utilizo como almacenador de los ingresos.
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
          double sumas = 0;
        if(fila1 != null ){
             sumas += fila1.getGastos();
        }
         if(fila2 != null){
            sumas += fila2.getGastos();
        }
        if(fila3 != null){
            sumas += fila3.getGastos() ;
        }
        return sumas;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getTotalBeneficio() {
          double sumas = 0;
        if(fila1 != null ){
             sumas += fila1.getBeneficio();
        }
         if(fila2 != null){
            sumas += fila2.getBeneficio();
        }
        if(fila3 != null){
            sumas += fila3.getBeneficio();
        }
        return sumas;

    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String fila = "";
       
           
        String nombre = "\n"+ "\n"+ getNombre() + "\n";
        String titulo = String.format("\n %23s %16s %16s %16s ","FECHA","INGRESOS","GASTOS","BENEFICIO");
        
        if(fila1 != null){
            fila += "\n"+fila1.toString() ;
        }
      
        if(fila2 != null ){
            fila += "\n"+fila2.toString();
        }
    
        if(fila3 != null ){
            fila += "\n"+fila3.toString();
        }
         String barritas = String.format("\n"+"------------------------------------------------------------------------------------------");
         String totales = String.format("\n"+"%40.2f� %15.2f� %15.2f�",getTotalIngresos(),getTotalGastos(),getTotalBeneficio());
        return nombre + titulo + fila + barritas + totales;
        
        //Para el nombre de la hoja declaro una variable llamado nombre, que nos dara a traves del getNombre() el nombre de la hoja.
        //Para los nombres, declaro una variable local llamado titulo, donde nos imprimira los nombres FECHA,INGRESOS,GASTOS,BENEFICIOS.
        // Si fila1 NO esta vacia(null) quiero que a traves de una variable local se me almacene el string.format de la fila1, donde haremos una llamada externa al to string de la clase Fila. Asi con las tres filas,
        //Variable local para las --
        //Variable loccal para los totales
        //que nos devuelva la suma de todo
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {

       HojaCalculo nuevo = new HojaCalculo("Duplicada" + getNombre());
       if (fila1 != null){
        nuevo.addFila(fila1.duplicar());
        }
       if (fila2 != null){
        nuevo.addFila(fila2.duplicar());
        }
       if (fila3 != null){
        nuevo.addFila(fila3.duplicar());
        }
       return nuevo;
            
        // variable local de una hojaCalculo donde la llamo nuevo, crea un objeto que nos devolvera el nombre de la hoja + letras indicando que es duplicada.
        //si las filas NO son null nos  anadiremos y duplicaremos las hojas,llamando a metodos.
        
    }
}
