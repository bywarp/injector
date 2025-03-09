plugins {
    id("java")
    id("maven-publish")
}

group = "dev.nstruck"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/bywarp/injector")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}