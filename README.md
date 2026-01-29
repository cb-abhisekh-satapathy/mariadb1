Sample project in Spring Boot with MariaDB
# Lagos

> Spring boot project which emphasizes on Series routes related to matches (Rewrite for dublin).

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.3-green?style=for-the-badge&logo=springboot)
![MariaDB](https://img.shields.io/badge/MariaDB-8.0-blue?style=for-the-badge&logo=mariadb)

## 📖 Overview

Lagos is a backend service built with Spring Boot, designed to handle series-related operations for cricket matches. It serves as a rewrite for the "Dublin" project, focusing on performance and modern architecture.

## 🏗️ Architecture

The application follows a standard layered architecture:

```mermaid
graph TD
    Client[Client / Frontend] -->|HTTP Requests| Controllers
    
    subgraph "Application Core"
        Controllers[Controllers Configuration]
        Services[Service Layer]
        Repos[Repositories / Data Access]
    end
    
    Controllers --> Services
    Services --> Repos
    
    subgraph "Controllers Breakdown"
        Series[SeriesController]
        Stands[IccStandingsController]
        Points[PointsTableController]
        Rank[RankingController]
        SList[SeriesListController]
    end
    
    Controllers -.-> Series
    Controllers -.-> Stands
    Controllers -.-> Points
    Controllers -.-> Rank
    Controllers -.-> SList
    
    Repos -->|SQL| DB[(MariaDB Database)]
    Services -->|API Calls| ExtServices[External Services\n(Aldan, MatchesSchedule)]
```

## ✨ Key Features

- **Series Management**: CRUD operations for cricket series.
- **ICC Standings**: Retrieve and manage ICC standings.
- **Points Table**: Calculate and display points tables for tournaments.
- **Rankings**: Manage player and team rankings.
- **External Intregrations**: Integrates with Cricbuzz internal APIs for ads and schedules.

## 🚀 Getting Started

### Prerequisites

- **Java 21 Development Kit (JDK)**
- **Maven 3.x**
- **MariaDB Database**

### Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/cricbuzz/matches-lagos.git
    cd matches-lagos
    ```

2.  **Configure the database:**
    Update `src/main/resources/application.properties` with your database credentials:
    ```properties
    spring.datasource.url=jdbc:mariadb://localhost:3306/your_db
    spring.datasource.username=root
    spring.datasource.password=password
    ```

3.  **Build the project:**
    ```bash
    mvn clean install
    ```

4.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

## ⚙️ Configuration

Key configurations in `application.properties`:

| Property | Description |
| :--- | :--- |
| `server.port` | Port where the server runs (Default: `8080`) |
| `ads.aldan.service` | URL for the Ads service |
| `matchesSchedule-service` | URL for the Matches Schedule service |
| `ad.enabled` | Toggle for enabling advertisements |

---
*Generated with ❤️ by Lagos Team*
