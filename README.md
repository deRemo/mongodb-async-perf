# mongodb-async-perf
Example usage of MongoDB Java Reactive Streams to compute latencies

1) Install Java JDK21 on your system:
```bash
ccsudo apt install openjdk-21-jdk
```
2) Set Java JDK21 as default:
```bash
    sudo update-java-alternatives --set java-1.21.0-openjdk-amd64
```
3) Install Maven as shown on the [Official Website](https://maven.apache.org/install.html)
4) Compile:
```bash
  mvn clean install
```
5) Run:
```bash
  mvn exec:java -Dexec.mainClass=org.example.Main
```
