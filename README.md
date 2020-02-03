# Main Login

Login and Register web-service API

## Getting Started

This is a web-service example what I made for fun and to know my knowledge about Java by a certain company that I wanna get the job there 

### Prerequisites

You need the following requirements installed

```
gradle version 5 or upper
java 1.8 or upper
```

### Installing

You need simply to execute the gradle startup and go to http://localhost:8080/swagger-ui.html in the browser 
```
gradle clean build
gradle bootrun
```

Then you can excute the User Register Request like this and enjoy it

```
{
	"first_name": "Tony",
	"last_name": "Stark",
	"email": "tony.stark@starkindustries.com",
	"password": "123456Ab",
	"phones": [{
		"number": "999888777",
		"city_code": "",
		"contry_code": "56"
	},{
		"number": "999888777",
		"city_code": "",
		"contry_code": "58"
	}]
}
```

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - The best framework for Java
* [Gradle](https://gradle.org/) - Dependency Management


## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Luis Alamo** - *Initial work* - [luismalamoc](https://github.com/luismalamoc)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the Apache License, Version 2.0 (the "License"); - see the [LICENSE.md](LICENSE.md) file for details
