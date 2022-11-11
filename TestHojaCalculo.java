
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Ander Vegas
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
        
        HojaCalculo Hoja1 = new HojaCalculo("HOJA1");
        
        Fecha fecha1 = new Fecha(4,10,2020);
        Fecha fecha2 = new Fecha(5,10,2020);
        Fecha fecha3 = new Fecha(1,1,2020);
        
        Fila fila1 = new Fila("Fila1",fecha1,25.50,132.00);
        Fila fila2 = new Fila("Fila2",fecha2,300.00,350.00);
        Fila fila3 = new Fila("Fila3",fecha3,0.00,0.00);
        Fila fila4 = new Fila("Fila4");
        
        Hoja1.addFila(fila1);
        Hoja1.addFila(fila2);
        Hoja1.addFila(fila3);
        Hoja1.addFila(fila4);

        System.out.println(Hoja1.toString());
        System.out.println(Hoja1.duplicarHoja());
        
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        
        HojaCalculo Hoja1 = new HojaCalculo("HOJA2");
        
        Fecha fecha1 = new Fecha(7,10,2020);
        Fecha fecha2 = new Fecha(8,10,2020);
        
        Fila fila1 = new Fila("Fila1",fecha1,260.00,125.00);
        Fila fila2 = new Fila("Fila2",fecha2,125.00,245.00);
        
        Hoja1.addFila(fila1);
        Hoja1.addFila(fila2);
        
        System.out.println(Hoja1.toString());
        System.out.println(Hoja1.duplicarHoja());
         
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        
        
        HojaCalculo Hoja1 = new HojaCalculo("HOJA3");
        
        Fecha fecha1 = new Fecha(8,10,2020);
        
        Fila fila1 = new Fila("Fila1",fecha1,670.00,234.00);
        
        Hoja1.addFila(fila1);
        
        System.out.println(Hoja1.toString());
        System.out.println(Hoja1.duplicarHoja());
         
            

    }

}
