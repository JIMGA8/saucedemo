@ComprarProducto
Feature: comprar un producto

    el siguiente Feature tiene como finalidad agregar uno o varios productos al carrito de compra, llenar el formulario de compra y fanilizar la compra

    Background: login
        Given navego a la pagina de saucedemo
        When ingreso mi usuario standard_user y contraseña secret_sauce
        Then valido el inicio de seccion

    Scenario: Agregar productos al carrito, completar formulario de compra y finalizar la compra
        When agrego los productos <productos> al carrito de compra
        Then ingreso al carro de compra y valido que se encuentran los productos agregados
        And completo el formulario de compra con el nombre <nombre>, apellido <apellido> y codipo postal <codigoPostal>
        Then verifico los productos a comprar y que el monto total corresponda con los productos agregados
        Then finalizo la compra y valido el mensaje Thank you for your order!

        # para agregar los productos al carrito dede colocar nombreProducto, nombreProdcto
        Examples:
            | productos                                                   | nombre | apellido | codigoPostal |
            | Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt (Red) | Jim    | Gavidia  | CA1088       |

#los nombre de los productos de la pagina son los siguientes:
# Sauce Labs Backpack, Sauce Labs Bike Light, Sauce Labs Bolt T-Shirt, Sauce Labs Fleece Jacket, Sauce Labs Onesie, Test.allTheThings() T-Shirt (Red)