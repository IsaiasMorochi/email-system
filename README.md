
# Email System

Se desea construir un Email System tomando en cuenta los siguientes requerimientos:


### MESSAGE:
Crear y enviar mensajes a uno o multiples Emails.
Un mensaje se compone de: cabecera (con los campos From, Sent, To, Subject y CC (opcional)) y un cuerpo (Firma (opcional) y texto (vacio por defectol) ).
Adicionalmente pueden agregarse uno o mas attachments los cuales deben debidamente codificados (UTF, Base64, etc) para su transmisión por la red. Para la recepción se deberá considerar el mecanismo inverso (decodificacion).


### DIRECTORY:
Organizar los mensajes en una jerarquía de directorios (CRUD). Los directorios contienen otros directorios y/o mensajes.
Existe un conjunto de direcotiors especiales que solo contienen mensajes: Inbox, Sent, Draft, Trash.
Por defecto los mensajes que recibidos son almacenados en el directorio Inbox.
Por defecto los mensajes enviados son almacenados en el directorio Sent.
Es posible mover mensajes entre directorios, asi mismo podrian moverse directorios entre directorios.


### SEARCH:
El usuario deberia ser capaz de realizar la busqueda de mensajes en cualquier directorio.
La busqueda puede realizarse tanto por texto como por expresiones logicas.
Los operadores soportados para las expresiones logicas seran (NOT, OR, AND).
Ejemplo de expresion logica:
(From.equals("myemail@gmail.com") AND Subject.contains(”Tesis”))
(From.equals("myemail@gmail.com") AND NOT (Subject.contains(”Tesis”) OR Subject.contains(”Avance”) )