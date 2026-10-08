# Comparación de Prim y Kruskal

Se generaron 100 grafos aleatorios de 10, 50 y 100 vértices y se ejecutaron ambos algoritmos sobre
el mismo grafo.

## 1. ¿Generan las mismas aristas?

| Vértices | Mismo peso total | Aristas distintas |
|:--------:|:----------------:|:-----------------:|
| 10       | **100/100**      | 7/100             |
| 50       | **100/100**      | 29/100            |
| 100      | **100/100**      | 52/100            |

Cada MST tiene `V − 1` aristas, como debe ser. El **peso total siempre coincide**, pero el conjunto
de aristas no.

**¿Por qué? No es un error.** El MST solo es único si todos los pesos son distintos. El generador
usa pesos entre 1 y 100, así que a 100 vértices (unas 300 aristas) hay muchos empates. Con empates
existen varios MST de igual costo y cada algoritmo elige uno distinto. A más vértices, más empates,
más diferencias.

Lo verifiqué de dos formas:

| Comprobación | V=10 | V=50 | V=100 |
|:-------------|:----:|:----:|:-----:|
| Casos que difieren, ¿ambos son MST válidos de igual peso? | 3/3 | 27/27 | 52/52 |
| Con **pesos sin empates**, ¿difieren? | **0/100** | **0/100** | **0/100** |

## 2. Tiempos de ejecución

| Vértices | Kruskal (ns) | Prim (ns) | Ganador |
|:--------:|:------------:|:---------:|:--------|
| 10       | 2 230        | 2 043     | empate  |
| 50       | 10 494       | 6 185     | **Prim** |
| 100      | 17 266       | 14 086    | **Prim**  |

En 50 y 100 vértices Prim es claramente más rápido (ganó en las 3 corridas). En 10 vértices no se
puede concluir nada: el ruido de la medición llega a ser del 54 %, mayor que la diferencia entre los
dos algoritmos.

Ambos algoritmos son `O(E log E)`, así que la diferencia es de constantes, no de complejidad.

## 3. Cómo se midió

`REPETICIONES = 20` en `MSTTimer` hace dos cosas:

- **20 ejecuciones sin cronometrar**, para que la JVM compile el código. Si no, se mediría el
  intérprete y no el algoritmo.
- **20 ejecuciones cronometradas quedándose con la más rápida**, no con el promedio, porque el
  garbage collector y el sistema operativo distorsionan la media.

Ambos algoritmos reciben el mismo trato: mismo grafo, mismas repeticiones, mismo criterio. Por eso
la comparación es válida.