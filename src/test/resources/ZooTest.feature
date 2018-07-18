Feature: To test the high level functionality of the zoo site

  Scenario: To populate the contact form

      Given I am on the zoo site
      When I click on "contact_link"
      And I enter "Name test" into the name field
      And I enter "Address test" into the address field
      And I enter "Postcode test" into the postcode field
      And I enter "Email test" into the email field
      And I submit the contact form
      Then I check I am on the confirmation page
      And I close the browser

