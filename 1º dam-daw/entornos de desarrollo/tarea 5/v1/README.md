# Tarea 5 entornos de desarrollo

Youtube: https://youtu.be/z-Np_gyq13M

Si te ha servido este repositorio, no te olvides de darle una estrella.

## Enunciado

Descripción exacta del problema: “El tacón de oro”

Los usuarios del sistema navegan por la web para ver los artículos, zapatos, bolsos y complementos que se venden en la tienda. De los artículos nos interesa su nombre, descripción, material, color, precio y stock. De los zapatos nos interesa su número y el tipo. De los bolsos nos interesa su tipo (bandolera, mochila, fiesta). De los complementos (cinturones y guantes) su talla. 

Los artículos se organizan por campañas para cada temporada (primavera/verano y otoño/invierno) de cada año. Los artículos son de fabricación propia, pero, opcionalmente, pueden venderse artículos de otras firmas. De las firmas nos interesa saber su nombre, CIF y domicilio fiscal. La venta de artículos de firma se realiza a través de proveedores, de forma que un proveedor puede llevar varios artículos de diferentes firmas, y una firma puede ser suministrada por más de un proveedor. Los artículos pertenecen a una firma solamente. De los proveedores debemos conocer su nombre, CIF, y domicilio fiscal. 

Los usuarios pueden registrarse en el sitio web para hacerse socios. Cuando un usuario se hace socio debe proporcionar los siguiente datos: nombre completo, correo electrónico y dirección. Los socios pueden hacer pedidos de los artículos. 

Un pedido está formado por un conjunto de detalles de pedido que son parejas formadas por artículo y la cantidad. De los pedidos interesa saber la fecha en la que se realizó y cuanto debe pagar el socio en total. El pago se hace a través tarjeta bancaria, cuando se va a pagar una entidad bancaria comprueba la validez de la tarjeta. De la tarjeta interesa conocer el número. 

Las campañas son gestionadas por el administrativo de la tienda que se encargará de dar de baja la campaña anterior y dar de alta la nueva siempre que no haya ningún pedido pendiente de cumplimentar. 

Existe un empleado de almacén que revisa los pedidos a diario y los cumplimenta. Esto consiste en recopilar los artículos que aparecen en el pedido y empaquetarlos. Cuando el paquete está listo se pasa al almacén a la espera de ser repartido. Del reparto se encarga una empresa de transportes que tiene varias rutas preestablecidas. Según el destino del paquete (la dirección del socio) se asigna a una u otra ruta. De la empresa de transportes se debe conocer su nombre, CIF y domicilio fiscal. Las rutas tienen un área de influencia que determina los destinos, y unos días de reparto asignados. Se debe conocer la fecha en la que se reparte el pedido. Si se produce alguna incidencia durante el reparto de algún pedido se almacena la fecha en la que se ha producido y una descripción. 

Los socios pueden visualizar sus pedidos y cancelarlos siempre y cuando no hayan sido cumplimentados por el empleado de almacén. Así mismo puede modificar sus datos personales. 

Acrónimo: Código de Identificación Fiscal 

Tu tarea consiste en elaborar el diagrama de clases y la documentación para el análisis de una aplicación que implemente la venta por internet de la zapatería con la aplicación Visual Paradigm. Debido a las restricciones de la aplicación con el tiempo de evaluación, no es obligatorio generar el código de la aplicación, pero si debes importar el proyecto creado VP-UML en un proyecto de NetBeans. Para documentar el proceso deberás entregar un documento de texto con los siguientes puntos:

• Extracción de los sustantivos en la descripción del problema.

• Selección de sustantivos como objetos/clases del sistema.

• Obtención de los atributos de los objetos.

• Obtención de los métodos.

• Obtención de las relaciones.

• Añadir getters, setters y constructores.

• Primer refinamiento.

• Documentación.
