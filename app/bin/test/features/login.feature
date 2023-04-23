@loginsaucedemo
Feature: login

    Scenario: realizar el login con usuario y contrasena valida
        Given navego a la pagina de saucedemo
        When ingreso mi usuario standard_user y contrasena secret_sauce
        Then valido el inicio de seccion
