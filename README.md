buildtime-maven-plugin
======================

Buildtime Maven Plugin

1. Install plugin: mvn install

2. Add <plugingroup>com.pedroalmir.plugins</plugingroup> in your settings.xml

3. To use include this in your pom.xml

```html
<build>
  <plugins>
		<plugin>
			<groupId>com.pedroalmir.plugins</groupId>
			<artifactId>buildtime-maven-plugin</artifactId>
			<version>1.0.0</version>
			<executions>
				<execution>
					<id>start-timer</id>
					<phase>validate</phase>
					<goals>
						<goal>start</goal>
					</goals>
				</execution>
				<execution>
					<id>stop-timer</id>
					<phase>package</phase>
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

</code>
