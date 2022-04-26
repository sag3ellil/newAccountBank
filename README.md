# newAccountBank for Existing costumer Rest api 
Java version 11
Maven version 3.8.1

# The goal of the api is to : 
-add a new bank account for an existen costumor by getting the (customerID, initialCredit)
 
-Display the costumer information with his accounts and the transactions done.
since the start of the api, a user will be created with the ID = 1 , this one will be used for our tests.

# To build the project:
go to the main folder of the project : "newAccountBank"
in cmd : mvn clean install

# to run the application execute : 
java -jar pathofthefolder\newAccountBank\target\NewAccount-0.0.1-SNAPSHOT.jar com.bank.NewAccount

# Rest end point:
localhost:8083/capBE/add/newAccount/ExistingCostumer/1 [Put]

localhost:8083/capBE/getAccountsByCostumer/1 [Get]

curl -H "Content-Type: application/json" -X PUT http://localhost:8083/capBE/add/newAccount/ExistingCostumer/1 -d "{\"initialCredit\" : 20}

curl -H  GET http://localhost:8083/capBE/getAccountsByCostumer/1

# run tests : 

go the main folder of the project : newAccountBank , open cmd, write :
mvn test

 
