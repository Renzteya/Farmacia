Sistema de Gestión para Farmacia - Proyecto Java MVC
Descripción
Este proyecto es una aplicación de escritorio desarrollada en Java para la gestión integral de una farmacia. Está construida siguiendo el patrón de arquitectura MVC (Modelo-Vista-Controlador) para mantener un código organizado y escalable. La interfaz gráfica utiliza Swing y la base de datos está gestionada con MySQL (XAMPP).

El sistema permite administrar compras, proveedores, productos, y usuarios con roles, ofreciendo funcionalidades para registrar compras, listar productos y controlar accesos según el rol del usuario.

Tecnologías y Herramientas
Lenguaje: Java SE

IDE: Apache NetBeans

Patrón de diseño: MVC (Modelo-Vista-Controlador)

Interfaz gráfica: Java Swing

Base de datos: MySQL (servidor local con XAMPP)

Conexión a BD: JDBC

Funcionalidades principales
Gestión de Compras: Registro de nuevas compras, cálculo de subtotales y totales, manejo de tablas temporales para detalle de compra.

Listado y Control de Compras: Visualización en tabla de todas las compras realizadas, con datos del proveedor, total y fecha.

Control de Usuarios y Roles: Diferenciación entre Administrador y Auxiliar con permisos para acceder a ciertos módulos.

Validaciones: Manejo de excepciones para evitar errores comunes (ej. campos vacíos, formato numérico).

Interfaz amigable: Navegación mediante pestañas y botones, con mensajes de alerta y confirmación.

Estructura del proyecto
Modelo: Clases que representan las entidades (Compra, Proveedor, Usuario) y acceso a datos (DAO) para conexión con la base.

Vista: Formularios y tablas creados con Swing para interacción con el usuario.

Controlador: Lógica para gestionar eventos, validar datos y comunicar modelo y vista.

Instalación y Configuración
Base de datos:

Instalar XAMPP (o cualquier servidor MySQL).

Crear la base de datos farmacia y las tablas necesarias (purchases, suppliers, users, etc.) según el script SQL del proyecto.

Configurar el usuario y contraseña en la clase conexión (DAO).

Proyecto Java:

Abrir el proyecto en Apache NetBeans.

Asegurarse de tener el driver JDBC de MySQL en la biblioteca del proyecto.

Compilar y ejecutar.

Ejecución:

Iniciar la aplicación.

Iniciar sesión con usuario y rol definidos.

Usar las pestañas para acceder a compras, reportes y otras funcionalidades.

Uso
Para registrar una compra:

Ingresar el proveedor, cantidad y precio unitario.

El sistema calcula automáticamente el subtotal.

Agregar productos a la tabla temporal.

Confirmar la compra para que se registre en la base de datos.

Para listar compras:

Acceder a la pestaña de reportes.

Visualizar las compras registradas en la tabla table_all_purchases.

Control de acceso:

Solo usuarios con rol "Administrador" pueden acceder a ciertas pestañas y funciones.

Manejo de errores y validaciones
Se manejan excepciones comunes como:

Campos vacíos.

Formatos incorrectos en números.

Intentos de acceso no autorizado.

Errores de conexión con la base de datos.

Las tablas temporales se limpian correctamente para evitar errores de índices o referencias nulas.

Mejoras futuras
Implementar autenticación segura con hash de contraseñas.

Mejorar la interfaz con validaciones en tiempo real.

Agregar reporte de ventas y gráficos.

Implementar soporte multiusuario con sesiones.
