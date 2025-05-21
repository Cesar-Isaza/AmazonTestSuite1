@Amazon
Feature: Validación de búsqueda y compra en Amazon

  Como usuario del sitio de Amazon, quiero realizar búsquedas de productos
  y verificar que puedo seleccionar uno y agregarlo exitosamente al carrito de compras.

  @Carrito
  Scenario Outline: Buscar un producto y agregar el tercer resultado de la segunda página al carrito
    Given el usuario accede al sitio de Amazon
    And realiza la búsqueda del producto <Producto>
    And accede a la segunda página de resultados
    And elige el tercer artículo listado
    Then el usuario puede añadir el artículo al carrito

    Examples:
      | Producto |
      | Alexa    |
      | Xbox     |