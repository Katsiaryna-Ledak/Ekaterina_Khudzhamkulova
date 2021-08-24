Feature: check of elements at Home Page and Different Elements Page
  Scenario: check elements at Home Page
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on 'Different Elements' subcategory in 'Service' button in Header menu
    When I select water checkbox
    Then I select wind checkbox
    Then I select selen radio button
    Then I select yellow color from dropdown list
    Then Log rows are displayed on Different Elements page

