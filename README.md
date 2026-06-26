# 💱 Money Calculator

Aplicación en Java para conversión de divisas en tiempo real, siguiendo el patrón de arquitectura MVC (Model-View-Controller) y usando Command Pattern para encapsular la lógica de conversión.

Permite seleccionar dos monedas, introducir un importe y obtener el resultado usando una API externa de tipos de cambio.

---

## 📁 Estructura del proyecto

```text
src/main/java
    ├── app/
    │      └── Main.java
    │
    ├── io/
    │     ├── CurrencyLoader.java
    │     └── ExchangeRateLoader.java
    │
    ├── model/
    │     ├── Currency.java
    │     ├── ExchangeRate.java
    │     └── Money.java
    │
    ├── control/
    │     ├── Command.java
    │     ├── Conversion.java
    │     ├── MoneyCalculatorCommand.java
    │     └── MoneyCalculatorController.java
    │
    └── view/
          ├── dialog/
          │     ├── CurrencyDialog.java
          │     └── MoneyDialog.java
          │
          ├── display/
          │     └── ResultDisplay.java
          │
          └── MoneyCalculatorView.java

```


---

## 🏛️ Arquitectura MVC + Command Pattern

Este proyecto sigue el patrón **Model-View-Controller**, con uso de **Command Pattern** para encapsular la lógica de conversión.

En una arquitectura sin separación de capas, la UI mezcla lógica de negocio con componentes visuales, lo que hace el código difícil de testear y mantener.

Con MVC:

- **Model** → datos del dominio (Currency, ExchangeRate)
- **View** → solo interfaz gráfica (Swing), sin lógica de negocio
- **Controller** → coordina flujo, valida input y ejecuta la lógica
- **IO** → acceso a API externa (HTTP)
- **Command** → encapsula la operación de conversión

---

## 📦 Descripción de cada clase

### app/Main.java
Punto de entrada. Inyecta dependencias (loaders + controller + view) y arranca la aplicación.

---

### model/Money.java
Representa una cantidad de dinero.

---

### model/Currency.java
Representa una moneda con su código y nombre.

---

### model/ExchangeRate.java
Representa la tasa de cambio entre dos monedas.

---

### control/Conversion.java
Resultado de la operación:

- success → si la operación fue correcta
- value → resultado numérico
- error → mensaje de error

---

### control/Command.java
Interfaz del patrón Command:

---

### control/MoneyCalculatorCommand.java

Encapsula la lógica de conversión:

- se inyectan las dependencias que necesita   
- calcula resultado  
- devuelve Conversion  

---

### control/MoneyCalculatorController.java

Orquesta el flujo de la aplicación:

- valida input  
- convierte String → double  
- crea y ejecuta Command  
- devuelve Conversion  

---

### io/CurrencyLoader.java

Carga las monedas disponibles desde una API externa.

---

### io/ExchangeRateLoader.java

Obtiene el tipo de cambio entre dos monedas desde una API externa.

---

### view/MoneyCalculatorView.java

Ventana principal Swing:

- recoge input del usuario  
- llama al Controller  
- muestra resultado o error  

---

### view/dialog/CurrencyDialog.java

Selector de moneda origen/destino.

---

### view/dialog/MoneyDialog.java

Campo de entrada de importe.

---

### view/display/ResultDisplay.java

Muestra el resultado o errores.

---

## ✨ Funcionalidades

- Conversión de divisas en tiempo real  
- Selección de moneda origen y destino  
- Validación de input y gestión de errores
- Arquitectura MVC limpia  
- Uso de Command Pattern  

---

## 🧪 Tests

El proyecto está diseñado para ser fácilmente testeable gracias a la separación en capas.

---

## 📌 Limitaciones por diseño

- No hay caché de tipos de cambio  
- Cada conversión llama a la API  
- No hay modo offline  
- No hay historial de conversiones  

