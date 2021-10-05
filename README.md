# laura-valentina-mayorga-forero-parcial-2-ads

Problema que se busca resolver:

Se desarrollo un programa de música donde existen Artistas y Oyentes.
Los Artistas pueden crear su cuenta con su nombre y opcionalmente Albums, Canciones y Disquera; 
Cada artista tiene la oportunidad de sacar (release) canciones;
Y visualizar información como álbumes que tiene, canciones y disquera.

Los Oyentes pueden crear su cuenta con su nombre;
Subscribirse a algún artista y recibir notificaciones de cuando este ha estrenado una nueva canción;
Y visualizar información como historial de canciones que han lanzado los artistas desde que se ha subscrito a ellos y los artistas a los que está subscrito

Lenguaje de programación: Java
IDE de desarrollo: NetBeans IDE 8.2

Instrucciones para ejecutar el programa: Descargar el programa y en el entorno de desarrollo correr la clase client

Instrucciones de funcionamiento:

El programa automáticamente creara algunos artistas, oyentes que se suscribirán a algunos artistas y sacara nuevas canciones
El usuario podrá elegir entre las opciones mostradas "Artist", "Listener, "Exit"

Artist (Artista):
Elegir entre las opciones el artista a visualizar o "New artist" para crear uno
Si se elige un artista, su información se visualizará en la consola y se podrá sacar una nueva canción escribiendo su nombre en el recuadro;
automáticamente se les informara a todos los oyentes subscrito que se ha lanzado la canción 
(esto se puede comprobar por los mensajes que se enviaran en la consola con el formato 'NombreSubscriptor': 'NombreArtista' drop a new song named 'NombreNuevaCancion';
y porque la nueva canción aparecerá en la información del artista).
Si se elige crear un nuevo Artista, el usuario ingresara la información en los recuadros siendo name obligatorio y albums, songs y record company opcionales;
si el usuario quiere añadir más de un álbum o canción, tendrá que separarlas por ';'.

Listener (oyente):
Elegir entre las opciones el oyente a visualizar o "New Listener" para crear uno
Si se elige un oyente, su información se visualizará en la consola y podrá subscribirse a un nuevo artista seleccionándolo de la lista y dando aceptar
(esto se puede comprobar en la información actualizada del oyente que aparecerá en la consola)
Si se elige crear un nuevo Oyente, el usuario ingresará el nombre en el recuadro y este será creado sin ninguna subscripción


Patrones:

Builder (creacional): 

En el programa se necesitan crear artistas que puede que no tengan álbumes, canciones o disquera, por lo tanto, son campos opcionales y pueden llegar a ser null
El patrón de diseño escogido permite crear estos objetos según las características que si cumple sin importar que los demás campos sean null;
Ayudando a reducir la complejidad de creación creando el objeto paso a paso según lo necesario

Este patrón se puede encontrar en la clase "Builder" dentro de "Artist" (línea 27 hasta 69) donde se hace la aplicación del patrón creando métodos que permitirán crear el objeto según las características que se quieran tener.
Y en el método "newArtist" dentro de "Client" (específicamente iniciando desde la línea 108 hasta 161) donde se hace el llamado para el uso del patrón construyendo el objeto según lo deseado

Observer (Comportamental): 

En el programa se quiere que cada vez que una artista saque una nueva canción les llegue una alerta a todos sus subscritores 
El patrón observer permite que los oyentes se subscriban al artista que funcionara como notificador y que cada vez que se realiza alguna modificación, en este caso sacar una canción, todos los subscriptores sean notificados de manera masiva

Este patrón se puede encontrar en los métodos "addListener", "removeListener" y "addSong" dentro de "Artist" (línea 115 - 129) los cuales añadirán o removerán los subscriptores y darán la alerta del cambio de sacar canción, respectivamente; 
el método "propertyChange" dentro de "Listener" (línea 27 - 32) que será aquel que recibe la alerta de cambio;
Y en el método "artistInfo" dentro de "Client" (línea 204).
