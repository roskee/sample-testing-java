Feature: Login

Scenario: Successful login
	Given I enter "standard_user" as username
    And I enter "secret_sauce" as password
	When I click the login button
	Then I should see the homepage

Scenario: Failed login
	Given I enter "invalid_username" as username
    And I enter "secret_sauce" as password
	When I click the login button
	Then I should see the error "Epic sadface: Username and password do not match any user in this service"