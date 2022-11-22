
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Marce
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
        HojaCalculo h = new HojaCalculo("HOJA1");
        //Podemos usar las dos formas del método addFila. En este test uso la que recibe los datos de la fila a añadir 
        h.addFila("Fila1", new Fecha(4,10,2020), 25.50, 132);
        h.addFila("Fila2", new Fecha(5,10,2020), 300, 350);
        h.addFila("Fila3", new Fecha(1,11,2020), 0, 0);
        //Me invento los valores de fila4, que no cabe en la hoja
        h.addFila("Fila4", new Fecha(1,11,2020), 0, 0);
        
        //Mostramos la hoja
        System.out.println(h.toString());
        
        //Duplicamos
        HojaCalculo hCopia = h.duplicarHoja();
        System.out.println(hCopia.toString());
        
        

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
         HojaCalculo hoja = new HojaCalculo("HOJA2");
         //Podemos usar las dos formas del método addFila. En este test uso la que sólo recibe un parámetro: la fila a añadir ya premontada
         hoja.addFila(new Fila("Fila1", new Fecha(7,10,2020), 260, 125));
         hoja.addFila(new Fila("Fila1", new Fecha(8,10,2020), 125, 245));
         System.out.println(hoja);
         
         System.out.println(hoja.duplicarHoja().toString());//El toString es opcional. Si no se escribe se ejecuta igual
         
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
            

    }

}
