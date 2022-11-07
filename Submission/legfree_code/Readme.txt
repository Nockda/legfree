******** Readme for Legfree ********

This is the web site of vehicle rental service

************************************

University of Glasgow
Programming and System Development
Team project (LC01-LB03-F)

************************************

Contributor

Hongin Bao
Hyun Suk Lee
Jaskaran Singh Kawatra
Junhan Yang
Shaohua Zhang
Xinhao Yang
Zhiheng Zhang

************************************

Development Environment

Java - 17+ / Spring framework
DB - mysql
IDE - Intellij

************************************

Git address : https://github.com/Nockda/legfree.git
Video adreess : https://youtu.be/k5rNFSg-9lA

************************************

How to run the application

1. Download Intellij IDEA Ultimate Edition with the following link: 
https://www.jetbrains.com/idea/download/#section=windows
Choose the right version for your computer.

2. Visit oracle's official website select java 17+ for the local machine type.
https://www.oracle.com/java/technologies/downloads/#jdk17-windows

3. Configure the database environment and select Mysql 8.0.30 or above for installation
https://dev.mysql.com/downloads/installer/

4. Download Database Development tool and create a local connection.
Example Navicat
https://www.navicat.com/en/download/navicat-for-mysql

5. Unzip Legfree project file. 
The code is in the ‘new_code’

6. Open navicat, create a new database local connection, after creating the connection
successfully, create a new database named tapp_database

7. Extract the sql file from the zip folder and right-click on the database you just created and select Run SQL File

8. Select the path of the SQL file you want to run, and click Start to load 4 SQL file from the zip package into the database table.
/legfree_code/DB_data
(vehicle_info.sql, user.sql, order_info.sql, error_info.sql)

9. Check the db imported successfully

10. Run Intellij
Importing projects in Intellij IDEA:
File -> open -> choose the folder where the code is -> legfree_code -> Code -> ps-tapp

11. new_code/ps-tapp/tapp/src/main/java/recources/application.properties
This is the file you can edit your database account.
Adjust username and password

12. Click the Run button and Run the entire project(TappApplication.java)
