# Mitrais Carrot

## Installation

### Clone repo

``` bash
# clone the repo
$ git clone https://bitbucket.org/cakpep/mitrais-carrot-api.git
$ git clone https://trello.com/c/ff2WSH3R/1-jamie-definition-of-done

# go into app's directory
$ cd mitrais-carrot-api
```

### create mitrais_carrot database and change the database connection in 
``` bash
# copy `src/main/resources/application.properties.example`
# and rename into `src/main/resources/application.properties`
#now change with your db config connection
```

### Run Application
``` bash
# install app's dependencies
$ mvn spring-boot:run

# Open browser
http://localhost:8989/
```

### View Swagger API Doc
``` bash
# view the swagger json
http://localhost:8989/v2/api-docs
# view the swagger UI
http://localhost:8989/swagger-ui.html
```
'
