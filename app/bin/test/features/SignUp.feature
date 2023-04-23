@SignUp @Proyecto
Feature: Crear un nuevo usuario en Signup

    @UsuarioNuevo
    Scenario: Crear un nuevo usuario exitosamente
        Given envio una solicitud post a la https://api.demoblaze.com URI
        When ingreso los datos de UsuarioNuevo en el endpoint /signup
        Then verifico que en la respuesta llegue un codigo 200

    @UsuarioCreado
    Scenario: intentar crear un usuario existente
        Given envio una solicitud post a la https://api.demoblaze.com URI
        When ingreso los datos de UsuarioCreado en el endpoint /signup
        Then verifico que llegue el mensaje This user already exist. y el status code 200