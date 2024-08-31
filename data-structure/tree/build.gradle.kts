plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.assertj.core)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

sourceSets {
    main {
        java {
            srcDirs("java/src/main")
        }
    }

    test {
        java {
            srcDirs("java/src/test")
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}