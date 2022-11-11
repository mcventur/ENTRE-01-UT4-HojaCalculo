
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Daniel Villadangos
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
        HojaCalculo hojaTest1 = new HojaCalculo("HOJA1");
        Fecha fecha1 = new Fecha(4,10,2020);
        Fecha fecha2 = new Fecha(5,10,2020);
        Fecha fecha3 = new Fecha(1,1,2020);
        hojaTest1.addFila("Fila1",fecha1,25.5,132);
        hojaTest1.addFila("Fila2",fecha2,300,350);
        hojaTest1.addFila("Fila3",fecha3,0,0);
        hojaTest1.addFila(new Fila("4"));
        System.out.println(hojaTest1.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo hojaTest2 = new HojaCalculo("HOJA2");
        Fecha fecha1 = new Fecha(7,10,2020);
        Fecha fecha2 = new Fecha(8,10,2020);
        hojaTest2.addFila("Fila1",fecha1,260,125);
        hojaTest2.addFila("Fila2",fecha2,125,245);
        System.out.println(hojaTest2.toString());
        System.out.println("");
        System.out.println(hojaTest2.duplicarHoja().toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo hojaTest3 = new HojaCalculo("HOJA3");
        Fecha fecha1 = new Fecha(8,10,2020);
        hojaTest3.addFila("Fila1",fecha1,670,234);
        System.out.println(hojaTest3.toString());
        System.out.println("");
        System.out.println(hojaTest3.duplicarHoja().toString());
    }

}
