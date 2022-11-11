
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de calculo. La hoja tiene hasta un maximo de 3 filas (no mas)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author - Imanol  
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
     * Crea la hoja de cÃ¡lculo con el nombre indicado 
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
     * (dependera de cuantas filas estan a null)
     */
    public int getNumeroFilas() {
        //Comprueba fila a fila si esta vacia. En caso de estarlo, lo resta de las 
        //maximas filas posibles que puede tener la hoja.
        int filasActuales = 3;
        if(getFila1() == null){
            filasActuales--;
        }
        if(getFila2() == null){
            filasActuales--;
        }
        if(getFila3() == null){
            filasActuales--;
        }
        return filasActuales;
    }

    /**
     * Devuelve true si la hoja esta completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        return this.getNumeroFilas() == 3;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja esta completa se muestra el mensaje "FilaX no se puede aÃ±adir en HOJAX"
     * Si no esta completa se añade la fila a la hoja teniendo en cuenta
     * si se ñade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        //Comprueba fila a fila si la fila esta llena. En caso de no estarlo, 
        //añade la nueva fila. Si hay mas de 3, salta el mensaje que dice que no es posible.
        if (hojaCompleta()){
             System.out.println(fila.getId() + " no se puede añadir en " + this.nombre + "\n");
        }
        else{
            if (this.fila1 == null){
                this.fila1 = fila;
            }
            else if (this.fila2 == null){
                this.fila2 = fila;
            }
            else if (this.fila3 == null){
                 this.fila3 = fila;
            }
        }
    }

    /**
     * Dada la informacion a guardar en una fila el metodo
     * crea la fila y la añade a la hoja
     * (evita repetir codigo)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        //Crea una fila y la añade en caso de haber alguna fila vacia
        Fila nuevaFila = new Fila(id, fecha, ingresos, gastos);
        if(getNumeroFilas() < 3){
        this.addFila(nuevaFila);
        }
    }
    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        //Comprobara fila a fila si hay un ingresoo para sumarlo a los ingresos totales
        double totalIngresos = 0;
        if (this.fila1 != null){
            totalIngresos = totalIngresos + this.fila1.getIngresos();
        }
        if (this.fila2 != null){
            totalIngresos = totalIngresos + this.fila2.getIngresos();
        }
        if (this.fila3 != null){
            totalIngresos = totalIngresos + this.fila3.getIngresos();
        }
        return totalIngresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        //Comprobara fila a fila si hay un gasto para sumarlo a los gastos totales
        double totalGastos = 0;
        if (this.fila1 != null){
            totalGastos = totalGastos + this.fila1.getGastos();
        }
        if (this.fila2 != null){
            totalGastos = totalGastos + this.fila2.getGastos();
        }
        if (this.fila3 != null){
            totalGastos = totalGastos + this.fila3.getGastos();
        }
        return totalGastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        //Comprobara fila a fila si hay un beneficio para sumarlo al beneficio total
        double totalBeneficio = 0;
        if (this.fila1 != null){
            totalBeneficio = totalBeneficio + this.fila1.getBeneficio();
        }
        if (this.fila2 != null){
            totalBeneficio = totalBeneficio + this.fila2.getBeneficio();
        }
        if (this.fila3 != null){
            totalBeneficio = totalBeneficio + this.fila3.getBeneficio();
        }
        return totalBeneficio;
    }

    /**
     * RepresentaciÃ³n textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
      //Formato para el titulo(esta pegado a la izquierda)
      String titulo = String.format("%s\n", getNombre());
      //Formato para titulos
      String primeraLinea = String.format("%23s%16s%16s%16s\n", "FECHA", "INGRESOS", "GASTOS", "BENEFICIO");
      //LLenar lineas con formato previamente configurado en el toString de Fila
      String filasLlenas = "";
      if (this.fila1 != null) {
          filasLlenas = filasLlenas + this.fila1.toString() + "\n";
      }
      if (this.fila2 != null){
          filasLlenas = filasLlenas + this.fila2.toString() + "\n";
      }
      if (this.fila3 != null) {
          filasLlenas = filasLlenas + this.fila3.toString() + "\n";
      }
      //Formato linea separadora
      String linea = "--------------------------------------------------------------------------------\n";
      //Formato resultados operaciones
      String resultados = String.format("%38.2f€%15.2f€%15.2f€\n", getTotalIngresos(), getTotalGastos(), getBeneficio());            
      //Devolvemos la hoja con los datos en el orden requerido
      return titulo + primeraLinea + filasLlenas + linea + resultados;
    }
    

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja dupicada serÃ¡ "Duplicada HojaX"
     * Al duplicar la hoja se duplicarÃ¡n tambiÃ©n las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
      //Una copia de la hoja actual, con "Duplicada" al principio. Comprobara que filas
      //estan llenas para poder copiarlas." 
      HojaCalculo hojaDuplicar = new HojaCalculo("Duplicada " + getNombre());
      if (fila1 != null) {
          hojaDuplicar.addFila(fila1);
      }
      if (fila2 != null){
          hojaDuplicar.addFila(fila2);
      }
      if (fila3 != null) {
          hojaDuplicar.addFila(fila3);
      }
      return hojaDuplicar;
    }

   
}
