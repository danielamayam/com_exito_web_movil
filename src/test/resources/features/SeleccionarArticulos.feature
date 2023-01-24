Feature: Seleccionar los articulos en la plataforma Exito
  Como usuario de la app Exito
  Quiero seleccionar mis articulos
  Para comprarlos

  Background:
    Given que el usuario quiere abrir la pagina del Exito

  @AgregaProduto
  Scenario Outline: Selección de artículos automáticamente
    When Selecciono los cinco productos
      | Categoria   | SubCategoria   | Segmento   |
      | <Categoria> | <SubCategoria> | <Segmento> |
    Then Válido los productos agregados
    Then Válido el número de productos en el carro

    Examples:
      | Categoria  | SubCategoria              | Segmento |
      | Tecnología | Computadores y accesorios | Computadores Gaming |