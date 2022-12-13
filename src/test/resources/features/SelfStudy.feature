@engin
Feature: As a person I should be able to login


  Background: Login
    Given Client is on the login page




  Scenario: login with valid credentials

    When Client enter valid user name, password and domain name
    Then Client uses credentials
    |username| salesmanager101|
    |password|UserUser123     |

    And Client enter "driver" credentials
    And Client enter "sales manager" credentials
    And Client enter "store manager" credentials

    @bekem
    Scenario:
      When Client uses credentials to login

      |Engin|Bekem|enginbekem@yahoo.com|4723230|
      |Aylin|Erdog|bekemaylin@yahoo.com|9854321|

  @engine
Scenario Outline: Login multiple
And Client enter "<roles>" credentials

  Examples:
  |roles        |
  |driver       |
  |sales manager|
  |store manager|

@arin
  Scenario Outline: Login multiple //""isareti olmadan bir step definition ile isi bitirmek
    And Client enter <names> and <password> credentials

    Examples:
      |names        | password|
      |driver       |    a    |
      |sales manager|    b    |
      |store manager|    c    |

Scenario: browser

  When I open application in Chrome browser