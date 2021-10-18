Feature: Automation Testing on media module of real estate application

  Background: Login Functionality
    Given user is on login page
    When Admin will enter userId "mohankrishna176@gmail.com" and password "Secret@123&&"
    And Admin will click on sign in tab
    Then Admin will be navigated to Real Estate dashboard
    And Admin will hover the mouse over media section and click on library
    Then Admin will be able to see media library

  @addnew
  Scenario: Validate Add New Tab field
    Given admin will hover over media section and click on Add New tab
    And Admin will navigates to upload new media webpage
    Then admin verifies the choose file field

  @filter
  Scenario: Validate Filter Tab
    Given Admin is on media media library webpage
    When Admin will click on all media item dropdown menu and select images option
    And admin will click on all dates dropdown menu and select first option
    And admin will click on filter tab and admin will get total items after first filteration
    And admin will click on all dates dropdown menu and select second option
    And admin will click on filter tab and admin will get total items after second filteration
    And admin will click on all dates dropdown menu and select fourth option
    And admin clicks on filter tab and admin will get total items after fourth filteration
    When Admin will click on all media item dropdown menu and select unattached option
    And admin will click on all dates dropdown menu again and select first option
    And admin clicks on filter tab and admin will get total items after fifth filteration
    And admin will click on all dates dropdown menu again and select second option
    And clicks on filter tab and admin will get total items after sixth filteration
    And admin will click on all dates dropdown menu again and select fourth option
    And admin clicks on filter tab and admin will get total items after eight filteration

  @bulkaction
  Scenario: Validate Bulk Action dropdown
    Given Admin will click on bulk action tab and selects delete permanently choice
    And Admin will select checkbox available in front of image
    And Admin will click on apply button
    Then alert message will display
    And admin will dismiss the action
    And admin will refresh the page

  @search
  Scenario Outline: Validate Search Media Items field
    Given Admin will hover the mouse over media section and admin will select library from dropdown
    And admin will enter "<data>" in search media items field and clicks on enter key
    Then admin verifies message displayed on the screen
    And admin will check the availability of items according to search

    Examples: 
      | data      |
      #| Tiger     |
      | apartment |

  @screenoptions
  Scenario: Validate Screen Options field
    Given admin will refresh the page first
    When admin will hover the mouse over media section and click on library option
    And admin will click on screen options button
    And admin deselects all the checkbox
    When admin clicks on author checkbox
    Then author column gets appeared in the media table
    When admin clicks on uploaded to checkbox
    Then uploaded to column gets appeared in the media table
    When admin clicks on comments checkbox
    Then comments column gets appeared in the media table
    When admin clicks on date checkbox
    Then date column gets appeared in the media table
    And admin checks total column and fetch column names from the media table
    And admin fetch first ten existing records

  @pagination
  Scenario Outline: Validate pagination field
    Given Admin will hover the mouse over media section and selects library option from dropdown
    And admin will click on screen options button present on upper right corner of the webpage
    And admin will enter "<count>" in Number of items per page: field
    And then clicks on apply button
    And admin checks if pagination exists or not
    Then admin will get current page according to filter
    And admin clicks on next page button and navigates to second page
    And admin clicks on last page button and navigates to last page
    And then admin will navigate to first page using
    Then admin will count total number of items present on title bar of media table

    Examples: 
      | count |
      |    10 |

  @Edit
  Scenario Outline: Validate Edit tab
    Given Admin will hover over media section and selects library option from dropdown
    When admin will click on edit image option
    Then admin navigate to edit media webpage
    And admin will enter "<caption>" in caption field and "<alternativetext>" in alternative text field and "<content>" in the description field
    And then admin enter the "<Title>" in title bar present above the image and clicks on update tab
    Then admin verifies success message
    And admin clicks on library section and verifies the title on media library webpage
    And admin click on view option and verifies the content given in the description field

    Examples: 
      | caption                             | alternativetext                   | content                                                                                                                                         | Title |
      | In waking a tiger, use a long stick | Tiger is national animal of india | Tiger is the biggest wild animal in the cat family,Tiger has long and strong body. It has four legs, strong paws with sharp nails and one tail. | Tiger |
