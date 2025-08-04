plugins {
    id("java-library")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.glavo"
version = "0.1.0" + "-SNAPSHOT"

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(11)
}

javafx {
    modules("javafx.controls")
    setConfigurations(arrayOf("testImplementation", "compileOnly"))
}

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}
