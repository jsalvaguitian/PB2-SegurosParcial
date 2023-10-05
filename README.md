# Sistema Seguro

**Nos contratan para desarrollar un software que permita administrar los usuarios de un sistema de manera independiente al resto del sistema.**

------------

1. Los **usuarios** pueden ser de tipo **Básico o Administradores.**

2. Los **usuarios básicos** son **Bloqueables** y **Eliminables**.

3. Que un **usuario sea Bloqueable** quiere decir que se puede bloquear.***Esto sucede al hacer el login más de 3 veces con una contraseña incorrecta.***

4. Que un **usuario sea Eliminable** quiere decir que se puede eliminar. Sin embargo ***la eliminación será lógica a través de una marca en la base de datos*.**

5. Los objetos **usuarios no se pueden duplicar**, siendo su nombre de usuario la clave.

6. Los usuarios se* **encuentran ordenados*** a partir de su ***nombre*** de usuario.

7. Si se intenta loguear un usuario que no existe en la base de datos se debe producir la *Excepción unlam.pb2.UserNotFound.*

8. Si se intenta eliminar un usuario que no sea Eliminable se debe arrojar la excepción *java.lang.ClassCastException.*

9. Los ***requisitos de las contraseñas*** varían entre los usuarios Básicos y los usuarios Administradores.
   * 9.1 Los **usuarios básicos** deben tener contraseñas **que contengan al menos un número y una minúscula y una mayúscula**.
   * 9.2 Los **usuarios administradores** además de los requisitos de la contraseña de los usuarios básicos deben **tener un carácter especial y no puede tener secuencia de más de 3 caracteres seguidos** (123 y abc es válido, pero 1234 o abcd no). 

10. Intentar generar un usuario con una contraseña inválida debe arrojar la excepción *unlam.pb2.InvalidPassword*


