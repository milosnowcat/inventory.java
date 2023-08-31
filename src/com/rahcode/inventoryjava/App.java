//                      .                    .                           
//                 :-:--=:-:::.             :=-**##*=:                   
//                  :=----------.         .-%@@@@@@@@@%:                 
//                 :-------------:        :@@@@@@@@@@@@%.                
//                :-=-----------==:       +@@@@@@@@@@@@@#                
//              .------------=------.     =@@@@@@@@@@@@@#                
//               :=-=-------===-=--      .+%@@@@@@@@@@@#=                
//                --=--------==-=-.       -*%@@@@@@@@@*-.                
//                   ::----===+-             .#%@@@@*.                   
//                      -+++=: .               :+##+                     
//                     -+=====.              .=%@@%%%#=                  
//                  :-----------:.        :+#%%%@@@@@%@%+-               
//                -----------------      -%%%%%@@@%@@%%@%%*              
//               .-==----------==--:     #%%%@%@@@@@@@@@@%%.             
//               :-=+----------*=---    =%%%@@%%@@@%%@@@%%%=             
//               ---=----------*----:  .#%%%@@%%@@@%@%@@%%%%             
//              :-===----------+=---=  -#%%%@@%%@%@%@%@@%%%%=            
//                --=----------=#==+.   ==+%@@%%@@@%@%@@*++.             
//                --=-----------*=---  :===#@@%%@@@%@%%%--=              
//                -==-----------++--=  ---:#@%@@@%%%@@@%--=              
//                -=------------=:--=. =-- %@%%%%%%@%%%@=-=              
//               .-+-------------.:---.--: %%%%%%%%@%%@@+==              
//               :-++*++++++*+***. --=+--  *###########**-=              
//               --*+++++++++*+++: :--*-: :------=------*-=              
//               =-*++++++++*+***- .--*-. :-------------+-=              
//              .--*+++=+*++*+***+ :==*=: -------=------===:             
//              :=+++++==+++*++**+ -*++=. -------+-------+=:             
//               -++++=+==**+++***  :-:   -------+-------+.              
//                -+++=++=****+**#        -------+=------=               
//                .++==*=---=*+**+        =------+*------=               
//                 ----=    :---=          ====-.::+====                 
//            :**#==---=:   ----= ..   .:::=--=+*%#*--=+***. .--:..      
//            .=+**#=--==   :=--=%@*:.-=+%%*--=: ::+=--+***+=#@%*-=-::.  
//                :+=--=. :::=--=:.-*#%*--=*---+-+**=--=--=+**+*=**%@%=  
//                  =--= .#%%=--=.  +*#%#= +---#%++#=---.+%@%+  .+++*+-  
//                  ====   .:+===:   -==+= :===*+: -==== .--:.      ..   
//                  =--=     ----:         .----   :=---                 
//                  ----     :---:         .=---   .=---                 
//                  ----     :---:         .=---    =---                 
//                  ---:     :---:         .=---    +---                 
//                  +##%.    =*##-         -%%#:    %%%#                 
//                 :@@@@-    #@@@+         %@@@*   :@@@%:                
//                 .====.    -++=:         =+==-    --==.                

// @milosnowcat

package com.rahcode.inventoryjava;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.Color;

