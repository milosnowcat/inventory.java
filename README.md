# inventory.java

Proyecto Final - Desarrollo de Software

## Manual de usuario

### Introducción

En este manual se le explicará al usuario como instalar, entrar y salir del sistema, así como también la manera de hacer uso de ciertas funciones de manera gráfica para un mejor entendimiento del programa. La elaboración de este sistema se basa en incluir todos los conocimientos a lo largo de la esta unidad y de las anteriores con el fin de generar un programa concreto.

### Descripción del proyecto

Programa para la administración de inventario en un negocio:
- un registro de usuarios (empleados y otras personas que requieran acceso)
    - existen 3 niveles de privilegio:
        - 1: solamente puede ver los registros de productos
        - 2: lo mismo que el anterior, además de que puede agregar, editar y borrar registros de productos
        - 3: lo mismo que los dos anteriores, además de poder ver, agregar, editar y borrar los registros de usuario 
- un registro de productos (muestra también la cantidad de productos que hay y el coste total) en el que se puede ingresar:
    - Marca
    - Modelo
    - Cantidad
    - Costo (por unidad)
- una ventana de registro
    - para crear el primer usuario con privilegio 3 (solamente aparece la primera vez que se ejecuta)
- una ventana de inicio de sesión
    - (donde se pueden buscar productos)
    - una ventana de añadir producto
    - una ventana de tabla de productos
        - (donde se pueden borrar productos, nivel de privilegio mínimo requerido: 2)
        - una ventana de editar productos (nivel de privilegio mínimo requerido: 2)
- una ventana de usuarios (nivel de privilegio mínimo requerido: 3)
    - (donde se pueden buscar usuarios, nivel de privilegio mínimo requerido: 3)
    - una ventana de añadir usuario (nivel de privilegio mínimo requerido: 3)
    - una ventana de tabla de usuarios (nivel de privilegio mínimo requerido: 3)
        - (donde se pueden borrar usuarios, nivel de privilegio mínimo requerido: 3)
        - una ventana de editar usuarios (nivel de privilegio mínimo requerido: 3)
- Este proyecto está basado en un proyecto mío llamado "[Inventory.php](https://www.rahcode.com/inventory.php)" creado originalmente para "[Good Idea, Arte y Diseño en Sublimación](https://www.rahcode.com/good-idea)".

### Entrada y salida del sistema

El archivo ejecutable se descargará como un .zip. Al momento de descomprimirlo quedará en descargas con el mismo nombre, solo que esta vez será una carpeta.

![Descomprimir](/assets/readme/1.png)

Ejecute el archivo app.jar, necesita la versión más reciente de [Java](https://www.java.com/download)

![Ejecutar](/assets/readme/2.png)

### Uso de la aplicación

Al iniciar el programa aparece la siguiente interfaz

![Iniciar](/assets/readme/3.png)

Se necesita crear un usuario forzosamente. Una vez hecho presione el botón a continuación.

![Registrar](/assets/readme/4.png)

Una vez que se ha iniciado sesión aparecerá la siguiente interfaz.

![Ingresar](/assets/readme/5.png)

Con el botón subrayado se agregan productos.

![Agregar](/assets/readme/6.png)

Con el siguiente botón se ven productos en la tabla.

![Ver](/assets/readme/7.png)
![Fin](/assets/readme/8.png)
