# RESTAPIDesign
An experiment in learning more about REST API design


The services are : 

1.) User Service (With illustration of bean validation)

Example:

get all users :
    http://localhost:8080/InnovRestTraining/api/rest/users
    
add users

POST /InnovRestTraining/api/rest/users HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: d9cc9a3f-3e9a-5450-3469-8979b021129e

{
	"fName" : "moby",
	"lName" : "dick",
	"primaryEmailAddress" : "moby.dick@test.com",
	"homeAddress": "22 nd street 5th avenue NY",
	"age": 32,
	"primayMobilePhoneNumber": "+1381820931289"
}

{
	"fName" : "moby",
	"lName" : "dick",
	"primaryEmailAddress" : "moby.dick@test.com",
	"homeAddress": "22 nd street 5th avenue NY",
	"age": 32,
	"primayMobilePhoneNumber": "+1381820931289"
}    


2.) Endurance sports service (With illustration of nested subresource)



GET /InnovRestTraining/api/rest/endurancesports/1/atheletes HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 5b5ccaae-9930-f9b3-69b1-47d01a766cd9


POST /InnovRestTraining/api/rest/endurancesports/1/athelete HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: df73737c-505c-58c2-f365-9b3fa60f52f5

{
	"fName" : "Scott",
	"lName" : "Jurek",
	"location" : "Boulder,CO",
	"club" : "Solo",
	"gender" : "MALE",
	"rank" : 1
}

*subresources are tricky

