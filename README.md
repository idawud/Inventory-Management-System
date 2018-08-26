 # Inventory Management System
 This a JavaFx Graphical User Interface Application that stores users and inventory information 
 in MySQL Database.Only existing admin user can add another user and a products 
 id, product_name, price, details, category, subgategory and date_added is also stored. Also
 a product can be updated and deleted as wished.
![alt text](https://github.com/idawud/Inventory-Management-System/blob/master/screenshots/home.PNG "IMS home")
 The interface of this application was developed with JavaFx Library a java GUI library that is an
 alternative to Swing,java2d and AWT, that gives a web gui fill. A software developed by Gluon Inc
 SceneBuilder makes it easy to create this interfaces using drag and drop. To Learn more visit:
https://gluonhq.com/products/scene-builder/

 ## Database
 The database used is the open sourse relational database ' MySQL '.Read More on MySql:<br/>
https://www.mysql.com/

 ### Setup
 Download and install either XAMP, LAMP, WAMP or my favorite MAMP.
 Set username and password : "root" and "root"
 create a Database: 'inventory'
 create also two tables: 'product' and 'admin' 

*Table structure for table `product`* 
```
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `price` varchar(16) NOT NULL,
  `details` text NOT NULL,
  `category` varchar(16) NOT NULL,
  `subgategory` varchar(16) NOT NULL,
  `date_added` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```

*Table structure for table `admin`*
```
CREATE TABLE `admin` (
  `id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `last_log` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```

*Download links:*<br/>
MAMP: https://www.mamp.info/en/downloads/ <br/>
LAMP: https://bitnami.com/stack/lamp/installer <br/>
WAMP: http://www.wampserver.com/en/ <br/>
XAMP: https://www.apachefriends.org/download.html <br/>

## Running the Application
Download and Install Java JDK and version should be 8 or greater.
Make sure java JDK is added to the environment variable path.

Download and Install Lastest Version of Netbeans IDE.
Clone this repository to a path in your Pc.

Open Netbeans IDE -> File -> Open Project and Navigate to the path in your Pc you cloned the repository.
In the Projects Structure Click on " Dashboard.java " and hit the Run button.

*Download links:*<br/>
Java JDK:  http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html <br/>
Netbeans IDE:  https://netbeans.org/downloads/ <br/>
 
## Developer Info 
    Name: Ismail Dawud Ibrahim
    Email: Ismaildawud96@gmail.com
    Twitter: https://www.twitter.com/idawudi
    Phone: +233546742189
    WhatsApp: +233546742189
    Location: Accra & Cape Coast - Ghana
