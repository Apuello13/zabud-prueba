Desarrollador: Andrés Felipe Puello Osorio
Empresa: Zabud
Entrevistador: Juan Esteban Angulo Uribe

Las tecnologías usadas en el desarrollo de este proyecto son:

Frontend: Angular 12.1.0
Backend: Spring Boot 2.5.7
Base de datos: postgres

Pasos para correr el frontend
1) npm i o npn install en la raiz del proyecto para instalar todas las dependencias necesarias (debe tener instalado NodeJS)
2) ng s o ng serve para levantar el servidor de desarrollo
3) Ingrese desde su navegador de preferencia a http://localhost:4200

La funcionalidad básica del proyecto cuenta de unos servicios REST creados con Spring Boot, apoyandonos de Hibernate y
usando al máximo todas sus funcionalidades como Jpa para la creación de persistencias y relaciones foraneas entre las entidades
la base de datos que use para persistir mi información fue PostgreSQL.
La estrcutura que utitlice para modelar mi proyecto backend es una arquitectura de capas, entre las cuales tengo;
Service, Repositorios, DTO, Domain, Controller, Mappers
Y en el frontend use la aquitectura recomendada por Google (core, shared y features) en la cual mi feature es mi modulo "page",
hago uso de guards para proteger mis rutas contra usuarios que no estén registrados en el sistema y vistas anidadas
para crear mi layout principal.


Recursos:

Para la creación de la base de datos usada en este proyecto:
CREATE DATABASE zabud
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

