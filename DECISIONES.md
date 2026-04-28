# Documentación de Decisiones de Diseño

## Arquitectura

Se utilizó una **arquitectura en capas** (Model, Repository, Service y App) para separar responsabilidades. Esto permite mantener el código organizado y facilitar su mantenimiento y extensión.

## Modelado

Se definieron las entidades principales del sistema (`Libro`, `Usuario` y `Prestamo`).
Se aplicó **herencia y polimorfismo** para diferenciar tipos de usuarios y libros, permitiendo tratarlos de manera uniforme.

## Uso de Repository

Se implementó el patrón **Repository** para abstraer el acceso a datos.
Los datos se almacenan en memoria utilizando `Map`, lo cual simplifica la implementación sin depender de una base de datos.

## Lógica de Negocio

La lógica del sistema se centralizó en la capa **Service**, donde se validan reglas como:

* existencia de usuario y libro
* límite de préstamos

Esto evita mezclar lógica con la persistencia.

## Uso de Optional

Se utilizó `Optional` en las búsquedas para evitar valores `null` y forzar un manejo explícito de los casos donde no se encuentra información.

## Uso de Records

Se utilizaron **records** para representar entidades inmutables como los libros, reduciendo código repetitivo y mejorando la claridad.

## Interfaz

Se implementó una interfaz por consola (CLI) que permite interactuar con el sistema mediante un menú simple.

## Control de Versiones

Se utilizó Git trabajando con ramas por funcionalidad y realizando merges a la rama principal, manteniendo un flujo de trabajo ordenado.