/*
 * Requisitos del programa:
 *         Uso de variables locales y parámetros
 *         Uso de operadores (relacionales, aritméticos o matemáticos, lógicos y de asignación)
 *         Indicar la técnica de programación que está utilizando
 *         Uso de estructuras de decisión
 *         Uso de estructuras de repetición
 *         Uso de archivos
 *         Entrada y salida de datos
 *         Comentarios
 *         Funciones, utiliza mínimo una función de cada tipo de funciones
 *         Ventanas creadas por el programador por ejemplo formularios (ventanas que contengan: botones, cuadros de texto, etiquetas o listas de opciones)
 *         Ventanas creadas por la clase JOptionPane
 *         Uso de archivos de imágenes en las ventanas como fondo de la ventana o imágenes en los botones.
 *         Manejo de excepciones
 *         Uso de clases, es decir con una clase controladora y una o más clases objeto
 * 
 * 
 * 
 * Descripción de mi programa:
 * 
 * 
 * Programación orientada a objetos
 * 
 *     Programa para la administración de un negocio de sublimación de fundas para celulares, incluye:
 * 
 *         un registro de usuarios (empleados y otras personas que requieran acceso)
 *             existen 3 niveles de privilegio:
 *                 1: solamente puede ver los registros de productos
 *                 2: lo mismo que el anterior, además de que puede agregar, editar y borrar registros de productos
 *                 3: lo mismo que los dos anteriores, además de poder ver, agregar, editar y borrar los registros de usuario
 * 
 *         un registro de productos (muestra también la cantidad de productos que hay y el coste total)
 *             en el que se puede ingresar:
 *                 Marca de celular
 *                 Modelo
 *                 Cantidad
 *                 Costo (por unidad)
 * 
 *         una ventana de registro
 *             para crear el primer usuario con privilegio 3
 *             (solamente aparece la primera vez que se ejecuta)
 * 
 *         una ventana de inicio de sesión
 *             (para poder administrar los niveles de privilegio del usuario)
 * 
 *         una ventana de productos
 *             (donde se pueden buscar productos)
 *             una ventana de añadir producto
 *             una ventana de tabla de productos
 *                 (donde se pueden borrar productos, nivel de privilegio minimo requerido: 2)
 *                 una ventana de editar productos (nivel de privilegio minimo requerido: 2)
 * 
 *         una ventana de usuarios (nivel de privilegio minimo requerido: 3)
 *             (donde se pueden buscar usuarios, nivel de privilegio minimo requerido: 3)
 *             una ventana de añadir usuario (nivel de privilegio minimo requerido: 3)
 *             una ventana de tabla de usuarios (nivel de privilegio minimo requerido: 3)
 *                 (donde se pueden borrar usuarios, nivel de privilegio minimo requerido: 3)
 *                 una ventana de editar usuarios (nivel de privilegio minimo requerido: 3)
 * 
 *     Este proyecto esta basado en un proyecto mío llamado "Inventory.php" (https://www.rahcode.com/inventory.php)
 *         creado originalmente para "Good Idea, Arte y Diseño en Sublimación".
 * 
 * Autor: Ramiro Alvarez Hernandez
 * Fecha: 28112022-04122022
 */

public class App{
    public File userConfig=new File("user.config");
    public File usersDB=new File("assets/db/users.db");
    public File productsDB=new File("assets/db/products.db");
    public File productsTEMP=new File("assets/db/products.db.temp");
    public File usersTEMP=new File("assets/db/users.db.temp");
    public FileWriter wri;
    public PrintWriter pri;
    public FileReader rea;
    public BufferedReader buf;
    
    public static void main(String[] args){
        App app=new App();

        if(!app.userConfig.exists()){
            app.window(false);
        }else if(app.config()[2].equals("true")){
            app.window(true);
        }else{
            app.window(false);
        }
    }

