# CASO FINAL INTEGRADOR DE LOS FINALES
Caso Final Integrador de los Finales de Nerea Quintanilla Blanco

LINK -> https://github.com/nquinbla/CFI_FinaldelosFinales.git

---
## ÍNDICE

- [EJERCICIOS](#ejercicios)
  - [EJERCICIO 1 (0.5 puntos)](#ejercicio-1-(0.5-puntos))
  - [EJERCICIO 2](#ejercicio-2)
    - [APARTADO 2](#apartado-2)
    - [APARTADO 3](#apartado-3)
    - [APARTADO 4](#apartado-4)
    - [APARTADO 5](#apartado-5)
  - [EJERCICIO 3](#ejercicio-3)
  - [EJERCICIO 4](#ejercicio-4)
  - [EJERCICIO 5](#ejercicio-5)
    - [MÓDULO 1](#módulo-1)
    - [MÓDULO 2](#módulo-2)
    - [MÓDULO 3](#módulo-3)

---
---

## EJERCICIOS

### [EJERCICIO 1] (0.5 puntos)
  1). -> b) Debemos establecer la visibilidad más restrictiva (por ejemplo, privada) en los atributos de una clase. Así, cualquier software que utilice nuestro objeto, sólo accederá al estado de los objetos mediante los métodos que le hayamos permitido utilizar.

  2). -> b) Falso

  3). -> b)	Herencia

  4). -> 

  5). ->

---

### [EJERCICIO 2] (2 puntos)
Escogo hacer los apartados 2, 3, 4 y 5 de los cinco proporcionados.

#### 2). APARTADO 2
  Las principales diferencias entre el hash y el árbol son que el hash es como un array estático de listas, convierte un conjunto de datos en una cadena de longitud fija mapeando los datos   de entrada a valores hash únicos, sin embargo, el árbol lo hace de manera que organiza los datos jerarquicamente. 
  Conviene utilizar la estructura hash para la búsqueda eficiente de datos (por lo antes mencionado), mientras que si quieres organizar estos datos de manera jerárquica y realizar
  operaciones de búsqueda, insercción y eliminación de datos de manera eficiente, es más recomendable una estructura de árbol.

#### 3). APARTADO 3
  Las diferencias entre una pila y una cola son que las dos estan basadas e distintos criterios, LIFO y FIFO respectivamente. LIFO hace que el último elemento que se inserta de la pila, es   el primero en ser retirado, y en FIFO es al revés.
  Se recomienda utilizar la cola cuando es necesario procesar elementos en el orden de llegada, y la pila cuando es necesario hacer operaciones en el orden inverso al que fueron
  insertados. 
  El orden de complejidad tanto de la pila como de la cola es de O(1), aunque en diversos casos pueden llegar a ser de O(n).

#### 4). APARTADO 4
  El metodo de ordenación de insercción considera que el array se divide en dos partes: la parte ordenada, situada en la izquierda, y la parte desordenada, situada a la derecha.
  continuación explicaré el método sobre el conjunto de datos proporcionado 50 20 84 13 22 16 89 85:
    - Buscamos la primera parte, la cuál se considera la parte inicial ordenada:
          Lista ordenada: 50
    - Tomamos e siguiente elemento de la denominada parte desordenada, en este caso `20`, y lo insertamos delante del primer elemento, ya que este es menor:
          Lista ordenada: [ 20 , 50 ]
    - Repetimos este proceso con el resto de elementos, tomando cada elemento de la parte desordenada y colocandolo en la posición idonea en la llamada parte ordenada:
          Lista ordenada: [ 20, 50 , 84 ]
          Lista ordenada: [ 13 , 20 , 50 , 84 ]
          Lista ordenada: [ 13 , 20 , 22 , 50 , 84 ]
          Lista ordenada: [ 13 , 16, 20 , 22 , 50 , 84 ]
          Lista ordenada: [ 13 , 16, 20 , 22 , 50 , 84 , 89 ]
          Lista ordenada: [ 13 , 16, 20 , 22 , 50 , 84 , 85 , 89]


#### 5). APARTADO 5
  Teniendo en cuenta que tenemos que 
      A < B -> 1024n < 16n^3
  Diviendo ambos lados entre n:
      1024n(/n) < 16n^3(/n) -> 1024 < 16n^2
  Podemos simplificar de la siguiente manera para que sea más sencillo:
      1024(/16) < 16n^2(/16) -> 16n < n^2
  Tomamos la raíz cuadrada y haciendo ese cálculo nos da como resultado lo siguiente:
      8 < n
  Esto significa que los valores de n mayores de 8, la función A llega a ser más eficiente que la B. 

---

### [EJERCICIO 3] (0.75 + 0.75 puntos)
  a) Si código se llegase a  ajecutar no imprimiría nada, esto pasa ya que el propio código se atasca en un ciclo que nunca termina dado que el segundo número que le introducimos,
  denominado b, siempre es negativo y nunca puede llegar a ser cero. Teniendo en cuenta esto, el código sigue llamando a la función recursiva con b que disminuye de uno en uno, y como
  hemos dicho antes, disminuirlo en uno lo sigue haciendonegativo, alejandolo del cero. Y como la función recursiva solo se detiene cuando b es cero, nunca deja de llamarse a sí misma,
  creando un bcle infinito.
  Para solucionar el error, se debería de implementar una terminación adicional, donde en el caso de que b sea negativo se imprima en la consola el número 1:
  [if (b == 0 || b < 0)]


  b) Estoy calculando el resultado de elevar a `a` la potencia `b` utilizando el método de recursión de cola, esta hace que la llamada recursiva sea la última operación antes de que la función devuelva un valor.
  * Caso Base: si `b` es igual a 0 o >0, la función devuelve 1, correspondiendo a cualquier número elevado a 0. Si es =0, la función devuelve 0, ya que cualquier número elevado a 0 es 1        excepto el propio 0.

  * Caso Recursivo: si `b` es <0, la función realiza una llamada recursiva, disminuyendo poco a poco el valor de este hasta que alcance el 0 o >0, en cada llamada se multiplica `a` por el resultado de la llamada recursiva con `b`, disminuyendo en 1.

---

### [EJERCICIO 4] (1.5 puntos)
  Te lo resuelvo aquí y además también estará implemetado en una clase `Ejercicio_4':
```
1  public class Ejercicio_4 {
2    public static void main(String[] args) {
3        int number = 102;
4        int sum = sumOfDigits(number);
5        System.out.println(sum);
6    }
7    public static int sumOfDigits(int n) {
8        if (n < 10) {
9            return n;
10        } else {
11            return n % 10 + sumOfDigits(n / 10);
12        }
13    }
14 }
```
  Se esta empleando el método de recursividad de cola. Lo podemos observar ya que la última operación realizada en la función antes de devolver un valor en la líena 11 (return n % 10 +
  sumOfDigits(n / 10);). 
  La complejidad computacional del algoritmo va creciendo de manera proporcional al número de dígitos de n. Por ejemplo, la función `sumOfDigits` recorre los dígitos del n y suma cada uno
  de ellos. La cantidad de llamadas recursivas esta determinada por el número de dígitos de n.

---

### [EJERCICIO 5] (2.5 + 1.5 + 1 puntos)

#### [1] MÓDULO 
En la red social Twitter, cada usuario es propietario de una cuenta (UserAccount) en la que, básicamente, se especifica un alias (que cumple las funciones de identificador único) y un email de contacto. En la cuenta, además, se incluye el conjunto de tweets que el propietario va publicando a lo largo del tiempo.
Como la cantidad de mensajes que maneja la red es inmensa, una característica original de Twitter es que cada usuario puede seleccionar la información que le interesa recibir. De esta manera, el propietario de una UserAccount puede convertirse en seguidor (follower) de otros usuarios, mostrando su interés en los tweets que ellos publiquen. Así, cada vez que un usuario publica un tweet, éste es incluido en el timeline de la UserAccount de cada uno de sus followers (es decir, el timeline se corresponde con el conjunto de tweets recibidos). Un usuario tiene también una lista de personas a las que sigue (following). En base a estas especificaciones se solicita que:

  a). Programe la clase UserAccount y sus constructores. Incluya todos sus atributos. Al iniciar una cuenta el usuario no sigue a nadie, no tiene ningún tweet y el timeline está vacío. Establezca la visibilidad adecuada. Indica el tipo de datos de todos los atributos y parámetros del constructor y suponga que ya tiene implementadas correctamente las clases Tweet y Email. Justifique, brevemente, porqué ha seleccionado cada estructura de datos para los atributos. Se debe comprobar que el email contiene el carácter (@) y que el alias solo 
contienenúmeros y/o letras. Programe una clase Utils que contenga funciones independientes para comprobar si el email es válido y si el alias es válido. En caso contrario, se deberá gestionar de forma adecuada la casuística.

  b). Implemente, en UserAccount, un método que permita a un usuario seguir a otro. El método no debe devolver nada.
    • Al ejecutar “user.follow(user2)”, el usuario user se convertirá en follower de user2.
    • Añada, si lo necesita, métodos auxiliares (por ejemplo, para manejar los followers de user2).
    • Gestione adecuadamente que un usuario no pueda seguir dos veces al mismo usuario. Si esto ocurre, se gestionará adecuadamente.

  c). Implemente, en UserAccount, un método que permita a un usuario publicar un Tweet:
    • Después de ejecutar el método “user.tweet(tweet1)”, se deberá actualizar adecuadamente el atributo tweets de user. Además, todos los followers de user habrán recibido el tweet1 en         su timeline.
    • Añada, si lo necesita, métodos auxiliares (por ejemplo, para manejar el timeline de los
      followers).

  d). Implemente el método toString que únicamente muestre el nombre de usuario y el correo electrónico.

#### [2] MÓDULO 
En la red social Twitter, la unidad básica de información se denomina Tweet. Un Tweet es creado en un instante de tiempo concreto (time), contiene un mensaje (message) con un máximo de 140 caracteres de longitud y es publicado por un usuario (conocido como sender). Además, existen dos tipos de Tweet especiales:

  - DirectMessage: Los mensajes directos son Tweets que permiten comunicarse, de manera privada, a dos usuarios dentro de la red. Estos DirectMessage son como Tweets ya que contienen un       mensaje (message), son publicados por un emisor (sender) y son creados en un instante de tiempo determinado (time); la única diferencia es que incluyen a otro usuario como receptor        (receiver) del tweet.
  - Retweet: Cuando un usuario lee un tweet interesante que le ha llegado a su timeline, y quiere reenviarlo a su lista de followers, crea un retweet. Este Retweet es como un Tweet, es        decir, el usuario que lo publica (sender) puede poner un mensaje (message) y lo crea en un tiempo determinado (time); la única diferencia es que el Retweet incluye una referencia al       Tweet que se reenvía.

En base a estas especificaciones se solicita que:

#### [3] MÓDULO 



