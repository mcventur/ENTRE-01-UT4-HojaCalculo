
/**
 *  Clase con código para probar el resto de clases
 * 
 * @aitor - 
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
     * La fila4 que no se podra guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
        HojaCalculo hoja1= new HojaCalculo ("hoja 1");
        
        Fecha fecha1= new Fecha(4,10,2020);
        Fila fila1 = new Fila ("fila1",fecha1, 25.50, 132.00);
        hoja1.addFila(fila1);
        
        Fecha fecha2 = new Fecha(5,10,2020);
        Fila fila2 = new Fila ("fila2",fecha2,300.00,350.00);
        hoja1.addFila(fila2);
        
        Fecha fecha3 = new Fecha(1,1,2020);
        Fila fila3 = new Fila ("fila3",fecha3,0.00,0.00);
        hoja1.addFila(fila3);
        
        hoja1.toString();

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo hoja2= new HojaCalculo ("hoja 2");
        
        Fecha fecha1= new Fecha(7,10,2020);
        Fila fila1 = new Fila ("fila1",fecha1, 260.50, 125.00);
        hoja2.addFila(fila1);
        
        Fecha fecha2 = new Fecha(8,10,2020);
        Fila fila2 = new Fila ("fila2",fecha2,125.00,245.00);
        hoja2.addFila(fila2);
        
        String str = hoja2.toString();
        System.out.print(str);
        hoja2.duplicarHoja();
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo hoja1= new HojaCalculo ("hoja 3");
        Fecha fecha1= new Fecha(8,10,2020);
        Fila fila1 = new Fila ("fila2",fecha1, 670.00, 234.00);
        hoja1.addFila(fila1);

        String str = hoja1.toString();
        System.out.println(str);
    }

}
