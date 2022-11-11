
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
        HojaCalculo hoja = new HojaCalculo("HOJA1");
        Fecha fecha1 = new Fecha(4,10,2020);
        Fecha fecha2 = new Fecha(5,10,2020);
        Fila fila1 = new Fila("Fila1");
        Fila fila2 = new Fila("Fila2");
        Fila fila3 = new Fila("Fila3");
        Fila fila4 = new Fila("Fila4");
        hoja.addFila(fila1.getId(),fecha1,25.50,132.0);
        hoja.addFila(fila2.getId(),fecha2,300.0,350.0);
        hoja.addFila(fila3);
        hoja.addFila(fila4);
        System.out.println(hoja.toString());
        System.out.println(hoja.duplicarHoja().toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo hoja = new HojaCalculo("HOJA2");
        Fecha fecha1 = new Fecha(7,10,2020);
        Fecha fecha2 = new Fecha(8,10,2020);
        Fila fila1 = new Fila("Fila1");
        Fila fila2 = new Fila("Fila2");
        hoja.addFila(fila1.getId(),fecha1,260.0,125.0);
        hoja.addFila(fila2.getId(),fecha2,125.0,245.0);
        System.out.println(hoja.toString());
        System.out.println(hoja.duplicarHoja().toString());

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo hoja = new HojaCalculo("HOJA3");
        Fecha fecha1 = new Fecha(8,10,2020);
        Fila fila1 = new Fila("Fila1");
        hoja.addFila(fila1.getId(),fecha1,670.0,234.0);
        System.out.println(hoja.toString());
        System.out.println(hoja.duplicarHoja().toString());
    }

}
