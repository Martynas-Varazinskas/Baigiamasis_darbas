# Project "Baigiamasis_darbas"
### Site used for testing
[marskineliai.lt](https://marskineliai.lt/)
### Packages used
- TestNG `org.testng:testng`
- Selenium `org.seleniumhq.selenium:selenium-java`
- WebDriverManager `io.github.bonigarcia:webdrivermanager`

# Tests:
1. Try logging in using valid username and valid password:
    * click icon *"My account"*;
    * enter valid username;
    * enter valid password;
    * click on button "Prisijungti";
    * check if correct user greetings message appears;
   

2. Try logging in using invalid username and valid password:
   * click icon *"My account"*;
   * enter invalid username;
   * enter valid password;
   * click on button "Prisijungti";
   * check if correct error message *"Error: The username test is not registered on this site."* appears;

3. Try Logout:
    * repeat Login test steps;
    * click button Logout;
    * check headline text is "Prisijungti";
    * check if button "Prisijungti" is visible;


4. Try to search specific item with search bar using Data Provider:
    * open home page;
    * add search value to search bar;
    * click key 'ENTER' using actions;
    * check if search message actually contains entered search value;
    * check if products are found;


5. Try adding 1 item to cart: 
    * click *"Mūsų dizainai"*;
    * click category *"Kempiniukas"*
    * click on item to open product page;
    * click button *"add to cart"*;
    * check if cart badge count number is displayed;
   
   
6. Try adding multiple items to cart:
    * repeat two first steps from test 5;
    * add random item random times(from 2 to 8 times using SimpleMath);
    * check if cart badge number is correct;
    * check if total value of cart is correct;
   

7. Try adding specific item to wish list:
   * open category page;
   * open specific item product page;
   * add item to wish list by clicking on icon *"icon-heart"*;
   * check if wish list icon count badge number is displayed;
   * check if added item is correct by item title;