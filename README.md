# StarPort
StarPort is a simulator of running the day-to-day logistics of a working spaceport, including managing flights, building docks to accomodate different vessels, and managing finances.

## Building and Dependencies
All dependencies are managed through Maven. To build StarPort, simply run ```mvn clean package``` in the directory which you downloaded the project. This will download dependencies and compile an executable jar.

## Running
To launch StarPort, execute ```java -jar /path/to/starport-1.0.jar```.

## Usage
Commands for the command-line interface are as follows;

| Command | Description |
| --- | --- |
| `$ new` | Creates a new Game |
| `$ begin` | Launches GUI and NPC controllers |
| `$ spawn (#)` | Spawns specified number of random FlightDatas to your StarPort Arrival Coordinator |
| `$ arrivals` | List arrival statistics |
| `$ quit` | Exit StarPort |

### Disclaimer
StarPort is still under heavy development and builds may be unstable.
