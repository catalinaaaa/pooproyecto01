create database pooproyecto01

use pooproyecto01

create table administrador(
identificador int primary key not null,
nombre varchar(70) not null, 
contrasenia varchar(70) not null,
correoElectronico varchar(70) not null,
nombreUsuario varchar(70) not null,
)

create table categoria(
codigo int primary key identity (1,1) not null,
nombreCategoria varchar(50) not null,
descripcion varchar(50) not null,
estado int foreign key references categoria_estado(id_estado) not null
)

create table categoria_estado(
id_estado int primary key not null,
descripcion_estado varchar(20) not null
)

create table cliente(
numeroCedula int primary key not null,
nombre varchar(70) not null, 
contrasenia varchar(70) not null,
correoElectronico varchar(70) not null,
nombreUsuario varchar(70) not null,
provincia varchar(70) not null, 
canton varchar(70) not null,
distrito varchar(70) not null,
senias varchar(70) not null,
telefono int not null,
ubicacion varchar(1000) not null
)

create table pedido(
identificador int primary key not null,
idProveedor int not null foreign key references proveedor(numeroCedula),
estado int foreign key references pedido_estado(id_estado) not null,
fecha date not null,
fechaEntrega date not null,
idCategoria int not null,
idDuenio int not null,
montoTotal decimal not null,
idProducto int foreign key references producto(identificador),
idServicio int foreign key references servicio(identificador)
)

create table pedido_estado(
id_estado int primary key not null,
descripcion_estado varchar(20) not null
)

create table usuario(
tipo int foreign key references usuario_tipo(id_tipo) not null,
nombre varchar(100) not null,
contrasenia varchar(100) not null,
correoElectronico varchar(100) not null,
nombreUsuario varchar(100) not null
)

create table usuario_tipo(
id_tipo int identity(1,1) primary key not null,
descripcion varchar(20) not null)

create table proveedor(
numeroCedula int primary key not null,
nombre varchar(70) not null, 
contrasenia varchar(70) not null,
correoElectronico varchar(70) not null,
nombreUsuario varchar(70) not null,
provincia varchar(70) not null, 
canton varchar(70) not null,
distrito varchar(70) not null,
senias varchar(70) not null,
telefono int not null,
sitioWeb varchar(50) not null,
horarioAtencion varchar(50) not null,
ubicacion varchar(50) not null,
redesSociales varchar(50) not null,
calificacion int not null,
tipo_proveedor int not null
)

create table proveedor_tipo(
identificador int identity(1,1) primary key not null,
detalle varchar(20) not null
)

create table producto(
identificador int identity(1,1) primary key not null,
idProducto varchar(20) unique not null, 
nombre varchar(50) not null, 
descripcion varchar(50) not null, 
tipo varchar(50) not null, 
idCategoria int foreign key references categoria(codigo) not null,
cantidad int not null,
costoUnitario decimal not null,
costoEntrega decimal,
fotografia varbinary(1000),
estado int foreign key references productoEstado(idEstado) not null,
idProveedor int foreign key references proveedor(numeroCedula) not null
)

create table productoEstado(
idEstado int identity(1,1) primary key not null,
descripcion varchar(20) not null
)

create table servicio(
identificador int identity(1,1) primary key not null,
idServicio varchar(20) unique not null, 
nombre varchar(50) not null, 
descripcion varchar(50) not null, 
tipo varchar(50) not null, 
idCategoria int foreign key references categoria(codigo),
costo decimal not null,
costoEntrega decimal not null,
fotografia varbinary(1000)
)