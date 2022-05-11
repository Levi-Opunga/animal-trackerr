# animal-trackerr
This is a spark application for recording details on animals and tracking them. This app utilises objects to display the data and the t-sql database to store the data. It allows a user to add an animal depending on whether it is endangered animal or a normal animal. It also allows a user to input sightings of animals. The app also allows a user to update the information on each entry and the user can also delete a particular entry or clear the database of entry fields.

## Prerequisites
- Knowledge of On Git CLI
- Java 11
- Gradle as a built tool
- IntelliJ or any Java based IDE
- postgres SQL sever installed


## Technologies
- Java 11
- Gradle
- Spark
- CSS
- JUnit
- Handlebars Template Engine
- Postgres Sql

## Installation
1. Clone or download repository as as an archive
2. If archive unzip the archive to get project folder
3. In terminal open the applications root folder
4. To run in terminal use `gradle run` then open your browser and view project on localhost port 4567 - - >"https://locahost:4567"
5. To open in IDE `[IDE name] .` eg `code .`
6. Recreate the the database in your local psql by running the following
```
CREATE DATABASE animal_tracker;
\c animal_tracker
CREATE TABLE animal (id serial PRIMARY KEY, name varchar, record_date timestamp) ;
CREATE TABLE endangeredanimal (id serial PRIMARY KEY, name varchar, gender varchar, record_date timestamp, age varchar, health_status varchar) ;
CREATE TABLE sighting (id serial PRIMARY KEY, animal_type varchar , longitude Float, latitude Float , record_date timestamp , animal_id int);
```
## To Contribute or Fix bug
To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request

## BUGS FOUND

If you come across any bug in the project kindly report using the link below
#### [Link 🔗 ](https://github.com/Levi-Opunga/animal-trackerr/issues/new)

## Licence
### MIT License
>Copyright (c) 2022 Levi Opunga

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## Support and contact details

> > EMAIL: leviopunga@gmail.com






