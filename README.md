# Hammock HelloWorld Capsule

This is HelloWorld RESTful micro-service using CDI based [Hammock](https://github.com/hammock-project/hammock) framework to demonstrate [Capsule](http://www.capsule.io/) _nested jar_ packaging.

Service uses following Hammock components:
- [`bootstrap-weld`](https://github.com/hammock-project/hammock/tree/master/bootstrap-weld) - [Weld](http://weld.cdi-spec.org/) CDI implementation
- [`web-undertow`](https://github.com/hammock-project/hammock/tree/master/web-undertow) - [Undertow](http://undertow.io/) Servlet implementation
- [`rest-jersey`](https://github.com/hammock-project/hammock/tree/master/rest-jersey) - [Jersey](https://jersey.java.net/) JAX-RS implementation

It also uses following [SLF4J](http://www.slf4j.org/) components:
- `slf4j-simple` - [Simple SLF4J](http://www.slf4j.org/apidocs/org/slf4j/impl/SimpleLogger.html) implementation that writes messages to the console
- `jul-to-slf4j` - [Java Util Logging to SLF4J](http://www.slf4j.org/legacy.html#jul-to-slf4j) bridge which routes all incoming JUL records to the SLF4J

## Try it

The services uses Maven to build the project. You can use Maven Exec plugin to run the application with verbose logging enabled:

```bash
mvn clean compile exec:java
```

The service endpoint is [`http://localhost:8080/hello`](http://localhost:8080/hello):

```bash
curl -vvv http://localhost:8080/hello
```

with output:

```text
Hello, World!
```

## Build Capsule

[Capsule](http://www.capsule.io/) is executable nested jar that contains the service classes and resources including dependency jar files.

To build capsule jar file it uses Maven plugin [`capsule-maven-plugin`](https://github.com/chrisdchristo/capsule-maven-plugin) that is attached to Maven `package` phase.

```bash
mvn clean package
```

In target directory there are two jar files:
- `hammock-capsule-0.1-SNAPSHOT.jar` - contains just service classes and resource
- `hammock-capsule-0.1-SNAPSHOT-capsule.jar` - nested jar file, contains `Capsule` class, `hammock-capsule-0.1-SNAPSHOT.jar` file as well as all dependency jar files

You can run the nested jar file with just `warn` logging enabled:

```bash
java                        -jar target/hammock-capsule-0.1-SNAPSHOT-capsule.jar
```

Capsule supports different runtime [modes](http://www.capsule.io/user-guide/#modes-platform--and-version-specific-configuration). In the project there are two modes prepared:

Run the application in `verbose` logging enabled mode:

```bash
java -Dcapsule.mode=verbose -jar target/hammock-capsule-0.1-SNAPSHOT-capsule.jar
```

Run the application in remote JVM `debug` mode:

```bash
java -Dcapsule.mode=debug   -jar target/hammock-capsule-0.1-SNAPSHOT-capsule.jar
```

You can now attach your favorite debugger to the application at port `5005`.
