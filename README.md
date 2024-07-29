[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# 📌 Spring Boot Producer - Consumer Kafka example.
### This code shows simple basic setup for Producer and Consumer with Kafka.

- Example include docker-compose.yaml to download and run Kafka in Docker. 

⚠️ You need docker installed.

⚠️  The Issue: Uncaught Exceptions in ScheduledExecutorService

- Suppressed Exceptions: The ScheduledExecutorService doesn't automatically log or propagate uncaught exceptions thrown
from the tasks you schedule. Instead, if an exception occurs, subsequent executions of that task are simply suppressed.
This behavior is documented in the scheduleAtFixedRate and scheduleWithFixedDelay methods' JavaDocs.
No Default Error Handling: There's no built-in error handling mechanism within ScheduledExecutorService to log these
exceptions or notify you in other ways.

