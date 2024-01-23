Feature: Testing RequestBook Functionality

  Scenario: To test Request a Book in BooksWagon Website
    Given the URL of website
    Then click on my account
    When the User enter email as '<EmailId>' on the login page
    When the User enter password as '<password>' on the login page
    And the User clicks on the login button on the page
    When The user clicks on Request a book Page
    Then enter the required data iSBN as '<isbn>' Title as '<BookTitle>' Author as '<authorName>'  Phone as '<Phno>'
    And Click the submit button
    Then request should be notify to them
    Examples:
    
    | isbn | BookTitle | authorName |Phno   |    
    |      |           |            |       |       
    |      |           |            |       |  