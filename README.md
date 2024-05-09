
# Satellite-DB

## Overview


Welcome to my satellite! This digital platform serves as a showcase of my journey as a software engineer, spotlighting my skills, projects, and experiences. 
- Built with HTML, CSS, and JavaScript for the frontend 
- Java with Spring Boot, Hibernate, JPA  for the backend it offers visitors profound insights into my expertise and creative endeavors. 
- Leveraging PostgreSQL for database management, it stands as a testament to my commitment to delivering robust and dynamic web solutions.

- The master build is live at: [Satellite-DB](https://satellites.onrender.com/)
- To ensure continuous uptime, a monitoring system is in place: [Uptime-Robot-URL](https://uptimerobot.com/dashboard)




## Features

- CRUD operations for satellite and launcher dataset.
- Search bar to filter result based on input.
- Pagination to control the flow of the response.


## Getting Started

Visit the [Satellite-DB](https://quiz-website-g8d7.onrender.com/). Navigate through user-friendly interfaces offering adding and updating new satellite information.




## Useful Commands and Procedures

Frequently used commands .


### Docker 

*  Build docker without any name and tag  
```shell script
docker build .
```
```shell script
docker build -t quiz-app .
```

*  Returns all images in the docker
```shell script
docker images
```
*  Map port of the docker to external services
```shell script
docker run -p 8080:8080
```

 

### Project Build and Run Commands


* Make sure the command in start.sh script is correct as per your config files path
```shell script
env $(cat app/.env | grep -v "^#" | xargs) java -jar app/target/app-0.0.1-SNAPSHOT.jar
```


## Sample .env File
```shell script
# Satellite Database credentials
DB_HOST=localhost
DB_PORT=5432
DB_NAME=satellite-data
DB_USERNAME=postgres
DB_PASSWORD=root
DB_CONFIG_QUERY_STRING=allowPublicKeyRetrieval=true&useSSL=false&sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false&createDatabaseIfNotExist=true
```

## License

This project operates under an open-source model and is available under the [MIT License](LICENSE).

## Connect and Collaborate

I'm enthusiastic about exploring new opportunities, collaborations, and engaging discussions. Whether you have a project in mind, an innovative idea to explore, or simply wish to connect and share insights, I'm just an email or phone call away:

- Email: shubhamchouksey1998@gmail.com
- Phone: +91 9479917417

Let's embark on new journeys together and craft innovative solutions. Thank you for visiting my quiz website, and I eagerly anticipate connecting with you!



## Authors

- [@Shubham Chouksey](https://github.com/ShubhamChouksey123)

