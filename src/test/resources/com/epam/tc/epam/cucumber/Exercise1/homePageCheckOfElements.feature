Feature: check of elements at Home Page and Different Elements Page

  Scenario: check elements at Home Page

    Given I open 'Index' page in JDI GitHub site
    And I login as user 'Roman Iovlev'

    When I click on 'Different Elements' subcategory in 'Service' button in Header menu
    And I select water checkbox
    And I select wind checkbox
    And I select selen radio button
    And I select yellow color from dropdown list

    Then Log rows are displayed on 'Different Elements' page

