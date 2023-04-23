@loginsaucedemo
Feature: login

Scenario: realziar el login con usuario y contraseña valida
    Given navego a la pagina de saucedemo
    When ingreso mi usuario standard_user y contraseña secret_sauce
    Then valido el inicio de seccion
