# Comparación de Prim y Kruskal

Se generaron 10 grafos aleatorios de 10, 50 y 100 vértices y se ejecutaron ambos algoritmos sobre
el mismo grafo.

## 1. ¿Generan las mismas aristas?

| Vértices | Mismo peso total | Aristas distintas |
|:--------:|:----------------:|:-----------------:|
| 10       | **10/10**        | 1/10              |
| 50       | **10/10**        | 3/10              |
| 100      | **10/10**        | 5/10              |

Cada MST tiene `V − 1` aristas, como debe ser. El **peso total siempre coincide**, pero el conjunto
de aristas no.

El generador usa pesos entre 1 y 100, así que a 100 vértices (unas 300 aristas) hay muchos empates. Con empates
existen varios MST de igual costo y cada algoritmo elige uno distinto: Kruskal por su orden de
peso, Prim por su cola de prioridad. A más vértices, más empates, más diferencias.

## 2. Tiempos de ejecución

| Vértices | Kruskal (ns) | Prim (ns) | Ganador |
|:--------:|:------------:|:---------:|:--------|
| 10       | 2 439        | 2 741     | Kruskal |
| 50       | 13 675       | 11 144    | **Prim** |
| 100      | 19 036       | 17 021    | **Prim** |

En 50 y 100 vértices Prim es más rápido. En 10 vértices Kruskal gana por poco, pero es un empate
técnico: el ruido de la medición llega al 54 %, así que no significa nada.

Ambos algoritmos son `O(E log E)`, así que la diferencia es de constantes, no de complejidad.

## 3. Cómo se midió

`REPETICIONES = 20` en `MSTTimer` hace dos cosas:

- **20 ejecuciones sin cronometrar**, para que la JVM compile el código. Si no, se mediría el
  intérprete y no el algoritmo.
- **20 ejecuciones cronometradas quedándose con la más rápida**, no con el promedio, porque el
  garbage collector y el sistema operativo distorsionan la media.

Ambos algoritmos reciben el mismo trato: mismo grafo, mismas repeticiones, mismo criterio. Por eso
la comparación es válida.
