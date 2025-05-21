
# Desafío 1: Automatización de Prueba con Selenium y Cucumber

## Descripción del Proyecto
Este proyecto consiste en la automatización de un escenario end-to-end en el sitio web de Amazon. El flujo automatizado simula a un usuario que busca un producto, navega a una página específica de resultados y agrega un artículo al carrito de compras.

La automatización fue desarrollada utilizando **Selenium WebDriver** y **Cucumber**, siguiendo buenas prácticas de automatización y desarrollo basado en comportamiento (BDD).

---

### ¿Qué es Selenium WebDriver?
[Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/) permite automatizar la interacción con navegadores web. Es ampliamente utilizado para pruebas de aplicaciones web, permitiendo simular acciones reales de un usuario como clics, escritura de texto, navegación, etc.

---

### ¿Qué es Cucumber?
[Cucumber](https://cucumber.io/docs) es una herramienta de BDD que permite escribir pruebas en lenguaje natural (Gherkin). Esto facilita la colaboración entre perfiles técnicos y no técnicos al describir escenarios de prueba de forma entendible.

---

### ¿Qué es Gradle?
[Gradle](https://gradle.org/) es una herramienta de automatización de compilaciones que gestiona las dependencias, facilita la ejecución del proyecto y su mantenimiento.

---

### ¿Qué es una dependencia?
Las dependencias son librerías externas que permiten añadir funcionalidades ya desarrolladas y probadas. Estas se gestionan a través de Gradle y se obtienen desde repositorios como [MVN Repository](https://mvnrepository.com/).

---

## Requisitos Previos

- **Java JDK 24**
- **Gradle**
- **VS Code** (u otro IDE compatible)

---

## Instalación de Herramientas

### Java JDK
1. Descargar desde [Oracle](https://www.oracle.com/co/java/technologies/downloads/).
2. Instalar versión LTS (recomendada: JDK 24).
3. Verificar instalación:
   ```
   java --version
   ```

### Gradle
1. Descargar desde [gradle.org](https://gradle.org/install/).
2. Verificar instalación:
   ```
   gradle --version
   ```

---

### Extensiones recomendadas en VS Code

- Extension Pack for Java  
- Gradle for Java  
- Gradle Language Support  
- Cucumber  
- Snippets and Syntax Highlight for Gherkin

---

## Dependencias utilizadas (en `build.gradle`)

- **Selenium Java**: 4.21.0  
- **TestNG**: 7.11.0  
- **Cucumber JVM: Java**: 7.22.0  
- **Cucumber JVM: JUnit 4**: 7.22.0  
- **WebDriverManager** (Bonigarcia): 5.7.0  

---

## Consideraciones con Captcha

Amazon presenta un captcha en ocasiones. Se implementó una espera de 15 segundos para resolverlo manualmente. Si no se resuelve, la prueba fallará.

```java
public void espera() {
    try {
        Thread.sleep(15000); // espera para resolver captcha
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

---

## Estructura del Proyecto

```
RETO_AMAZON/
├── src/
│   └── test/
│       └── java/
│           ├── pages/
│           │   ├── AmazonSearchPage.java
│           │   └── BasePage.java
│           ├── runner/
│           │   └── RunnerJava.java
│           └── steps/
│               ├── AmazonSearchSteps.java
│               └── Hooks.java
│
│       └── resources/
│           ├── AmazonSearch.feature
│           └── cucumber.properties
│
├── gradle/
├── .gitignore
├── build.gradle
├── gradlew / gradlew.bat
├── settings.gradle
└── README.md
```

---

## Ejecución de Pruebas

Desde la terminal (en la raíz del proyecto), ejecutar:

```
gradle test
```

---

## Reportes

Para subir los reportes a [Cucumber Reports](https://reports.cucumber.io):

1. Iniciar sesión con GitHub.
2. Crear un proyecto para obtener el token:  
   `CUCUMBER_PUBLISH_TOKEN=your-token`
3. Ejecutar en terminal:
   ```
   export CUCUMBER_PUBLISH_TOKEN=your-token
   gradle test
   ```

---

## Ejemplos de Reportes (coloca los tuyos aquí)

- ✅ **Todos exitosos**: https://reports.cucumber.io/reports/e8739cc9-ad9c-49c2-b5d5-e886a7250972
- ⚠️ **Un escenario fallido**: https://reports.cucumber.io/reports/e8739cc9-ad9c-49c2-b5d5-e886a7250972
- ❌ **Todos fallidos**: https://reports.cucumber.io/reports/e8739cc9-ad9c-49c2-b5d5-e886a7250972
