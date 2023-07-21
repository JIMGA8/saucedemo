# Objetivo de este repositorio

## realizar el desafio de Prueba E2E Y API:

# prueba E2E:
Realizar una prueba funcional automatizada (Prueba E2E) de un flujo de compra en la página https://www.saucedemo.com/ 
  - **Autenticarse con el usuario: standard_user y password: secret_sauce
  - **Agregar dos productos al carrito
  - **isualizar el carrito
  - **Completar el formulario de compra
  - **Finalizar la compra hasta la confirmación: “THANK YOU FOR YOUR ORDER”

se creo aparte la funcionalidad de login y la misma es empleada como Background en la funcionalidad de la compra de un producto.

se creo un Helpers para convertir el String que se recibe desde productos a una lista y asi poder seleccionar cualquier producto que desea agregar al carrito

se creo un Helpers para eliminar los caracteres (menos numeros y punto) de los precios de los productos y asi poder verificar que la sumatoria de los productos agregados al carrito es igual al subtotal
  
# prueba Api
endpoint  https://api.demoblaze.com/signup
  - **Crear un nuevo usuario en signup
  - **Intentar crear un usuario ya existente

endpoint  https://api.demoblaze.com/login
  - **Usuario y password correcto en login
  - **Usuario y password incorrecto en login

se crearon 4 payloads (UsuarioNuevo, UsuarioCreado, UsuarioIncorrecto,ContraseñaIncorrecta) los cuales se emplean para la verificacion de los endpoint.

se creo un helpers para generar usuario aletario para que sea empleado en la creacion de un nuevo usuario y asi poder correr las pruebas las veces que se desee sin necesidad de modificar el payload Json UsuarioNuevo

## Este proyecto fue creado con:

- **Selenium WebDriver: para interactuar con WebElements en la página web. 
- **Java: Como lenguaje de programación. 
- **RestAssured: para las pruebas de Api
- **Cucumber: para escribir escenarios de prueba como funciones de desarrollo impulsado por el comportamiento y colaborar con los analistas comerciales. 
- **Informes de extensión: para generar informes HTML. 
- **Gradle: como herramienta de construcción. 

## Configuración

- **Instale JDK (última versión estable). 
- **Descarga los WebDrivers que usarás en tu proyecto. Si usa Windows, especifique la ruta al controlador en BasePage.java como System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); Si está en MacOS: Abra la Terminal Ejecute sudo nano /etc/paths Ingrese su contraseña Vaya al final del archivo e ingrese la ruta que desea agregar (Mi RUTA se parece a: /Users/myname/Documents/WebDriver) Control -x para salir Y para guardar Presione enter para confirmar Para verificar dos veces, salga de Terminal y reinícielo. Ejecute echo $PATH. Debería ver su ruta recién agregada en el flujo de otras rutas que ya están allí.
- **¡Finalmente, actualice sus pruebas para que se ejecuten con Chrome y ejecute sus pruebas! Instale el complemento Cucumber en el IDE de su elección. Cree el proyecto para descargar las dependencias especificadas en Gradle.build.

## POM

Modelo de objetos de página Este marco utiliza el modelo de objetos de página, con una página base que se encarga de crear la instancia del controlador y los métodos heredados para interactuar con los elementos web en las clases dentro del directorio de páginas.

Página base

BasePage.java es la clase donde viven el controlador y los métodos para interactuar con las páginas web. La espera se establece una vez aquí y se usa de forma inteligente, procediendo con las acciones en caso de que se encuentre el elemento y esperando hasta el umbral establecido en esta clase.

## Ejecución de las pruebas 
Para ejecutar las pruebas, tiene dos opciones:
- **Ejecutando desde un Runner.java, especificando qué etiqueta ejecutar (usted configura las etiquetas en los Escenarios).
- **Ejecutando desde la línea de comando y usando: gradle test -Dcucumber.options="--tags @CucumberTag" Observe que la tarea "test" se crea en el archivo Gradle.Build.

- **para ejecutar la prueba de E2E para comprar Productos utilice el tag @ComprarProducto
- **para ejecutar la prueba de API de Sign Up utilice el tag @SignUp 
- **para ejecutar la prueba de API de Login utilice el tag @Login
- **para ejecutar todo el proyecto utilice el tag @Proyecto

## Informes

Una vez ejecutado, encontrará los informes dentro del directorio Test-output, que contiene un archivo HTML que puede abrir con cualquier navegador y acceder al informe con los resultados.
tambien obtendrá una url en la terminal con el informe generado (se autodestruye en 24 hs).
