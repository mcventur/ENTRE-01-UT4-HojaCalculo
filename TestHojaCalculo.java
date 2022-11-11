
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Kaiet Jimenez Aldasoro
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
        
        HojaCalculo hoja1 = new HojaCalculo("HOJA1");
        
        
        Fila fila1 = new Fila("Fila1"); Fecha fe1 = new Fecha(4,10,2020);
        Fila fila2 = new Fila("Fila2"); Fecha fe2 =new Fecha(5,10,2020);
        Fila fila3 = new Fila("Fila3");
        Fila fila4 = new Fila("Fila4");
       
        
        hoja1.addFila("Fila1",fe1,25.5,132.00);
        hoja1.addFila("Fila2",fe2,300.00,350.00);
        hoja1.addFila(fila3);
        hoja1.addFila(fila4);
        
        System.out.println(hoja1.toString());
        System.out.println(hoja1.duplicarHoja().toString());
        
        //declaro una variable local de HojaCalculo llamado hoja1 que creara un nuevo objeto HojaCalculo, que se llamara HOJA1
        //creamos cuatro variables para las 4 filas y  dos variables fecha para crear objetos fecha (el constructor nos da tres parametros int: dia,mes,anio).
        //anadimos las filas a la variable hoja.
        //Le diremos que nos imprima por pantalla la hoja1 aprovecharemos el metodo externo to string para no repetir codigo, y otra hoja mas que aprovecharemos el metodo externo duplicarHoja y otra vez el toString
        

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo hoja1 = new HojaCalculo("HOJA2");
        
        Fila fila4 = new Fila("Fila"); Fecha fe1 = new Fecha(7,10,2020);
        Fila fila2 = new Fila("Fila2"); Fecha fe2 =new Fecha(8,10,2020);
        
        hoja1.addFila("Fila1",fe1,260.00,125.00);
        hoja1.addFila("Fila2",fe2,125.00,245.00);
        
        System.out.println(hoja1.toString());
        System.out.println(hoja1.duplicarHoja().toString());
        
         

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo hoja3 = new HojaCalculo("HOJA3");
        
        
        Fila fila4 = new Fila("Fila"); Fecha fe1 = new Fecha(8,10,2020);
        hoja3.addFila("Fila1",fe1,670.00,234.00);
        
        System.out.println(hoja3.toString());
        System.out.println(hoja3.duplicarHoja().toString());
            

    }

}
