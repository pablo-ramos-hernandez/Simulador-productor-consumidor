## Simulador-producto-consumidor

Una empresa de alimentación nos ha contactado para desarrollar una aplicación que simule la realidad de granjeros. Los granjeros tienen un huerto local en el que pueden plantar distintos tipos de verduras para su venta a clientes en un restaurante vegano.
Para ello, será necesaria la implementación de una clase hilo que actúe como consumidor y otra que haga de productor. Estos hilos deben acceder a un recurso compartido en el que depositar o recoger los productos elaborados teniendo en cuenta que estas acciones son secciones críticas.

## Estructura de carpetas

Se basa en 4 carpetas:

- `src`: la carpeta donde contiene todas las clases
- `cliente`: la carpeta donde contiene la clase Cliente
- `granjero`: la carpeta donde contiene la clase Granjero
- `huerto`: la carpeta donde contiene la clase Huerto
