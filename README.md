# ATM Simulator

A GUI java application which simulates an `Automated Teller Machine(ATM)` Interface to provide users with the capabilities like:

+ New users can sign up by filling up their details and the system will generate a unique `16 digit card number` and a `4 digit pin` for the user and user can then log in to the system with that credential.

+ After logging into the system the user can do the following:
  + `Withdraw money` from their account
  + `Deposit money` from their account
  + View their `account statement`
  + `Change their PIN`
  + Withdraw money using `fast cash`
  + View their `account details`

---

To use the application on your system, just clone this repository and run the following commands for linux and Mac machines:
- `./gradlew build` to build the project
- `./gradlew run` to run the projector
Make sure that you have execution permission for the gradlew file before running the above commands.
In case you don't have execution permission one easy way to get the would be to run this command `chmod +x gradlew`.
For windows machines use`gradlew.bat file` and you are good to go :)

    You don't need to have gradle or java installed on your sytem to run the application, the script will handle all that for you.
