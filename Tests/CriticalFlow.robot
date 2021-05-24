*** Settings ***
Documentation   Test Add/Edit/Remove PetTypes
Library         SeleniumLibrary
Test Setup      Begin Web Test
Test Teardown   End Web Test
*** Variables ***
${BROWSER}              chrome
${URL}                  http://localhost:4200/
${Firstname}            Kalle
${Lastname}             Karlsson
${City}                 Gothenburg
${Address}              abc123
${Telephone}            1234567
${PetFirstName}         Tyson
${Date}                 2021/01/01
*** Keywords ***
Begin Web Test
    Open Browser                        about:black     ${BROWSER}
    Maximize Browser Window
    Go to                               ${URL}
    Page should contain                 Welcome to Petclinic
# GHERKIN TEST 1----------------------------------------------------------------------------
User is on the add owner page
    click element               xpath://html/body/app-root/div[1]/nav/div/ul/li[2]/a
    click element               xpath://html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a
User adds an owner
    click button                Add Owner
    input text                  xpath://*[@id="firstName"]     ${Firstname}
    input text                  xpath://*[@id="lastName"]      ${Lastname}
    input text                  xpath://*[@id="address"]       ${address}
    input text                  xpath://*[@id="city"]          ${City}
    input text                  xpath://*[@id="telephone"]     ${Telephone}
    click button                Add Owner
Owner gets added
    wait until page contains element    xpath://html/body/app-root/app-owner-list/div/div/div
    Page should contain                 ${Firstname} ${Lastname}
#GHERKIN TEST 2------------------------------------------------------------------------------
User is on the add pet page
    User is on the add owner page
    Click link                  ${Firstname} ${Lastname}
    click button                Add New Pet
User adds a pet to the added owner
    input text                  id=name     ${PetFirstName}
    input text                  xpath://html/body/app-root/app-pet-add/div/div/form/div[4]/div/input      ${Date}
    click element               id=type
    click element               xpath://*[@id="type"]/option[1]
    click button                Save Pet
    wait until page contains element    xpath://html/body/app-root/app-owner-detail/div/div/table[2]
Pet gets added
    page should contain         Name  ${PetFirstName}
End Web Test
    Close Browser

*** Test Cases ***
User add an Owner
    [Documentation]         Add An Owner
    [Tags]                  PB-126
    Given User is on the add owner page
    When User adds an owner
    Then Owner gets added
User add a pet to the added owner
    [Documentation]         Add pet to added owner
    [Tags]                  PB126
    Given User is on the add pet page
    When User adds a pet to the added owner
    Then Pet gets added
