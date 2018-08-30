# Mitrais Carrot

## Installation

### Clone repo

``` bash
# clone the repo
# master
$ git clone https://bitbucket.org/cakpep/mitrais-carrot-api.git
# personal
$ git clone https://github.com/rudybelmont/git-mitrais-carrot-api.git

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
