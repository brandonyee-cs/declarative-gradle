plugins {
    id("org.gradle.kmp-prototype")
}

kmpLibrary {
    dependencies {
        api("org:foo:1.0")
    }
}