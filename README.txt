Desarrollador: Andrés Felipe Puello Osorio
Empresa: Zabud
Entrevistador: Juan Esteban Angulo Uribe

Las tecnologías usadas en el desarrollo de este proyecto son:

Frontend: Angular 12.1.0
Backend: Spring Boot 2.5.7
Base de datos: postgres

1) Arquitectura

-Backend: Arquitectura de capas, entre las cuales use;
Service, Repositorios, DTO, Domain, Controller, Mappers
-Frontend: Aquitectura recomendada por Google (core, shared y features) en la cual mi feature es mi modulo "page",
hago uso de guards para proteger mis rutas contra usuarios que no estén registrados en el sistema y vistas anidadas
para crear mi layout principal.

2) Requisitos

-Sitema Operativo: Cualquiera, puede ser Linux, Windows.
-NodeJS: Tener instalado en su computador para descargar las dependencias que necesite el prouecto
-Base de datos: PostgresSQL, motor de búsqueda con el que se conecta la base de datos.
--Nota: Al final de documento se encuentra un script con la base de datos
Pasos para correr el frontend
1) npm i o npn install en la raiz del proyecto para instalar todas las dependencias necesarias (debe tener instalado NodeJS)
2) ng s o ng serve para levantar el servidor de desarrollo
3) Ingrese desde su navegador de preferencia a http://localhost:4200


3) Descripción

El siguiente proyecto consta de 4 cruds creados con AngularJs y apoyados con un servicio REST creado con Spring, la tematica que se escogió
fue la de crear una factura, el proyecto cuenta con un inicio de sesión para los cajeros y de un registro para estos mismos.

4) Mejoras

1- Mostrar la información de una factura en un reporte o tiket de factura para mostrarlo al cliente en formato PDF.
2- Implementar JWT para incorporar usuarios nuevos como el administrador.


Recursos:

Para la creación de la base de datos usada en este proyecto:
CREATE DATABASE zabud
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

