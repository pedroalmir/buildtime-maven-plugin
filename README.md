buildtime-maven-plugin
======================

Buildtime Maven Plugin

1. Download build-maven-plugin

2. Install plugin: mvn install

3. Add ```<plugingroup>com.pedroalmir.plugins</plugingroup>``` in your settings.xml

4. To use include this in your pom.xml

```html
<build>
  <plugins>
		<plugin>
			<groupId>com.pedroalmir.plugins</groupId>
			<artifactId>buildtime-maven-plugin</artifactId>
			<version>1.0.0</version>
			<configuration>
				<goalPrefix>buildtime</goalPrefix>
			</configuration>
			<executions>
				<execution>
					<id>start-timer</id>
					<goals>
						<goal>start</goal>
					</goals>
				</execution>
				<execution>
					<id>stop-timer</id>
					<configuration>
						<!-- Define here URL Post Method to get build informations -->
						<reportUrl>http://localhost:8080/buildtime</reportUrl>
					</configuration>
					<goals>
						<goal>stop</goal>
					</goals>
				</execution>
			</executions>
		</plugin>
	</plugins>
</build>
```
5. Usage: <code>mvn buildtime:start other goal buildtime:stop </code>

6. For example: <code>buildtime:start clean package buildtime:stop</code>


