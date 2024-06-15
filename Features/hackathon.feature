Feature: 91Wheels
	Scenario: UpcomingBikes
		Given application is opened (91Wheels)
		And navigated to upcoming bikes page
		When Honda is selected from the bike brands
		And Load more is clicked
		Then print bike name, expected price and launch date of bikes priced below 4Lakhs
		
	Scenario: UsedCarsChennai
		Given application is opened (91Wheels)
		And navigated to used Cars in chennai page
		When Clicked on read more button
		Then print the popular cars details
		
	Scenario: GoogleLogin
		Given application is opened (91Wheels)
		And navigated login Window
		When sign in with google button clicked
		And entered email and clicked next
		Then print the error message
		