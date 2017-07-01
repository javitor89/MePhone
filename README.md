# MePhone



# Descripción de la temática de la web

Nuestra aplicación web consiste en el desarrollo de una plataforma de venta de teléfonos móviles a nivel nacional. 
Cuenta con todas las gamas de producto de telefonía del mercado, así como secciones de ofertas puntuales, descuentos y promociones.

# Las funcionalidades públicas:

La consulta de todos los  terminales y precios que  tenemos a la venta, ofertas, promociones.
Para realizar compras y pedidos es necesario el registro y posterior login en la web.

# Las funcionalidades privadas:

El acceso a toda la parte de administración de la cuenta de usuario, gestión de un pedido, seguimiento, datos personales, de entrega, etc.

# Entidades principales:

Usuario: Navegación por nuestros diferentes terminales de venta y seguimiento o compra de producto en la web .

Producto: En nuestro caso los teléfonos móviles que ponemos a la venta en la web.

Carrito: Donde los usuarios pueden ir agregando productos para posteriormente comprar.

Pedido: Información de los móviles comprados por el cliente.

imagen: imagen del teléfono móvil

# Servicios internos:

Generacion y envío de facturas: Todos los pedidos realizados se completaran con el envío de la factura correspondiente al correo proporcionado por el cliente.

#  Integrantes del equipo de desarrollo:

Javier Millán Campiña  -- correo: j.mollan@alumnos.urjc.es -- cuenta GitHub: javitor89

Diego Herradon Lizana -- correo: d.herradon@alumnos.urjc.es -- cuenta GitHub: DiegoHL

#  Navegacion y descripcion de la web:

* Página Principal:
Mostraremos la web con su barra de búsqueda, la sección para logearse o crear una nueva cuenta de usuario.
Una zona de accesos directos a otras partes de la web para mejorar la experiencia de navegación al usuario.
Una zona central con las ofertas más destacadas de los productos de la web.
![paginaprincipal](https://github.com/javitor89/MePhone/blob/master/capturas/Principal.JPG)

* Zona registro:
Nos podemos registrar en la página web.
![registro](https://github.com/javitor89/MePhone/blob/master/capturas/Registro.JPG)

* Login:
Nos podemos logear en la web.
![ventanalogin](https://github.com/javitor89/MePhone/blob/master/capturas/login.JPG)

* Sesión o cerrar mi sesión:
Tener la sesión o cerrarla en cualquier momento.
![logeado](https://github.com/javitor89/MePhone/blob/master/capturas/Logeado.JPG)

* Barra de búsqueda:
Utilizar nuestra zona de búsqueda flotante para consultar cualquier artículo que tengamos en venta en la web.
![barradebusqueda](https://github.com/javitor89/MePhone/blob/master/capturas/Barra%20de%20busqueda.JPG)

* Ofertas:
Sección con las ofertas que tenemos en estos momentos.
![ofertas](https://github.com/javitor89/MePhone/blob/master/capturas/ofertas.JPG)

* Contacto:
Una parte para contactar con los administradores de la tienda.
![contacto](https://github.com/javitor89/MePhone/blob/master/capturas/Contacto.JPG)

#  Diagrama de clases:
![uml](https://github.com/javitor89/MePhone/blob/master/capturas/UML1.JPG) 

#  Diagrama ER:
![uml](https://github.com/javitor89/MePhone/blob/master/capturas/ER.jpg) 

#  Comandos utilizados para la configuración de azure y las máquinas virtuales:

* Entrar a la maquina
                           
ServInterno1: ssh -i azureus.key -p 52002 azureuser@40.69.37.9
ServInterno2: ssh -i azureus.key -p 50845 azureuser@40.69.37.9
ServBD1: ssh -i azureus.key -p 51285 azureuser@40.69.37.9
ServBD2: ssh -i azureus.key -p 55517 azureuser@40.69.37.9
ServWeb1: ssh -i azureus.key -p 58485 azureuser@40.69.37.9
ServWeb2: ssh -i azureus.key -p 55215 azureuser@40.69.37.9
ServBalance: ssh -i azureus.key -p 55466 azureuser@40.69.37.9
------
ssh -o IdentitiesOnly=true -i azureus.key azureuser@13.79.236.229


###Instalar jar###
ServWeb1: scp -i azureus.key -P 58485 MePhone-0.0.1-SNAPSHOT.jar azureuser@40.69.37.9:/home/azureuser/MePhone-0.0.1-SNAPSHOT.jar
ServWeb2: scp -i azureus.key -P 55215 MePhone-0.0.1-SNAPSHOT.jar azureuser@40.69.37.9:/home/azureuser/MePhone-0.0.1-SNAPSHOT.jar
ServInterno: scp -i azureus.key -P 52002 MailMailMail90-0.0.1-SNAPSHOT.jar azureuser@40.69.37.9:/home/azureuser/MailMailMail90-0.0.1-SNAPSHOT.jar
ServInterno: scp -i azureus.key -P 50845 MailMailMail91-0.0.1-SNAPSHOT.jar azureuser@40.69.37.9:/home/azureuser/MailMailMail91-0.0.1-SNAPSHOT.jar


###Ejecutar jar### 
ServWeb1: java -jar MePhone-0.0.1-SNAPSHOT.jar --server.address="100.87.186.45" --server.port="8443" --spring.datasource.url="jdbc:mysql://100.87.184.124:3306/mp1" --spring.datasource.username="user1" --spring.datasource.password="user1"
ServWeb2: java -jar MePhone-0.0.1-SNAPSHOT.jar --server.address="100.87.192.32" --server.port="8443" --spring.datasource.url="jdbc:mysql://100.87.184.124:3306/mp1" --spring.datasource.username="user1" --spring.datasource.password="user1"
ServExterno1: java -jar MailMailMail90-0.0.1-SNAPSHOT.jar
ServExterno2: java -jar MailMailMail91-0.0.1-SNAPSHOT.jar
------


###Instalar Mysql###
sudo su -
apt-get update
apt-get -y install mysql-server-5.6


###Configurar bind-address de mysql###
sudo pico /etc/mysql/my.cnf
poner la ip 
control O
control X
sudo service mysql restart


###Configurar la BD###
mysql -u root -p
------
create user 'user1'@'%' identified by 'user1';
create database mp1;
grant all privileges on mp1.* to 'user1'@'%';
flush privileges;
------
show databases;
use [database name];
show tables;
SELECT * from usuario;


###Instalar balanceador### 
sudo apt-get update
sudo apt-get -y install haproxy
sudo pico /etc/default/haproxy
Cambiar ENABLED=0 a ENABLED=1
sudo service haproxy start


###Configurar balanceador### 
sudo pico /etc/haproxy/haproxy.cfg
sudo service haproxy start
service haproxy restart


#  Forma de acceso a la web:

https://dadjunio.cloudapp.net/