    public void window(Boolean darkTheme){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Users frame = new Users(darkTheme);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public int session(String user,String pass,int action){
        String id=null,usr=null,pas=null,lvl=null;
        int ret=0;

        try {
            rea=new FileReader(usersDB);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        buf=new BufferedReader(rea);

        switch(action){
            case 1:
                do{
                    try {
                        id=buf.readLine();
                        usr=buf.readLine();
                        pas=buf.readLine();
                        lvl=buf.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(user.equals(usr)){
                        ret=1;
                        if(pass.equals(pas)){
                            ret=2;
                        }
                    }
                }while(id!=null);
                if(ret==0){
                    createConfig(null, null, false,"1");
                }
                break;
            case 2:
                do{
                    try {
                        id=buf.readLine();
                        usr=buf.readLine();
                        pas=buf.readLine();
                        lvl=buf.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(user.equals(usr)&&pass.equals(pas)){
                        ret=Integer.parseInt(lvl);
                    }
                }while(id!=null);
                break;
            default:
                ret=0;
        }
        
        try {
            rea.close();
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return(ret);
    }

    public void auth(){
        JOptionPane.showMessageDialog(null,"You are not authorized to do this","E R R O R",JOptionPane.ERROR_MESSAGE);
    }

    public void createConfig(String user,String password,Boolean theme,String last){
        String themes=String.valueOf(theme);

        try {
            wri=new FileWriter(userConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pri=new PrintWriter(wri);
        
        pri.println(user+"\n"+password+"\n"+themes+"\n"+last);
        
        pri.close();
        try {
            wri.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String[] config(){
        //username, password, theme, last
        String[] conf={null,null,null,null};

        if(!userConfig.exists()){
            try {
                userConfig.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            rea=new FileReader(userConfig);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        buf=new BufferedReader(rea);

        try {
            conf[0]=buf.readLine();
            conf[1]=buf.readLine();
            conf[2]=buf.readLine();
            conf[3]=buf.readLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            buf.close();
            rea.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return(conf);
    }

    public Color colors(Boolean dark,int c){
        Color color;
        if(!dark){
            //LIGHT
            switch(c){
                case 1:
                    //First color
                    color=new Color(87,110,224);
                    return(color);
                case 2:
                    //First color second
                    color=new Color(87,110,224);
                    return(color);
                case 3:
                    //First color alt
                    color=new Color(67,90,203);
                    return(color);
                case 4:
                    //First color lighter
                    color=new Color(182,193,252);
                    return(color);
                case 5:
                    //Title color
                    color=new Color(35,36,41);
                    return(color);
                case 6:
                    //Text color
                    color=new Color(106,109,124);
                    return(color);
                case 7:
                    //Text color light
                    color=new Color(159,161,173);
                    return(color);
                case 8:
                    //Input color
                    color=new Color(238,240,252);
                    return(color);    
                case 9:
                    //Body color
                    color=new Color(251,251,254);
                    return(color);
                case 10:
                    //Container color
                    color=new Color(255,255,255);
                    return(color);
                case 11:
                    //Scroll bar color
                    color=new Color(226,227,233);
                    return(color);
                case 12:
                    //Scroll thumb color
                    color=new Color(198,200,210);
                    return(color);
                default:
                    return(null);
            }
        }else{
            //DARK
            switch(c){
                case 1:
                    //First color
                    color=new Color(87,110,224);
                    return(color);
                case 2:
                    //First color second DARK
                    color=new Color(14,16,27);
                    return(color);
                case 3:
                    //First color alt
                    color=new Color(67,90,203);
                    return(color);
                case 4:
                    //First color lighter
                    color=new Color(182,193,252);
                    return(color);
                case 5:
                    //Title color DARK
                    color=new Color(241,242,243);
                    return(color);
                case 6:
                    //Text color DARK
                    color=new Color(186,188,196);
                    return(color);
                case 7:
                    //Text color light
                    color=new Color(159,161,173);
                    return(color);
                case 8:
                    //Input color DARK
                    color=new Color(29,33,53);
                    return(color);    
                case 9:
                    //Body color DARK
                    color=new Color(22,25,39);
                    return(color);
                case 10:
                    //Container color DARK
                    color=new Color(29,33,53);
                    return(color);
                case 11:
                    //Scroll bar color DARK
                    color=new Color(108,113,137);
                    return(color);
                case 12:
                    //Scroll thumb color DARK
                    color=new Color(81,84,103);
                    return(color);
                default:
                    return(null);
            }
        }
    }

    public Font fonts(int f,float size) throws FontFormatException, IOException{
        Font font;
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        switch(f){
            case 1:
                //Poppins Regular
                font=Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/Poppins-Regular.ttf")).deriveFont(size);
                ge.registerFont(font);
                return(font);
            case 2:
                //Poppins Medium
                font=Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/Poppins-Medium.ttf")).deriveFont(size);
                ge.registerFont(font);
                return(font);
            case 3:
                //Poppins Semi-Bold
                font=Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/Poppins-SemiBold.ttf")).deriveFont(size);
                ge.registerFont(font);
                return(font);
            default:
                return(null);
        }
    }
}
