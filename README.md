# Office-Booking-Tool

Welcome to Office-Booking-Tool! This is a Java console application that allows users to manage office bookings. The application is built with object-oriented programming principles and utilizes a MySQL database for storing data.

## Main Features

The Office-Booking-Tool provides the following main features:

- User registration and login
- Adding new offices
- Booking offices for a specified date range
- Viewing availability for a specified office
- Viewing the user's bookings

## Database Setup

To set up the database for Office-Booking-Tool, follow the steps below:

1. Install MySQL on your system if it is not already installed.

2. Create a database for Office-Booking-Tool by running the [tables.sql](setup_db/tables.sql) file located in the "setup_db" folder at the root of the project. 

3. Before running the project, please download the MySQL connector jar file (mysql-connector-j.jar) from the official MySQL website and add it to the referenced libraries of your project.

4. Provide the credentials for the database connection in the [database.properties](src/resources/database.properties) file, located in the "resources" folder of the "src" directory. 

Once you have completed the above steps, you are ready to run the application.


## Screenshots
Here are some screenshots of the Office-Booking-Tool in action:

- Login (the password stored in the database is encrypted)


![Login](https://user-images.githubusercontent.com/42031441/227526086-c1c741c6-3120-4084-849e-c32060f85509.jpg)


- Making a booking


![MakeBook](https://user-images.githubusercontent.com/42031441/227526865-90327c46-e941-4190-b18a-56279cca092d.jpg)


- Viewing the status of an office


![OfficeStatus](https://user-images.githubusercontent.com/42031441/227528223-dbc64345-874e-4cb7-9750-7dacc1837a51.jpg)


- Viewing Bookings


![MyBookings](https://user-images.githubusercontent.com/42031441/227527776-9cabe3c1-7429-424c-9769-43c68de384f9.jpg)


- Viewing the commands


![Commands](https://user-images.githubusercontent.com/42031441/227527930-47feb4d4-e333-4b73-a4ec-0efd070a5f39.jpg)



## Conclusion
Thank you for checking out the Office-Booking-Tool! We hope you find it useful for managing your office bookings. If you have any questions or feedback, please feel free to reach out to us.
