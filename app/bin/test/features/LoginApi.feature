@Login @Proyecto
Feature: Login

    @LoginValido
    Scenario: logearme con credenciales validas
        Given envio una solicitud post a la https://api.demoblaze.com URI
        When ingreso los datos de UsuarioCreado en el endpoint /login
        Then verifico que en la respuesta llegue el token y un codigo 200

    @loginUsuarioIncorrecto
    Scenario: intentar loguearme con credenciales incorrectas (usario incorrecto)
        Given envio una solicitud post a la https://api.demoblaze.com URI
        When ingreso los datos de UsuarioIncorrecto en el endpoint /login
        Then verifico que llegue el mensaje User does not exist. y el status code 200

    @loginContrasenaIncorrecto
    Scenario: intentar loguearme con credenciales incorrectas (contrasena incorrecto)
        Given envio una solicitud post a la https://api.demoblaze.com URI
        When ingreso los datos de ContrasenaIncorrecto en el endpoint /login
        Then verifico que llegue el mensaje Wrong password. y el status code 200