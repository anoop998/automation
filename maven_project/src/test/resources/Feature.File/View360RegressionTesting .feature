@smoke
Feature: Login functionality

  Scenario Outline: Test Login functionality with multiple Scenario
    Given navigate to the login url
    When i enter <email> and <password>
    And click on the show hide password
    And click on the Remember me
    And click on the login button
    Then user should redirect to the dashbard page

    Examples: 
      | email              | password       |
      | anoop              | anoop12        |
      |                    |                |
      |                    | admin123       |
      | admin@epikso.com   |                |
      | admin12@epikso.com | 5P$nb;qnO5*H   |
      | admin@epikso.com   | 5P$nb;qnO665*H |
      | admin@epikso.com   | 5P$nb;qnO5*H   |
      | ADMIN@EPIKSO.COM   | 5P$nb;qnO5*H   |

  