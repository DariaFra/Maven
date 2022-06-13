Feature: Добавление в избранное

  Background:
    Given User is logged in

    @hooks
      @close
  Scenario Outline:
    When Click to button in women
    And Select size '<size>'
    And choose blouse
    And Add to wishList
    Then blouse added to wishList
    Examples:
      | size |
      | S    |
      | M    |

