
/**
 *  Clase con código para probar el resto de clases
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
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
    
    Fila fila4 = new Fila("Fila4");
    Fecha fecha1 = new Fecha(4,10,2020);
    Fecha fecha2 = new Fecha(5,10,2020);
    Fecha fecha3 = new Fecha(1,1,2020);
    Fila fila1 = new Fila("Fila1",fecha1,25.50,132);
    Fila fila2 = new Fila("Fila2",fecha2,300,350);
    Fila fila3 = new Fila("Fila3",fecha3,0,0);
    HojaCalculo hoja1 = new HojaCalculo("Hoja1");
    hoja1.addFila(fila1);
    hoja1.addFila(fila2);
    hoja1.addFila(fila3);
    hoja1.addFila(fila4);
    hoja1.toString();
    hoja1.duplicarHoja();
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
    Fecha fecha1 = new Fecha(7,10,2020);
    Fecha fecha2 = new Fecha(8,10,2020);
    Fila fila1 = new Fila("Fila1",fecha1,260,125);
    Fila fila2 = new Fila("Fila2",fecha2,125,245);
    HojaCalculo hoja2 = new HojaCalculo("Hoja2");
    hoja2.addFila(fila1);
    hoja2.addFila(fila2);
    hoja2.toString();
    hoja2.duplicarHoja();
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
    Fecha fecha1 = new Fecha(8,10,2020);
    Fila fila1 = new Fila("Fila1",fecha1,670,234);
    HojaCalculo hoja3 = new HojaCalculo("Hoja3");
    hoja3.addFila(fila1);
    hoja3.toString();
    hoja3.duplicarHoja();
    }

}
