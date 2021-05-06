*** Settings ***
Documentation   Test Add/Edit/Remove PetTypes
Library         SeleniumLibrary
Test Setup      Begin Web Test
Test Teardown   End Web Test
*** Variables ***
${BROWSER}      chrome
${URL}          http://localhost:4200/

*** Keywords ***
Begin Web Test
    Open Browser               about:black     ${BROWSER}
    Maximize Browser Window
    Go to                       ${URL}
Verify Page Loaded
    Page should contain         Welcome to Petclinic
Click On Pet Types Button
    click element               xpath://html/body/app-root/div[1]/nav/div/ul/li[4]/a
    page should contain element         id=pettypes
End Web Test
    Close Browser
*** Test Cases ***
User add a pet type
    [Documentation]         Add A Pet Type
    [Tags]                  PB-83
    Verify Page Loaded
    Click On Pet Types Button
    click button                xpath://html/body/app-root/app-pettype-list/div/div/div/button[2]
    page should contain element         xpath://html/body/app-root/app-pettype-list/div/div/div[1]/app-pettype-add/div/div/h2
    input text                  xpath://*[@id="name"]     Fish
    click button                xpath://html/body/app-root/app-pettype-list/div/div/div[1]/app-pettype-add/div/div/form/div[2]/div/button
    page should contain button    xpath://html/body/app-root/app-pettype-list/div/div/div/button[2]
    page should contain textfield        xpath://*[@id="6"]     Fish

User edit pet type
    [Documentation]         Edit the added pet type
    [Tags]                  PB-70
    Verify Page Loaded
    Click On Pet Types Button
    click button                xpath://*[@id="pettypes"]/tbody/tr[7]/td[2]/button[1]
    input text                  id=name     Snake
    click button                xpath://*[@id="pettype"]/div[2]/div/button[1]
    page should contain button  xpath://html/body/app-root/app-pettype-list/div/div/div/button[2]
    page should contain element         id=6   Tiger
User can delete pet type
    [Documentation]         remove the added pet type
    [Tags]                  PB-70
    Verify Page Loaded
    Click On Pet Types Button
    click button                xpath://*[@id="pettypes"]/tbody/tr[7]/td[2]/button[2]
    page should contain button  xpath://html/body/app-root/app-pettype-list/div/div/div/button[2]
    page should not contain element        id=6    Tiger
