
/**
 *  Clase con codigo para probar el resto de clases
 * 
 * @author - 
 *  
 */
public class TestHojaCalculo
{
    /**
     * Constructor  
     */
    public TestHojaCalculo()    {
        
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de calculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila que no se podra guardar puedes crearla con el primer constructor  
     de fila  
     */
    public void test1() {
    //Inicializamos una hoja con su nombre
    HojaCalculo Hoja1 = new HojaCalculo("HOJA1");
    //Creamos las fechas necesarias
    Fecha fecha1 = new Fecha(4,10,2020);
    Fecha fecha2 = new Fecha(5,10,2020);
    Fecha fecha3 = new Fecha(1,1,2020);
    //Creamos las filas necesarias de tipo Fila (una de ellas solo con "id" para que nos salte el error.
    Fila fila1 = new Fila("Fila1", fecha1, 25.50, 132.00);
    Fila fila2 = new Fila("Fila2", fecha2, 300.00, 350.00);
    Fila fila3 = new Fila("Fila3", fecha3, 0.00, 0.00);
    Fila fila4 = new Fila("Fila4");
    //Añadimos las filas a la hoja.
    Hoja1.addFila(fila1);
    Hoja1.addFila(fila2);
    Hoja1.addFila(fila3);
    Hoja1.addFila(fila4);
    //Declaramos la hoja duplicada ya que si la declaramos arriba no la detecta
    HojaCalculo hojaDuplicada = Hoja1.duplicarHoja();
    //Imprimimos la hoja y la hoja duplicada en su debido orden.
    System.out.println(Hoja1.toString());
    System.out.println(hojaDuplicada.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de calculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
    //Inicializamos una hoja con su nombre
    HojaCalculo Hoja2 = new HojaCalculo("HOJA2");
    //Creamos las fechas necesarias
    Fecha fecha1 = new Fecha(7,10,2020);
    Fecha fecha2 = new Fecha(8,10,2020);
    //Creamos las filas necesarias de tipo Fila 
    Fila fila1 = new Fila("Fila1", fecha1, 260.00, 125.00);
    Fila fila2 = new Fila("Fila2", fecha2, 125.00, 245.00);
    //Añadimos las filas a la hoja.
    Hoja2.addFila(fila1);
    Hoja2.addFila(fila2);
    //Declaramos la hoja duplicada ya que si la declaramos arriba no la detecta
    HojaCalculo hojaDuplicada = Hoja2.duplicarHoja();
    //Imprimimos la hoja y la hoja duplicada en su debido orden.
    System.out.println(Hoja2.toString());
    System.out.println(hojaDuplicada.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de calculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
    //Inicializamos una hoja con su nombre
    HojaCalculo Hoja3 = new HojaCalculo("HOJA3");
    //Creamos las fechas necesarias
    Fecha fecha1 = new Fecha(8,10,2020);
    //Creamos las filas necesarias (una de ellas solo con "id" para que nos salte el error.
    Fila fila1 = new Fila("Fila1", fecha1, 670.00, 234.00);
    //Añadimos las filas a la hoja.
    Hoja3.addFila(fila1);
    //Declaramos la hoja duplicada ya que si la declaramos arriba no la detecta
    HojaCalculo hojaDuplicada = Hoja3.duplicarHoja();
    //Imprimimos la hoja y la hoja duplicada en su debido orden.
    System.out.println(Hoja3.toString());
    System.out.println(hojaDuplicada.toString());        

    }

}
