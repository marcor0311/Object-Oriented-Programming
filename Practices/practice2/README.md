Buscar cómo resolver el error/warning que sale al ejecutar el comando: java -cp target/rest-poc-app-1.0-SNAPSHOT-jar-with-dependencies.jar tec.poo.spark.App

Agregar esto al pom.xml
<dependency> 
    <groupId>org.slf4j</groupId>   
    <artifactId>slf4j-jdk14</artifactId>
    <version>1.7.30</version>     
</dependency>

Buscar un plugin para que se pueda ejecutar el programa utilizando maven en vez del comando anterior, debe poder invocar mvn con alguna combinación de parámetros para que se pueda obtener el mismo resultado que el comando anterior. Debe de documentar ese comando agregando un README.MD al folder mencionado en el punto 1
    <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>1.2.1</version>
        <executions>
            <execution>
                <goals>
                    <goal>java</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <mainClass>tec.poo.spark.App</mainClass>
        </configuration>
    </plugin>

comando:
mvn exec:java