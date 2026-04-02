# gestion-franquicias
Este proyecto tiene como finalidad gestionar las franquicias, sus sucursales y productos que tienen en stock.
Esto fue hecho en java 21 con spring boot 4.0.5 sigue una Arquitectura por Capas, lo que facilita el mantenimiento y la escalabilidad, respetando los principios de la Programación Orientada a Objetos (POO), con gestor de dependencias con Maven tiendo como motor de base de datos MySQL gestionado en la nube mediante AWS RDS y todo el proyecto desplegado en el servicio de la nube de Google Cloud Platform(GCP).

Esquema entidad-Relacion:
FRANQUICIA (id_franquicia, nombre)--1-N--SUCURSAL (id_sucursal, nombre, id_franquicia)--1-N--PRODUCTO (id_producto, nombre, stock, id_sucursal)

El endpoint para consumir los servicios es: https://gestiondefranquicias-1018730821556.northamerica-south1.run.app

Algunos de los servicios son:
agregar franquicia: /app-franquicias/api/v1/nueva-franquicia (POST)
ingresando en body: 
{
    "nombreFranquicia":"McDonals"
}

agregar producto: /app-franquicias/api/v1/nuevo-producto (POST)
ingresando en body:
{
    "nombreProducto": "kilos de lechuga",
    "cantidadStock": 1,
    "nombreSucursal":"bellocol",
    "nombreFranquicia": "McDonals"
}

Por ultimo, si desea usar el proyecto en local debe:
1. De clonar el codigo en su maquina local
comando: git clone https://github.com/tu-usuario/gestion-franquicias.git

2. Poner yml tu url, usuario y contraseño de tu base de datos personal para conectarse con una BD MySQL, que tenga las tablas creadas como las entidades del codigo.
