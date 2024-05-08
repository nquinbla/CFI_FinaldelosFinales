# CASO FINAL INTEGRADOR DE LOS FINALES
Caso Final Integrador de los Finales de Nerea Quintanilla Blanco

LINK ->

---
## ÍNDICE


---
---

## EJERCICIOS

### EJERCICIO 1 (0.5 puntos)
  1). -> b) Debemos establecer la visibilidad más restrictiva (por ejemplo, privada) en los atributos de una clase. Así, cualquier software que utilice nuestro objeto, sólo accederá al estado de los objetos mediante los métodos que le hayamos permitido utilizar.

  2). -> b) Falso

  3). -> b)	Herencia

  4). -> 

  5). ->

---

### EJERCICIO 2 (2 puntos)
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

### EJERCICIO 3 (0.75 + 0.75 puntos)
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

### EJERCICIO 4 (1.5 puntos)




### EJERCICIO 5 (2.5 + 1.5 + 1 puntos)





