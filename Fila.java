
/**
 *  Representa a una fila de la hoja de cÃ¡lculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - 
 *  
 */
public class Fila
{
    private String id;
    private Fecha fecha;
    private double ingresos;
    private double gastos;

    /**
     * Constructor  
     */
    public Fila(String id) {
        this.id = id;
        this.fecha = new Fecha(1,1,2020);
        this.ingresos = 0.0;
        this.gastos = 0.0;
    }

    /**
     * Constructor  
     */
    public Fila(String id, Fecha fecha, double ingresos, double gastos) {
        this.id = id;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.gastos = gastos;
    }
    
    /**
     * accesor para el id de la fila
     */
    public String getId() {
        return this.id;
    }


    /**
     * accesor para la fecha
     */
    public Fecha getFecha() {
        return this.fecha;

    }

    /**
     * accesor para los ingresos
     */
    public double getIngresos() {
        return this.ingresos;

    }

    /**
     * accesor para los gastos
     */
    public double getGastos() {
        return this.gastos;

    }

    /**
     * calcula y devuelve el beneficio
     */
    public double getBeneficio() {
        return this.ingresos - this.gastos;

    }
    
    /**
     * obtiene una copia idÃ©ntica a la fila actual.
     * La fecha que incluye la fila duplicada tambiÃ©n es una copia
     * 
     */
    public Fila duplicar() {
        //Creamos una nueva fila igual a la actual con los datos de nuestra fila excepto
        //la fecha que sera una copia
        return new Fila(this.id, this.fecha.obtenerCopia(), this.ingresos, this.gastos);
    }

    /**
     * RepresentaciÃ³n textual de una fila
     * (leer enunciado)
     */
    public String toString() {
      //Asignamos un formato a cada uno de los datos que queremos representar
      String id = String.format("%8s", this.id);
      String fecha = String.format("%15s", this.fecha);
      String ingresos = String.format("%15.2f€", this.ingresos);
      String gastos = String.format("%15.2f€", this.gastos);
      String beneficio =  String.format("%15.2f€", this.getBeneficio());
      //Para añadir dos asteriscos al final de los numeros negativos, le asignamos un 
      //hueco vacio a "negativo" y creamos una condición en la que añada "**" despues de
      //el beneficio en caso de que el numero sea negativo.
      String negativo = "";
      if (this.getBeneficio() < 0.0){
          negativo += " **";
      }
      //Devolvemos la fila con los datos ordenados 
      return (id + fecha + ingresos + gastos + beneficio + negativo);
    }

     

}
