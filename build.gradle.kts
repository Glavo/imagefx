plugins {
    id("java-library")
}

group = "org.glavo"
version = "0.1.0" + "-SNAPSHOT"

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(11)
}

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}
